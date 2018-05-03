package hu.restoffice.cashregister.service;

import java.time.LocalDate;
import java.util.List;

import hu.restoffice.cashregister.entity.RegisterClose;
import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.service.CRUDService;

/**
 *
 */
public interface RegisterCloseService extends CRUDService<RegisterClose> {

    List<RegisterClose> getClosesByDate(LocalDate day) throws ServiceException;

    List<RegisterClose> getLastCloses() throws ServiceException;

    List<RegisterClose> getClosesBetweenDate(LocalDate form, LocalDate to) throws ServiceException;

}
