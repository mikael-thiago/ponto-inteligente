package transformers.labsit.io.pontointeligente.api.repositories;

import java.util.List;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import transformers.labsit.io.pontointeligente.api.entities.Lancamento;

@Transactional(readOnly = true)
@NamedQueries({
        @NamedQuery(name = "LancamentosRepository.findByFuncionarioId", query = "SELECT l FROM lancamentos l WHERE l.funcionario.id = :funcionarioId") })
public interface LancamentosRepository extends JpaRepository<Lancamento, Long> {

    List<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);

    Page<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId, Pageable pageable);
}
