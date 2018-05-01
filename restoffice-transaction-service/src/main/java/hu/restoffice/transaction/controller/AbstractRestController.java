package hu.restoffice.transaction.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;

import hu.restoffice.transaction.error.ServiceException;

/**
 *
 */
public abstract class AbstractRestController<T> {

    protected ResponseEntity<List<T>> findAllResource() throws ServiceException {
        List<Object> objects = findAllEntity();
        List<T> stubs = from(objects);
        return ResponseEntity.ok(stubs);

    }

    protected ResponseEntity<?> createResource(final T stub) throws ServiceException {
        Object o = to(stub);
        T result = from(create(o));
        return ResponseEntity.created(createSourceUri(result)).build();

    }


    protected ResponseEntity<T> getResourceById(final Long id) throws ServiceException {
        return ResponseEntity.ok(from(findById(id)));
    }

    protected ResponseEntity<T> deleteResource(final Long id) throws ServiceException {
        return ResponseEntity.ok(from(delete(id)));
    }

    protected ResponseEntity<T> updateResource(final Long id, final T stub) throws ServiceException {
        return ResponseEntity.ok(from(update(id, to(stub))));
    }

    /**
     * @param objects
     * @return
     */
    protected  List<T> from(final List<Object> objects){
        return objects.stream().map(o -> from(o)).collect(Collectors.toList());
    }

    protected abstract T from(final Object object);

    protected abstract List<Object> findAllEntity();

    protected abstract Object to(T stub);

    protected abstract Object delete(Long id);

    protected abstract Object findById(Long id);

    protected abstract Object update(Long id, Object o);

    protected abstract Object create(Object o);

    protected abstract URI createSourceUri(Object o);
}
