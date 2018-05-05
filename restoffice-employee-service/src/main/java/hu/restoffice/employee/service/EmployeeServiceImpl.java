package hu.restoffice.employee.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.error.ServiceException.Type;
import hu.restoffice.commons.service.AbstractCRUDService;
import hu.restoffice.employee.domain.JobPosition;
import hu.restoffice.employee.entity.Employee;
import hu.restoffice.employee.entity.EmployeeShift;
import hu.restoffice.employee.entity.Shift;
import hu.restoffice.employee.repository.EmployeeRepository;
import hu.restoffice.employee.repository.EmployeeShiftRepository;
// TODO: hibernate unproxy refactor az isinit helyett GLOBÁLISAN

/**
 *
 */
@Service
public class EmployeeServiceImpl extends AbstractCRUDService<Employee, EmployeeRepository>
implements EmployeeService {

    private static final Logger log = LogManager.getLogger();

    @Autowired
    private EmployeeShiftService employeeShiftService;

    @Autowired
    private ShiftService shiftService;

    @Autowired
    private EmployeeShiftRepository employeeShiftRepo;

    /* (non-Javadoc)
     * @see hu.restoffice.commons.service.AbstractCRUDService#delete(java.lang.Long)
     */
    @Override
    public Employee delete(final Long id) throws ServiceException {
        List<EmployeeShift> employeeShifts = employeeShiftService.findEmployeesUnstartedShifts(id);
        Employee emp = findById(id);
        if (isDeletable(id) || emp.IsActive()) {
            if (isDeletable(id)) {
                log.info("emp with id is going to be deleted " + id);
                emp = super.delete(id);
            } else if (emp.IsActive()) {
                log.info("emp with id is going to be in activated " + id);
                emp.setActive(false);
                repo.saveAndFlush(emp);
                for (EmployeeShift employeeShift : employeeShifts) {
                    employeeShiftService.delete(employeeShift.getId());
                }
            }
            return emp;
        } else {
            throw new ServiceException(Type.UNSUPPORTED, "entity already deleted");
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.commons.service.AbstractCRUDService#checkExistence(java.lang.
     * Object)
     */
    @Override
    protected boolean checkExistence(final Employee entity) throws ServiceException {
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.commons.service.AbstractCRUDService#updateFields(java.lang.
     * Object, java.lang.Object)
     */
    @Override
    protected void updateFields(final Employee old, final Employee entity) {
        BigDecimal w = entity.getDefaultHourlyWage();
        JobPosition p = entity.getDefaultPosition();
        String n = entity.getEmployeeName();
        if (w != null)
            old.setDefaultHourlyWage(w);
        if (p != null)
            old.setDefaultPosition(p);
        if (n != null)
            old.setEmployeeName(n);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.commons.service.AbstractCRUDService#isDeletable(java.lang.Long)
     */
    @Override
    protected boolean isDeletable(final Long id) throws ServiceException {
        return (repo.countByIdAndEmployeeShifts_ActualEndNotNull(id) == 0);

    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.employee.service.EmployeeService#addEmployeToShift(java.lang.
     * Long, java.lang.Long)
     */
    @Override
    public Long addEmployeToShift(final Long empId, final Long shiftId) throws ServiceException {
        Employee e = this.findById(empId);
        Shift s = shiftService.findById(shiftId);
        EmployeeShift es = new EmployeeShift();
        es.initEmployee(e);
        es.initShift(s);
        Long esId = employeeShiftRepo.findByEmployee_IdAndShift_Id(empId, shiftId).map(EmployeeShift::getId).orElse(null);
        if (esId == null) {
            return employeeShiftRepo.saveAndFlush(es).getId();
        } else
            throw new ServiceException(Type.ALREADY_EXISTS, esId);
    }

}
