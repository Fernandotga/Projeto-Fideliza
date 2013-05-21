package br.com.fideliza.app.business;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fideliza.app.exception.CommonException;
import br.com.fideliza.app.model.Empresa;
import br.com.fideliza.app.repository.EmpresaRepository;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Component
public class EmpresaBusiness extends GenericBusiness<Empresa> implements EmpresaRepository {
    
    public EmpresaBusiness(EntityManager manager) {
        super(manager);
    }
    
    @Override
    public Boolean isMailExist(Empresa entity) {
        try {
            Query query = manager.createQuery("select id from " + Empresa.class.getName() + " where email = :email and (:id is null or id != :id)");
            query.setParameter("email", entity.getEmail());
            query.setParameter("id", entity.getId());
            return (query.getSingleResult() != null);
        } catch (NoResultException e) {
            return false;
        }
    }
    
    @Override
    public Empresa save(Empresa entity) throws CommonException {
        if (this.isMailExist(entity)) {
            throw new CommonException("email.ja.cadastrado");
        }
        
        return super.save(entity);
    }
}
