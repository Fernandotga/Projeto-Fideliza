package br.com.fideliza.app.business;

import br.com.fideliza.app.exception.CommonException;
import br.com.fideliza.app.model.AbstractEntity;
import br.com.fideliza.app.repository.GenericRepository;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class GenericBusiness<T extends AbstractEntity> implements GenericRepository<T> {

    protected final EntityManager manager;
    private final Class<T> clazz;

    protected GenericBusiness(EntityManager manager) {
        this.manager = manager;

        @SuppressWarnings("unchecked")
        Class<T> classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

        this.clazz = classe;
    }

    @Override
    public Collection<T> all() {
        Query query = manager.createQuery("from " + clazz.getName());

        @SuppressWarnings("unchecked")
        Collection<T> list = query.getResultList();

        return list;
    }

    @Override
    public T find(Long id) {
        return manager.find(clazz, id);
    }

    @Override
    public void remove(T entity) {
        manager.remove(manager.getReference(clazz, entity.getId()));
    }

    @Override
    public T save(T entity) throws CommonException {
        return manager.merge(entity);
    }
}
