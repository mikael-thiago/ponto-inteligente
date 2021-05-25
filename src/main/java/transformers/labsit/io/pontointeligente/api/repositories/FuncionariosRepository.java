package transformers.labsit.io.pontointeligente.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import transformers.labsit.io.pontointeligente.api.entities.Funcionario;

@Transactional(readOnly = true)
public interface FuncionariosRepository extends JpaRepository<Funcionario, Long> {
    Optional<Funcionario> findByCpf(String cpf);

    Optional<Funcionario> findByEmail(String email);

    Optional<Funcionario> findByCpfOrEmail(String cpf, String email);
}
