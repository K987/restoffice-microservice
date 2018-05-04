package hu.restoffice.transaction.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.web.DefaultController;
import hu.restoffice.transaction.converter.IncomeConverterService;
import hu.restoffice.transaction.domain.IncomeStub;
import hu.restoffice.transaction.service.IncomeService;

/**
 *
 */
@RestController
@RequestMapping(path = "/income", produces = MediaType.APPLICATION_JSON)
public class IncomeControllerImpl implements IncomeController {

    @Autowired
    private DefaultController incomeControllerDefault;

    /**
     * @param stub
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#addResource(java.lang.Object)
     */
    @Override
    public ResponseEntity<?> addResource(@RequestBody final IncomeStub stub) throws ServiceException {
        return incomeControllerDefault.addResource(stub);
    }

    /**
     * @param id
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#deleteResource(java.lang.Long)
     */
    @Override
    public ResponseEntity<Object> deleteResource(@PathVariable("id") final Long id) throws ServiceException {
        return incomeControllerDefault.deleteResource(id);
    }

    /**
     * @param id
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#findResourceById(java.lang.Long)
     */
    @Override
    public ResponseEntity<Object> findResourceById(@PathVariable("id") final Long id) throws ServiceException {
        return incomeControllerDefault.findResourceById(id);
    }

    /**
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#findallResource()
     */
    @Override
    public ResponseEntity<List<?>> findallResource() throws ServiceException {
        return incomeControllerDefault.findallResource();
    }

    /**
     * @return
     * @see hu.restoffice.commons.web.DefaultController#getConverter()
     */
    public IncomeConverterService converter() {
        return (IncomeConverterService) incomeControllerDefault.getConverter();
    }

    /**
     * @return
     * @see hu.restoffice.commons.web.DefaultController#getService()
     */
    public IncomeService service() {
        return (IncomeService) incomeControllerDefault.getService();
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
    public ResponseEntity<Object> updateResource(@PathVariable("id") final Long id, @RequestBody final IncomeStub stub)
            throws ServiceException {
        return incomeControllerDefault.updateResource(id, stub);
    }

    @Override
    public ResponseEntity<IncomeStub> getPartner(@PathVariable("id") final Long id,
            @RequestHeader(HttpHeaders.AUTHORIZATION) final String authToken) throws ServiceException {
        Long partnerId = service().findById(id).getParty().getId();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ServletUriComponentsBuilder.fromCurrentContextPath().path("/partner/{id}")
                .buildAndExpand(partnerId).toUri());
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).headers(headers).build();
    }



}
