package transformers.labsit.io.pontointeligente.api.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import transformers.labsit.io.pontointeligente.api.entities.Empresa;
import transformers.labsit.io.pontointeligente.api.repositories.EmpresasRepository;
import transformers.labsit.io.pontointeligente.api.services.EmpresaService;

public class EmpresaServiceImpl implements EmpresaService {

  @Autowired
  private EmpresasRepository empresasRepository;

  @Override
  public Optional<Empresa> buscarPorCnpj(String cnpj) {
    return empresasRepository.findByCnpj(cnpj);
  }

  @Override
  public Empresa persistir(Empresa empresa) {
    return empresasRepository.save(empresa);
  }

}
