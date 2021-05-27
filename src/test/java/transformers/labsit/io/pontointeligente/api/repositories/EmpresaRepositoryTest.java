package transformers.labsit.io.pontointeligente.api.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import transformers.labsit.io.pontointeligente.api.entities.Empresa;

@SpringBootTest
@ActiveProfiles("test")
public class EmpresaRepositoryTest {

    @Autowired
    private EmpresasRepository empresasRepository;

    @Test
    void findByCnpj() {
        String cnpj = "51336522000108";
        Empresa empresa = new Empresa();
        empresa.setCnpj(cnpj);
        empresa.setRazaoSocial("Razão Social");

        empresasRepository.save(empresa);

        Optional<Empresa> opEmpresa = empresasRepository.findByCnpj(cnpj);

        assertTrue(opEmpresa.isPresent());

        Empresa empRep = opEmpresa.get();

        assertEquals(empresa, empRep);
    }
}
