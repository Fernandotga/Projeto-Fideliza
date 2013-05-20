package br.com.fideliza.app.repository;

import br.com.fideliza.app.exception.CommonException;
import br.com.fideliza.app.model.AbstractEntity;
import java.util.Collection;

public interface GenericRepository<T extends AbstractEntity> {

    Collection<T> all();

    T find(Long id);

    void remove(T entity);

    T save(T entity) throws CommonException;
}
