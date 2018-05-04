package hu.restoffice.transaction.controller;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.web.DefaultController;
import hu.restoffice.transaction.converter.ExpenseConverterService;
import hu.restoffice.transaction.domain.ExpenseStub;
import hu.restoffice.transaction.service.ExpenseService;

/**
 *
 */
@RestController
@RequestMapping(path = "/expense", produces = MediaType.APPLICATION_JSON)
public class ExpenseControllerImpl implements ExpenseController {

    @Autowired
    private DefaultController expenseControllerDefault;

    /**
     * @param stub
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#addResource(java.lang.Object)
     */
    @Override
    public ResponseEntity<?> addResource(@RequestBody final ExpenseStub stub) throws ServiceException {
        return expenseControllerDefault.addResource(stub);
    }

    /**
     * @param id
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#deleteResource(java.lang.Long)
     */
    @Override
    public ResponseEntity<Object> deleteResource(@PathVariable("id") final Long id) throws ServiceException {
        return expenseControllerDefault.deleteResource(id);
    }

    /**
     * @param id
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#findResourceById(java.lang.Long)
     */
    @Override
    public ResponseEntity<Object> findResourceById(@PathVariable("id") final Long id) throws ServiceException {
        return expenseControllerDefault.findResourceById(id);
    }

    /**
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#findallResource()
     */
    @Override
    public ResponseEntity<List<?>> findallResource() throws ServiceException {
        return expenseControllerDefault.findallResource();
    }

    /**
     * @return
     * @see hu.restoffice.commons.web.DefaultController#getConverter()
     */
    public ExpenseConverterService converter() {
        return (ExpenseConverterService) expenseControllerDefault.getConverter();
    }

    /**
     * @return
     * @see hu.restoffice.commons.web.DefaultController#getService()
     */
    public ExpenseService service() {
        return (ExpenseService) expenseControllerDefault.getService();
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
            @RequestBody final ExpenseStub stub)
                    throws ServiceException {
        return expenseControllerDefault.updateResource(id, stub);
    }

    @Override
    @GetMapping(params = "docId")
    public ResponseEntity<ExpenseStub> getById(@RequestParam("docId") final @NotBlank String docId)
            throws ServiceException {
        return ResponseEntity.ok(converter().from(service().findyByDocId(docId)));
    }

    @Override
    @GetMapping(path = "/{id}/partner")
    public ResponseEntity<ExpenseStub> getPartner(@PathVariable("id") final Long id,
            @RequestHeader(HttpHeaders.AUTHORIZATION) final String authToken) throws ServiceException {
        Long partnerId = service().findById(id).getParty().getId();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ServletUriComponentsBuilder.fromCurrentContextPath().path("/partner/{id}")
                .buildAndExpand(partnerId).toUri());
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).headers(headers).build();
    }


}
