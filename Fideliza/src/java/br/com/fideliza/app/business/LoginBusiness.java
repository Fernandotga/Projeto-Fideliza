package br.com.fideliza.app.business;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fideliza.app.model.Empresa;
import br.com.fideliza.app.repository.LoginRepository;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.apache.log4j.Logger;

@Component
public class LoginBusiness implements LoginRepository {

    private EntityManager manager;
    private static Logger log = Logger.getLogger(LoginBusiness.class);

    public LoginBusiness(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Empresa autenticar(String email, String senha) {
        try {
            Query query = manager.createQuery("from " + Empresa.class.getName() + " where email = :email and senha = :senha");
            query.setParameter("email", email);
            query.setParameter("senha", senha);
            return (Empresa) query.getSingleResult();
        } catch (NoResultException ex) {
            log.error(ex);
            return null;
        }
    }
}
