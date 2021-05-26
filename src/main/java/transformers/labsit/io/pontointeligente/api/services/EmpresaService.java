package transformers.labsit.io.pontointeligente.api.services;

import java.util.Optional;

import transformers.labsit.io.pontointeligente.api.entities.Empresa;

public interface EmpresaService {
  /**
   * Retorna uma empresa dado um CNPJ
   * 
   * @param cnpj
   * @return
   */
  Optional<Empresa> buscarPorCnpj(String cnpj);

  /**
   * Cadastra uma nova empresa no banco de dados.
   * 
   * @param empresa
   * @return
   */
  Empresa persistir(Empresa empresa);
}
