package hu.restoffice.cashregister.controller;

import javax.annotation.Resource;
import javax.ws.rs.core.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.restoffice.commons.DefaultController;
import hu.restoffice.commons.ServiceException;

/**
 *
 */
@RestController
@RequestMapping(path = "/register", produces = MediaType.APPLICATION_JSON)
public class RegisterRestController {

    @Resource
    private DefaultController registerControllerDefault;

    /**
     * @return
     * @throws ServiceException
     * @see hu.restoffice.cashregister.controller.DefaultControllerConfiguration.DefaultController#findall()
     */
    @GetMapping
    public ResponseEntity<?> findall() throws ServiceException {
        return registerControllerDefault.findall();
    }


}
