package hu.restoffice.commons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.error.ServiceException.Type;

/**
 *
 */
@Transactional(propagation = Propagation.REQUIRES_NEW)
public abstract class AbstractCRUDService<T, R extends JpaRepository<T, Long>> {

    @Autowired
    protected R repo;


    public T add(final T entity) throws ServiceException {
        if (checkExistence(entity)) {
            throw new ServiceException(Type.ALREADY_EXISTS, "entity already exists with the same name", entity);
        } else {
            try {
                return repo.saveAndFlush(entity);
            } catch (Exception e) {
                throw new ServiceException(Type.UNKNOWN);
            }
        }
    }

    public List<T> findAll() throws ServiceException{
        try {
            return repo.findAll();
        } catch (Exception e) {
            throw new ServiceException(Type.UNKNOWN, "error when retriving all entites", e.getLocalizedMessage());
        }
    }

    public T findById(final Long id) throws ServiceException {
        return repo.findById(id).orElseThrow(
                () -> new ServiceException(Type.NOT_EXISTS, "entity not exists you might want to create it", id));
    }


    public T update(final Long id, final T entity) throws ServiceException {
        T old = this.findById(id);
        updateFields(old, entity);
        return saveAndFlush(old);
    }

    public T delete(final Long id) throws ServiceException {
        T toDel = this.findById(id);
        try {
            repo.deleteById(id);
        } catch (Exception e) {
            throw new ServiceException(Type.UNKNOWN, "error when deleting entity", id);
        }
        return toDel;
    }

    protected T saveAndFlush(final T entity) throws ServiceException {
        try {
            return repo.saveAndFlush(entity);
        } catch (Exception e) {
            throw new ServiceException(Type.UNKNOWN, "unknown error occured when saving new entity", entity);
        }
    }
    /**
     * @param entity
     * @return
     */
    protected abstract boolean checkExistence(final T entity);

    /**
     * @param old
     * @param entity
     */
    protected abstract void updateFields(final T old, final T entity);
}
