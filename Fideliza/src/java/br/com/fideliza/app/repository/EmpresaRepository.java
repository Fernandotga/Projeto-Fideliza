package br.com.fideliza.app.repository;

import br.com.fideliza.app.model.Empresa;

public interface EmpresaRepository extends GenericRepository<Empresa> {

    Boolean isMailExist(Empresa entity);
}
