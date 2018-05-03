package hu.restoffice.commons.web;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;

import hu.restoffice.commons.entity.Identity;
import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.error.ServiceException.Type;
import hu.restoffice.commons.service.CRUDService;
import hu.restoffice.commons.service.DefaultConverterService;

/**
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class DefaultController {

    private CRUDService service;
    private DefaultConverterService converter;

    private static final Logger log = LogManager.getLogger();

    /**
     * @param converter
     * @param service
     */
    public DefaultController(final CRUDService service, final DefaultConverterService converter) {
        super();
        this.converter = converter;
        this.service = service;
    }

    public ResponseEntity<List<?>> findallResource() throws ServiceException {
        return ResponseEntity.ok(converter.from(service.findAll()));
    }

    public ResponseEntity<Object> findResourceById(final Long id) throws ServiceException {
        return ResponseEntity.ok(converter.from(service.findById(id)));
    }

    public ResponseEntity<?> addResource(final Object stub) throws ServiceException {
        Object entity = service.add(converter.to(stub));
        Long id = getId(entity);
        return ResponseEntity.created(ControllerUtils.createPathTo(id)).build();

    }

    public ResponseEntity<Object> updateResource(final Long id, final Object stub) throws ServiceException {
        return ResponseEntity.ok(converter.from(service.update(id, converter.to(stub))));
    }

    public ResponseEntity<Object> deleteResource(final Long id) throws ServiceException {
        return ResponseEntity.ok(converter.from(service.delete(id)));
    }

    /**
     * @param entity
     * @return
     * @throws ServiceException
     */
    private Long getId(final Object entity) throws ServiceException {
        if (entity instanceof Identity)
            return ((Identity) entity).getId();
        else {
            log.error("The entity does not iplement Identity interface... cant get id" + entity.getClass());
            throw new ServiceException(Type.CANT_GET_ID, "the object may exists but can't get identity", entity);
        }
    }

    /**
     * @return the service
     */
    public CRUDService getService() {
        return service;
    }

    /**
     * @return the converter
     */
    public DefaultConverterService getConverter() {
        return converter;
    }
}
