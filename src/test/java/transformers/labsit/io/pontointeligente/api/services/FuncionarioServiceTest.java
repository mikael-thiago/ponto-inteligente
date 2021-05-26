package transformers.labsit.io.pontointeligente.api.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.lenient;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import transformers.labsit.io.pontointeligente.api.entities.Funcionario;
import transformers.labsit.io.pontointeligente.api.repositories.FuncionariosRepository;

@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioServiceTest {
  @Autowired
  private FuncionarioService funcionarioService;

  @MockBean
  private FuncionariosRepository funcionariosRepository;

  @Test
  void persistir() {
    lenient().when(funcionariosRepository.save(any(Funcionario.class))).thenReturn(new Funcionario());

    Funcionario funcionario = funcionarioService.persistir(new Funcionario());

    assertNotNull(funcionario);
  }

  @Test
  void buscarPorCpf() {
    lenient().when(funcionariosRepository.findByCpf(anyString())).thenReturn(Optional.of(new Funcionario()));
    Optional<Funcionario> funcionario = funcionarioService.buscarPorCpf("");

    assertTrue(funcionario.isPresent());
  }

  @Test
  void buscarPorEmail() {
    lenient().when(funcionariosRepository.findByEmail(anyString())).thenReturn(Optional.of(new Funcionario()));
    Optional<Funcionario> funcionario = funcionarioService.buscarPorEmail("");

    assertTrue(funcionario.isPresent());
  }

  @Test
  void buscarPorId() {
    lenient().when(funcionariosRepository.findById(anyLong())).thenReturn(Optional.of(new Funcionario()));
    Optional<Funcionario> funcionario = funcionarioService.buscarPorId(1L);

    assertTrue(funcionario.isPresent());
  }
}
