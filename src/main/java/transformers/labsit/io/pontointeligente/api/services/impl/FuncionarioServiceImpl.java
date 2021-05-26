package transformers.labsit.io.pontointeligente.api.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import transformers.labsit.io.pontointeligente.api.entities.Funcionario;
import transformers.labsit.io.pontointeligente.api.repositories.FuncionariosRepository;
import transformers.labsit.io.pontointeligente.api.services.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

  @Autowired
  private FuncionariosRepository funcionariosRepository;

  @Override
  public Funcionario persistir(Funcionario funcionario) {
    return funcionariosRepository.save(funcionario);
  }

  @Override
  public Optional<Funcionario> buscarPorCpf(String cpf) {
    return funcionariosRepository.findByCpf(cpf);
  }

  @Override
  public Optional<Funcionario> buscarPorEmail(String email) {
    return funcionariosRepository.findByEmail(email);
  }

  @Override
  public Optional<Funcionario> buscarPorId(Long id) {
    return funcionariosRepository.findById(id);
  }

}
