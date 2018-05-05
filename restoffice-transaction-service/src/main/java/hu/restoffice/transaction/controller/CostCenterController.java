package hu.restoffice.transaction.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.web.CRUDController;
import hu.restoffice.transaction.domain.CostCenterStub;

/**
 *
 */
public interface CostCenterController extends CRUDController<CostCenterStub> {

    /**
     * @return
     * @throws ServiceException
     */
    @GetMapping("/default")
    ResponseEntity<CostCenterStub> findDefault() throws ServiceException;

    /**
     * @param name
     * @return
     * @throws ServiceException
     */
    @GetMapping(params = "name")
    ResponseEntity<CostCenterStub> findByName(@RequestParam("name") String name) throws ServiceException;


}


