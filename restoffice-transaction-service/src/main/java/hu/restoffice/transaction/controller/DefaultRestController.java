package hu.restoffice.transaction.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import hu.restoffice.transaction.error.ServiceException;

/**
 *
 */
public interface DefaultRestController<T> {

    ResponseEntity<List<T>> findAll() throws ServiceException;

    ResponseEntity<?> create(T stub) throws ServiceException;

    ResponseEntity<List<T>> findAll(Boolean technical) throws ServiceException;

    ResponseEntity<T> getById(Long id) throws ServiceException;

    ResponseEntity<T> deleteById(Long id) throws ServiceException;

    ResponseEntity<T> update(Long id, T stub) throws ServiceException;
}
