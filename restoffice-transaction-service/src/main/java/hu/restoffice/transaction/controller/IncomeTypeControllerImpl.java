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
import hu.restoffice.transaction.converter.IncomeTypeConverterService;
import hu.restoffice.transaction.domain.IncomeTypeStub;
import hu.restoffice.transaction.service.IncomeTypeService;

/**
 *
 */
@RestController
@RequestMapping(path = "/misc/income-type", produces = MediaType.APPLICATION_JSON)
public class IncomeTypeControllerImpl implements IncomeTypeController {

    @Autowired
    private DefaultController incomeTypeControllerDefault;

    /**
     * @param stub
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#addResource(java.lang.Object)
     */
    @Override
    public ResponseEntity<?> addResource(@RequestBody final IncomeTypeStub stub) throws ServiceException {
        return incomeTypeControllerDefault.addResource(stub);
    }

    /**
     * @param id
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#deleteResource(java.lang.Long)
     */
    @Override
    public ResponseEntity<Object> deleteResource(@PathVariable("id") final Long id) throws ServiceException {
        return incomeTypeControllerDefault.deleteResource(id);
    }

    /**
     * @param id
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#findResourceById(java.lang.Long)
     */
    @Override
    public ResponseEntity<Object> findResourceById(@PathVariable("id") final Long id) throws ServiceException {
        return incomeTypeControllerDefault.findResourceById(id);
    }

    /**
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#findallResource()
     */
    @Override
    public ResponseEntity<List<?>> findallResource() throws ServiceException {
        return incomeTypeControllerDefault.findallResource();
    }

    /**
     * @return
     * @see hu.restoffice.commons.web.DefaultController#getConverter()
     */
    public IncomeTypeConverterService converter() {
        return (IncomeTypeConverterService) incomeTypeControllerDefault.getConverter();
    }

    /**
     * @return
     * @see hu.restoffice.commons.web.DefaultController#getService()
     */
    public IncomeTypeService service() {
        return (IncomeTypeService) incomeTypeControllerDefault.getService();
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
    public ResponseEntity<Object> updateResource(@PathVariable("id") final Long id,
            @RequestBody final IncomeTypeStub stub)
            throws ServiceException {
        return incomeTypeControllerDefault.updateResource(id, stub);
    }

    @Override
    @GetMapping(params = "prodRelated")
    public ResponseEntity<List<IncomeTypeStub>> findAll(@RequestParam("prodRelated") final Boolean prodRelated)
            throws ServiceException {
        return ResponseEntity.ok(converter().from(service().findAll(prodRelated)));
    }

    @Override
    @GetMapping(params = "name")
    public ResponseEntity<IncomeTypeStub> findByName(@RequestParam("name") final String name) throws ServiceException {
        return ResponseEntity.ok(converter().from(service().findByName(name)));
    }
}
