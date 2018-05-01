package hu.restoffice.transaction.service;

import java.util.List;

import hu.restoffice.transaction.error.ServiceException;

/**
 *
 */
public interface CrudService<T> {

    T add(final T entity) throws ServiceException;

    T findById(final Long id) throws ServiceException;

    List<T> findAll() throws ServiceException;

    T update(final Long id, final T entity) throws ServiceException;

    T delete(final Long id) throws ServiceException;

}