package hu.restoffice.commons;

import org.springframework.http.ResponseEntity;

/**
 *
 */
public class DefaultController<S extends CRUDService, C extends DefaultConverterService> {

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

    public ResponseEntity<?> findall() throws ServiceException {
        return ResponseEntity.ok(converter.from(service.findAll()));
    }

    public DefaultConverterService getConverter() {
        return converter;
    }

    public CRUDService getService() {
        return service;
    }
}
