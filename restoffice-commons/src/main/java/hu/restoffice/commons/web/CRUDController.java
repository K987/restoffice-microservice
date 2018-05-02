package hu.restoffice.commons.web;

import javax.validation.constraints.Digits;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import hu.restoffice.commons.error.ServiceException;

/**
 *
 */
public interface CRUDController<T> {

    @GetMapping
    ResponseEntity<?> findallResource() throws ServiceException;

    @GetMapping("/{id}")
    ResponseEntity<?> findResourceById(final @PathVariable("id") @Digits(fraction = 0, integer = 10) Long id)
            throws ServiceException;

    @PostMapping(consumes = "application/json")
    ResponseEntity<?> addResource(final @RequestBody @Validated T stub) throws ServiceException;

    @PostMapping(consumes = "application/json", path = "/{id}")
    ResponseEntity<?> updateResource(final @PathVariable("id") @Digits(fraction = 0, integer = 10) Long id,
            final @RequestBody @Validated T stub) throws ServiceException;

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteResource(final @PathVariable("id") @Digits(fraction = 0, integer = 10) Long id)
            throws ServiceException;
}
