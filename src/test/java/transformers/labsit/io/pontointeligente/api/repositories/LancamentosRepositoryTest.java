package transformers.labsit.io.pontointeligente.api.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import transformers.labsit.io.pontointeligente.api.entities.Empresa;
import transformers.labsit.io.pontointeligente.api.entities.Funcionario;
import transformers.labsit.io.pontointeligente.api.entities.Lancamento;
import transformers.labsit.io.pontointeligente.api.enums.PerfilEnum;
import transformers.labsit.io.pontointeligente.api.enums.TipoEnum;

@SpringBootTest
@ActiveProfiles("test")
public class LancamentosRepositoryTest {

  @Autowired
  private LancamentosRepository lancamentosRepository;
  @Autowired
  private EmpresasRepository empresasRepository;
  @Autowired
  private FuncionariosRepository funcionariosRepository;

  private String cnpjEmpresa = "51336522000108", razaoSocialEmpresa = "Razão Social";
  private Empresa empresa;

  private String cpfFuncionario = "1234567912", emailFuncionario = "mail@mail.com", nomeFuncionario = "Nome";
  private Long idFuncionario = 1L;
  private static Funcionario funcionario;

  private Date dataLancamento = new Date(2000, 5, 1);
  private String descricao = "descricao", localizacao = "localização";

  private static boolean primeiro = true;

  @BeforeEach
  void beforeEach() {
    if (!primeiro)
      return;

    empresa = new Empresa();
    empresa.setCnpj(cnpjEmpresa);
    empresa.setRazaoSocial(razaoSocialEmpresa);

    empresasRepository.save(empresa);

    funcionario = new Funcionario();
    funcionario.setId(idFuncionario);
    funcionario.setCpf(cpfFuncionario);
    funcionario.setEmail(emailFuncionario);
    funcionario.setNome(nomeFuncionario);
    funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
    funcionario.setSenha("senha");

    funcionariosRepository.save(funcionario);

    primeiro = false;

  }

  @AfterEach
  void afterEach() {
    lancamentosRepository.deleteAll();
  }

  @Nested
  class FindByFuncionarioId {
    @Test
    void quandoExiste() {
      Lancamento lancamento = new Lancamento();
      lancamento.setData(dataLancamento);
      lancamento.setDescricao(descricao);
      lancamento.setFuncionario(funcionario);
      lancamento.setLocalizacao(localizacao);
      lancamento.setTipo(TipoEnum.INICIO_ALMOCO);
      lancamento.setId(1L);

      lancamentosRepository.save(lancamento);

      List<Lancamento> lancamentos = lancamentosRepository.findByFuncionarioId(funcionario.getId());

      assertEquals(1, lancamentos.size());

      // assertEquals(lancamentos.get(0), lancamento);
    }

    @Test
    void quandoNaoExiste() {
      List<Lancamento> lancamentos = lancamentosRepository.findByFuncionarioId(funcionario.getId());

      assertEquals(0, lancamentos.size());
    }

    @Test
    void paginacao() {
      Lancamento lancamento = new Lancamento();
      lancamento.setData(dataLancamento);
      lancamento.setDescricao(descricao);
      lancamento.setFuncionario(funcionario);
      lancamento.setLocalizacao(localizacao);
      lancamento.setTipo(TipoEnum.INICIO_ALMOCO);
      lancamento.setDataCriacao(dataLancamento);
      lancamento.setId(1L);

      Lancamento lancamento2 = new Lancamento();
      lancamento2.setData(dataLancamento);
      lancamento2.setDescricao(descricao);
      lancamento2.setFuncionario(funcionario);
      lancamento2.setLocalizacao(localizacao);
      lancamento2.setTipo(TipoEnum.INICIO_ALMOCO);
      lancamento2.setDataCriacao(dataLancamento);
      lancamento2.setId(2L);

      Lancamento lancamento3 = new Lancamento();
      lancamento3.setData(dataLancamento);
      lancamento3.setDescricao(descricao);
      lancamento3.setFuncionario(funcionario);
      lancamento3.setLocalizacao(localizacao);
      lancamento3.setDataCriacao(dataLancamento);
      lancamento3.setTipo(TipoEnum.INICIO_ALMOCO);
      lancamento3.setId(3L);

      Lancamento lancamento4 = new Lancamento();
      lancamento4.setData(dataLancamento);
      lancamento4.setDescricao(descricao);
      lancamento4.setFuncionario(funcionario);
      lancamento4.setLocalizacao(localizacao);
      lancamento4.setDataCriacao(dataLancamento);
      lancamento4.setTipo(TipoEnum.INICIO_ALMOCO);
      lancamento4.setId(4L);

      Lancamento lancamento5 = new Lancamento();
      lancamento5.setData(dataLancamento);
      lancamento5.setDescricao(descricao);
      lancamento5.setFuncionario(funcionario);
      lancamento5.setLocalizacao(localizacao);
      lancamento5.setDataCriacao(dataLancamento);
      lancamento5.setTipo(TipoEnum.INICIO_ALMOCO);
      lancamento5.setId(5L);

      lancamentosRepository.save(lancamento);
      lancamentosRepository.save(lancamento2);
      lancamentosRepository.save(lancamento3);
      lancamentosRepository.save(lancamento4);
      lancamentosRepository.save(lancamento5);

      Pageable pageable = PageRequest.of(0, 2);

      Page<Lancamento> lancamentos = lancamentosRepository.findByFuncionarioId(funcionario.getId(), pageable);

      assertEquals(2, lancamentos.getNumberOfElements());

      Pageable pageable2 = PageRequest.of(1, 2);

      Page<Lancamento> lancamentos2 = lancamentosRepository.findByFuncionarioId(funcionario.getId(), pageable2);

      assertEquals(2, lancamentos2.getNumberOfElements());

      assertFalse(lancamentos2.hasNext());

      assertEquals(lancamentos2.get().toList().get(0).getFuncionario().getId(), funcionario.getId());

    }
  }

}
