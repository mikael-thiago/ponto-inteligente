package transformers.labsit.io.pontointeligente.api.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import transformers.labsit.io.pontointeligente.api.entities.Lancamento;
import transformers.labsit.io.pontointeligente.api.repositories.LancamentosRepository;
import transformers.labsit.io.pontointeligente.api.services.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService {

  @Autowired
  private LancamentosRepository lancamentosRepository;

  @Override
  public Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
    return lancamentosRepository.findByFuncionarioId(funcionarioId, pageRequest);
  }

  @Override
  @Cacheable("lancamentoPorId")
  public Optional<Lancamento> buscarPorId(Long id) {
    return lancamentosRepository.findById(id);
  }

  @Override
  @CachePut("lancamentoPorId")
  public Lancamento persistir(Lancamento lancamento) {
    return lancamentosRepository.save(lancamento);
  }

  @Override
  public void remover(Long id) {
    lancamentosRepository.deleteById(id);
  }

}
