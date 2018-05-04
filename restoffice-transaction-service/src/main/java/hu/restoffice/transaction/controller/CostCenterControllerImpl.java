package hu.restoffice.transaction.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.web.DefaultController;
import hu.restoffice.transaction.converter.CostCenterConverterService;
import hu.restoffice.transaction.domain.CostCenterStub;
import hu.restoffice.transaction.service.CostCenterService;

/**
 *
 */
@RestController
@RequestMapping(path = "/misc/cost-center", produces = MediaType.APPLICATION_JSON)
public class CostCenterControllerImpl implements CostCenterController {

    @Autowired
    private DefaultController costCenterControllerDefault;

    /**
     * @param stub
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#addResource(java.lang.Object)
     */
    @Override
    public ResponseEntity<?> addResource(final @RequestBody CostCenterStub stub) throws ServiceException {
        return costCenterControllerDefault.addResource(stub);
    }

    /**
     * @param id
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#deleteResource(java.lang.Long)
     */
    @Override
    public ResponseEntity<Object> deleteResource(@PathVariable("Id") final Long id) throws ServiceException {
        return costCenterControllerDefault.deleteResource(id);
    }

    /**
     * @param id
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#findResourceById(java.lang.Long)
     */
    @Override
    public ResponseEntity<Object> findResourceById(@PathVariable("Id") final Long id) throws ServiceException {
        return costCenterControllerDefault.findResourceById(id);
    }

    /**
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#findallResource()
     */
    @Override
    public ResponseEntity<List<?>> findallResource() throws ServiceException {
        return costCenterControllerDefault.findallResource();
    }

    /**
     * @return
     * @see hu.restoffice.commons.web.DefaultController#getConverter()
     */
    public CostCenterConverterService converter() {
        return (CostCenterConverterService) costCenterControllerDefault.getConverter();
    }

    /**
     * @return
     * @see hu.restoffice.commons.web.DefaultController#getService()
     */
    public CostCenterService service() {
        return (CostCenterService) costCenterControllerDefault.getService();
    }

    /**
     * @param id
     * @param stub
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#updateResource(java.lang.Long,
     *      java.lang.Object)
     */
    @Override
    public ResponseEntity<Object> updateResource(@PathVariable("Id") final Long id,
            @RequestBody final CostCenterStub stub)
            throws ServiceException {
        return costCenterControllerDefault.updateResource(id, stub);
    }

    @Override
    @GetMapping("/default")
    public ResponseEntity<CostCenterStub> findDefault() throws ServiceException {
        return ResponseEntity.ok(converter().from(service().getDefault()));
    }

    @Override
    @GetMapping(params = "name")
    public ResponseEntity<CostCenterStub> findByName(@RequestParam("name") final String name) throws ServiceException {
        return ResponseEntity.ok(converter().from(service().findByName(name)));
    }
}
