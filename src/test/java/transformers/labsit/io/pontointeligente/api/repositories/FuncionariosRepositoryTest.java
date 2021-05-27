package transformers.labsit.io.pontointeligente.api.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import transformers.labsit.io.pontointeligente.api.entities.Empresa;
import transformers.labsit.io.pontointeligente.api.entities.Funcionario;
import transformers.labsit.io.pontointeligente.api.enums.PerfilEnum;

@SpringBootTest
@ActiveProfiles("test")
public class FuncionariosRepositoryTest {

    @Autowired
    private EmpresasRepository empresasRepository;

    @Autowired
    private FuncionariosRepository funcionariosRepository;

    private String cpf = "1234567912", email = "mail@mail.com", nome = "Nome";
    private String razaoSocialEmpresa = "Razão Social", cnpjEmpresa = "51463645000100";

    @BeforeEach
    void beforeEach() {
        Empresa empresa = new Empresa();

        empresa.setRazaoSocial(razaoSocialEmpresa);
        empresa.setCnpj(cnpjEmpresa);

        empresasRepository.save(empresa);

        Funcionario funcionario = new Funcionario();
        funcionario.setCpf(cpf);
        funcionario.setEmail(email);
        funcionario.setNome(nome);
        funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
        funcionario.setSenha("senha");
        funcionario.setEmpresa(empresa);

        funcionariosRepository.save(funcionario);
    }

    @AfterEach
    void afterEach() {
        funcionariosRepository.deleteAll();
    }

    @Test
    void findByCpf() {
        Optional<Funcionario> opFun = funcionariosRepository.findByCpf(cpf);

        assertTrue(opFun.isPresent());

        Funcionario funcionario = opFun.get();

        assertEquals(cpf, funcionario.getCpf());
        assertEquals(email, funcionario.getEmail());
    }

    @Test
    void findByEmail() {
        Optional<Funcionario> opFun = funcionariosRepository.findByEmail(email);

        assertTrue(opFun.isPresent());

        Funcionario funcionario = opFun.get();

        assertEquals(cpf, funcionario.getCpf());
        assertEquals(email, funcionario.getEmail());
    }

    @Nested
    class FindByCpfOrEmail {
        @Test
        void findByCpf() {
            Optional<Funcionario> opFun = funcionariosRepository.findByCpfOrEmail(cpf, null);

            assertTrue(opFun.isPresent());

            Funcionario funcionario = opFun.get();

            assertEquals(cpf, funcionario.getCpf());
            assertEquals(email, funcionario.getEmail());
        }

        @Test
        void findByEmail() {
            Optional<Funcionario> opFun = funcionariosRepository.findByCpfOrEmail(null, email);

            assertTrue(opFun.isPresent());

            Funcionario funcionario = opFun.get();

            assertEquals(cpf, funcionario.getCpf());
            assertEquals(email, funcionario.getEmail());
        }

        @Test
        void findByBoth() {
            Optional<Funcionario> opFun = funcionariosRepository.findByCpfOrEmail(cpf, email);

            assertTrue(opFun.isPresent());

            Funcionario funcionario = opFun.get();

            assertEquals(cpf, funcionario.getCpf());
            assertEquals(email, funcionario.getEmail());
        }
    }

}
