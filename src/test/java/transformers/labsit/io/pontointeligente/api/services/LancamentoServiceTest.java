package transformers.labsit.io.pontointeligente.api.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.lenient;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import transformers.labsit.io.pontointeligente.api.entities.Funcionario;
import transformers.labsit.io.pontointeligente.api.entities.Lancamento;
import transformers.labsit.io.pontointeligente.api.repositories.LancamentosRepository;

@SpringBootTest
@ActiveProfiles("test")
public class LancamentoServiceTest {
  @Autowired
  private LancamentoService lancamentoService;

  @MockBean
  private LancamentosRepository lancamentosRepository;

  void buscarPorFuncionarioId() {
    lenient().when(lancamentosRepository.findByFuncionarioId(anyLong(), any()))
        .thenReturn(new PageImpl<Lancamento>(new ArrayList<Lancamento>()));

    Page<Lancamento> lancamentos = lancamentoService.buscarPorFuncionarioId(1L, PageRequest.of(0, 0));

    assertNotNull(lancamentos);
  }

  void buscarPorId() {
    lenient().when(lancamentosRepository.findById(anyLong())).thenReturn(Optional.of(new Lancamento()));

    Optional<Lancamento> lancamento = lancamentoService.buscarPorId(1L);

    assertTrue(lancamento.isPresent());
  }

  void persistir() {
    lenient().when(lancamentosRepository.save(any())).thenReturn(new Funcionario());

    Lancamento lancamento = lancamentoService.persistir(new Lancamento());

    assertNotNull(lancamento);
  }
}
