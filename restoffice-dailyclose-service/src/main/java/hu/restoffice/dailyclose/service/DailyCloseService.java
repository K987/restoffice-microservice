package hu.restoffice.dailyclose.service;

import java.time.LocalDate;
import java.util.List;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.dailyclose.domain.ShiftDailyCloseStub;
import hu.restoffice.dailyclose.entity.RegisterDailyClose;
import hu.restoffice.dailyclose.entity.ShiftDailyClose;

/**
 *
 */
public interface DailyCloseService {

    Long startDailyClose(LocalDate dt) throws ServiceException;

    List<RegisterDailyClose> closeRegisters(Long id) throws ServiceException;


    /**
     * @param id
     * @return
     */
    List<ShiftDailyCloseStub> getShiftsToClose(Long id) throws ServiceException;

    /**
     * @param id
     * @param stubs
     */
    List<ShiftDailyClose> closeShifts(Long id, List<ShiftDailyCloseStub> stubs) throws ServiceException;

    /**
     * @param id
     * @return
     */
    void finishCloseDay(Long id) throws ServiceException;

}