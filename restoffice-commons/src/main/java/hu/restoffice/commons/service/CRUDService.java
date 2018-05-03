package hu.restoffice.commons.service;

import java.util.List;

import hu.restoffice.commons.error.ServiceException;

/**
 *
 */
// @Transactional(propagation = Propagation.REQUIRES_NEW)
public interface CRUDService<T> {

    T add(final T entity) throws ServiceException;

    T findById(final Long id) throws ServiceException;

    List<T> findAll() throws ServiceException;

    T update(final Long id, final T entity) throws ServiceException;

    T delete(final Long id) throws ServiceException;

}