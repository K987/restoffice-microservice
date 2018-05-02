package hu.restoffice.commons;

import java.util.List;

/**
 *
 */
public interface CRUDService<T> {

    T add(final T entity) throws ServiceException;

    T findById(final Long id) throws ServiceException;

    List<T> findAll() throws ServiceException;

    T update(final Long id, final T entity) throws ServiceException;

    T delete(final Long id) throws ServiceException;

}