package transformers.labsit.io.pontointeligente.api.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.lenient;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import transformers.labsit.io.pontointeligente.api.entities.Empresa;
import transformers.labsit.io.pontointeligente.api.repositories.EmpresasRepository;

@SpringBootTest
@ActiveProfiles("test")
public class EmpresaServiceTest {
  @MockBean
  private EmpresasRepository empresasRepository;

  @Autowired
  private EmpresaService empresaServices;

  private static final String CNPJ = "32467544000154";

  @BeforeEach
  void beforeEach() {
    lenient().when(empresasRepository.findByCnpj(anyString())).thenReturn(Optional.of(new Empresa()));
    lenient().when(empresasRepository.save(any(Empresa.class))).thenReturn(new Empresa());
  }

  @Test
  void buscarPorCnpj() {
    Optional<Empresa> empresa = empresaServices.buscarPorCnpj(CNPJ);

    assertTrue(empresa.isPresent());
  }

  @Test
  void persistirEmpresa() {
    Empresa empresa = empresaServices.persistir(new Empresa());

    assertNotNull(empresa);
  }
}
