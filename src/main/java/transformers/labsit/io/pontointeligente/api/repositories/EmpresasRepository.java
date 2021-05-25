package transformers.labsit.io.pontointeligente.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import transformers.labsit.io.pontointeligente.api.entities.Empresa;

public interface EmpresasRepository extends JpaRepository<Empresa, Long> {

    @Transactional(readOnly = true)
    Optional<Empresa> findByCnpj(String cnpj);
}
