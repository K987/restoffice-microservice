package hu.restoffice.commons;

import org.springframework.http.ResponseEntity;

/**
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class DefaultController {

    private CRUDService service;

    private DefaultConverterService converter;

    /**
     * @param converter
     * @param service
     */
    public DefaultController(final CRUDService service, final DefaultConverterService converter) {
        super();
        this.converter = converter;
        this.service = service;
    }

    public ResponseEntity<?> findallResource() throws ServiceException {
        return ResponseEntity.ok(converter.from(service.findAll()));
    }

    public ResponseEntity<?> findResourceById(final Long id) throws ServiceException {
        return ResponseEntity.ok(converter.from(service.findById(id)));
    }

    public ResponseEntity<?> addResource(final Object stub) throws ServiceException {
        Object id = service.add(converter.to(stub));
        return ResponseEntity.created(ControllerUtils.createPathTo(getId(id))).build();
    }

    public ResponseEntity<?> updateResource(final Long id, final Object stub) throws ServiceException {
        return ResponseEntity.ok(converter.from(service.update(id, converter.to(stub))));
    }

    public ResponseEntity<?> deleteResource(final Long id) throws ServiceException {
        return ResponseEntity.ok(converter.from(service.delete(id)));
    }

    /**
     * @param id
     * @return
     */
    protected abstract Long getId(Object id);
}
