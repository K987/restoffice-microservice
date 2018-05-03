package hu.restoffice.employee.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.error.ServiceException.Type;
import hu.restoffice.commons.service.AbstractCRUDService;
import hu.restoffice.employee.entity.Shift;
import hu.restoffice.employee.repository.ShiftRepository;

/**
 *
 */
@Service
public class ShiftServiceImpl extends AbstractCRUDService<Shift, ShiftRepository>
implements ShiftService {

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.commons.service.AbstractCRUDService#checkExistence(java.lang.
     * Object)
     */
    @Override
    protected boolean checkExistence(final Shift entity) {
        return repo.findByStartDateTimeAndDuration(entity.getStartDateTime(), entity.getDuration()).isPresent();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.commons.service.AbstractCRUDService#updateFields(java.lang.
     * Object, java.lang.Object)
     */
    @Override
    protected void updateFields(final Shift old, final Shift entity) {
        old.getDuration();
        old.getStartDateTime();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.commons.service.AbstractCRUDService#isDeletable(java.lang.Long)
     */
    @Override
    protected boolean isDeletable(final Long id) throws ServiceException {
        return (repo.countByIdAndEmployeeShiftIsEmpty(id) == 0);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.employee.service.ShiftService#getEmployeeSchedule(java.lang.
     * Long, java.time.LocalDateTime, java.time.LocalDateTime)
     */
    @Override
    public List<Shift> getEmployeeSchedule(final Long empId, final LocalDate from, final LocalDate to)
            throws ServiceException {

        Timestamp fromTt = Timestamp.valueOf(LocalDateTime.of(from, LocalTime.of(0, 0, 0)));
        Timestamp toTT = Timestamp.valueOf(LocalDateTime.of(to, LocalTime.of(23, 59, 59)));
        try {
            return repo.getScheduleBetween(fromTt, toTT, empId);
        } catch (Exception e) {
            throw new ServiceException(Type.UNKNOWN, e.getMessage());
        }

    }



}
