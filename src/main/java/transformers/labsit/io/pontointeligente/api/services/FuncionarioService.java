package transformers.labsit.io.pontointeligente.api.services;

import java.util.Optional;

import transformers.labsit.io.pontointeligente.api.entities.Funcionario;

public interface FuncionarioService {
  /**
   * Adiciona um funcionário na base de dados.
   * 
   * @param funcionario
   * @return
   */
  Funcionario persistir(Funcionario funcionario);

  /**
   * Busca e retorna um funcionário dado o CPF.
   * 
   * @param cpf
   * @return Optional<Funcionario>
   */
  Optional<Funcionario> buscarPorCpf(String cpf);

  /**
   * Busca e retorna um funcionário dado o email.
   * 
   * @param email
   * @return Optional<Funcionario>
   */
  Optional<Funcionario> buscarPorEmail(String email);

  /**
   * Busca e retorna um funcionário da o id.
   * 
   * @param id
   * @return Optional<Funcionario>
   */
  Optional<Funcionario> buscarPorId(Long id);
}
