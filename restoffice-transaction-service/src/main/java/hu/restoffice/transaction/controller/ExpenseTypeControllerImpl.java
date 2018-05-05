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
import hu.restoffice.transaction.converter.ExpenseTypeConverterService;
import hu.restoffice.transaction.domain.ExpenseTypeStub;
import hu.restoffice.transaction.service.ExpenseTypeService;

/**
 *
 */
@RestController
@RequestMapping(path = "/misc/expense-type", produces = MediaType.APPLICATION_JSON)
public class ExpenseTypeControllerImpl implements ExpenseTypeController {

    @Autowired
    private DefaultController expenseTypeControllerDefault;

    /**
     * @param stub
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#addResource(java.lang.Object)
     */
    @Override
    public ResponseEntity<?> addResource(@RequestBody final ExpenseTypeStub stub) throws ServiceException {
        return expenseTypeControllerDefault.addResource(stub);
    }

    /**
     * @param id
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#deleteResource(java.lang.Long)
     */
    @Override
    public ResponseEntity<Object> deleteResource(@PathVariable("id") final Long id) throws ServiceException {
        return expenseTypeControllerDefault.deleteResource(id);
    }

    /**
     * @param id
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#findResourceById(java.lang.Long)
     */
    @Override
    public ResponseEntity<Object> findResourceById(@PathVariable("id") final Long id) throws ServiceException {
        return expenseTypeControllerDefault.findResourceById(id);
    }

    /**
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#findallResource()
     */
    @Override
    public ResponseEntity<List<?>> findallResource() throws ServiceException {
        return expenseTypeControllerDefault.findallResource();
    }

    /**
     * @return
     * @see hu.restoffice.commons.web.DefaultController#getConverter()
     */
    public ExpenseTypeConverterService converter() {
        return (ExpenseTypeConverterService) expenseTypeControllerDefault.getConverter();
    }

    /**
     * @return
     * @see hu.restoffice.commons.web.DefaultController#getService()
     */
    public ExpenseTypeService service() {
        return (ExpenseTypeService) expenseTypeControllerDefault.getService();
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
            @RequestBody final ExpenseTypeStub stub)
                    throws ServiceException {
        return expenseTypeControllerDefault.updateResource(id, stub);
    }

    @Override
    @GetMapping(params = "prodRelated")
    public ResponseEntity<List<ExpenseTypeStub>> findAll(@RequestParam("prodRelated") final Boolean prodRelated)
            throws ServiceException {
        return ResponseEntity.ok(converter().from(service().findAll(prodRelated)));
    }

    @Override
    @GetMapping(params = "name")
    public ResponseEntity<ExpenseTypeStub> findByName(@RequestParam("name") final String name) throws ServiceException {
        return ResponseEntity.ok(converter().from(service().findByName(name)));
    }


}
