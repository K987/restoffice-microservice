package hu.restoffice.employee.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.error.ServiceException.Type;
import hu.restoffice.commons.service.AbstractCRUDService;
import hu.restoffice.employee.domain.JobPosition;
import hu.restoffice.employee.entity.EmployeeShift;
import hu.restoffice.employee.repository.EmployeeShiftRepository;

/**
 *
 */
@Service
public class EmployeeShiftServiceImpl extends AbstractCRUDService<EmployeeShift, EmployeeShiftRepository>
implements EmployeeShiftService {

    private static final Logger log = LogManager.getLogger();

    @Autowired
    private ShiftService shiftService;

    @Autowired
    private EmployeeService employeeService;


    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.commons.service.AbstractCRUDService#add(java.lang.Object)
     */
    @Override
    public EmployeeShift add(final EmployeeShift entity) throws ServiceException {
        throw new ServiceException(Type.UNSUPPORTED, "not supported operation, need employee id and shift id");
    }


    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.commons.service.AbstractCRUDService#checkExistence(java.lang.
     * Object)
     */
    @Override
    public boolean checkExistence(final EmployeeShift entity) {
        return repo.findByEmployee_IdAndShift_Id(entity.getEmployee().getId(), entity.getShift().getId()).isPresent();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.commons.service.AbstractCRUDService#updateFields(java.lang.
     * Object, java.lang.Object)
     */
    @Override
    protected void updateFields(final EmployeeShift old, final EmployeeShift entity) {
        Timestamp s = entity.getActualStart();
        Timestamp e = entity.getActualEnd();
        JobPosition p = entity.getActualPosition();
        if (s != null) {
            old.setActualStart(s);
        }
        if (e != null) {
            old.setActualEnd(e);
        }
        if (p != null) {
            old.setActualPosition(p);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.commons.service.AbstractCRUDService#isDeletable(java.lang.Long)
     */
    @Override
    protected boolean isDeletable(final Long id) throws ServiceException {
        return (repo.countByIdAndActualStartNotNull(id) == 0);
    }

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.employee.service.EmployeeShiftService#
     * findByActualStartNotNullAndEmployee_Id(java.lang.Long)
     */
    @Override
    public List<EmployeeShift> findEmployeesUnstartedShifts(final Long id) {
        return repo.findByActualStartNullAndEmployee_Id(id);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.employee.service.EmployeeShiftService#getScheduledShifts(java.
     * time.LocalDate)
     */
    @Override
    public List<EmployeeShift> getScheduledShifts(final LocalDate day) throws ServiceException {
        try {
            Timestamp start = Timestamp.valueOf(LocalDateTime.of(day, LocalTime.of(0, 01)));
            Timestamp end = Timestamp.valueOf(LocalDateTime.of(day, LocalTime.of(23, 59)));
            List<EmployeeShift> rtrn = repo.findByShift_StartDateTimeBetween(start, end);
            rtrn.forEach(EmployeeShift::getEmployee);
            log.info(rtrn.size() + ", " + rtrn.get(0));
            return rtrn;
        } catch (Exception e) {
            throw new ServiceException(Type.UNKNOWN, e.getLocalizedMessage());
        }
    }
}
