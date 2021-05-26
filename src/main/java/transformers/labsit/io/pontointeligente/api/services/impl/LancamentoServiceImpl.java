package transformers.labsit.io.pontointeligente.api.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import transformers.labsit.io.pontointeligente.api.entities.Lancamento;
import transformers.labsit.io.pontointeligente.api.repositories.LancamentosRepository;
import transformers.labsit.io.pontointeligente.api.services.LancamentoService;

public class LancamentoServiceImpl implements LancamentoService {

  @Autowired
  private LancamentosRepository lancamentosRepository;

  @Override
  public Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
    return lancamentosRepository.findByFuncionarioId(funcionarioId, pageRequest);
  }

  @Override
  public Optional<Lancamento> buscarPorId(Long id) {
    return lancamentosRepository.findById(id);
  }

  @Override
  public Lancamento persistir(Lancamento lancamento) {
    return lancamentosRepository.save(lancamento);
  }

  @Override
  public void remover(Long id) {
    lancamentosRepository.deleteById(id);
  }

}
