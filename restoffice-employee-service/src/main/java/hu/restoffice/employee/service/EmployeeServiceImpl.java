package hu.restoffice.employee.service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.error.ServiceException.Type;
import hu.restoffice.commons.service.AbstractCRUDService;
import hu.restoffice.employee.domain.JobPosition;
import hu.restoffice.employee.entity.Employee;
import hu.restoffice.employee.entity.EmployeeShift;
import hu.restoffice.employee.repository.EmployeeRepository;
// TODO: hibernate unproxy refactor az isinit helyett GLOBÁLISAN

/**
 *
 */
@Service
public class EmployeeServiceImpl extends AbstractCRUDService<Employee, EmployeeRepository>
implements EmployeeService {

    @Autowired
    private EmployeeShiftService employeeShiftService;
    /* (non-Javadoc)
     * @see hu.restoffice.commons.service.AbstractCRUDService#delete(java.lang.Long)
     */
    @Override
    public Employee delete(final Long id) throws ServiceException {
        // TODO: nincs detach... kell néhány unit teszt
        // TODO Session.evict??
        List<EmployeeShift> employeeShifts = employeeShiftService.findEmployeesUnstartedShifts(id);
        Employee emp = findById(id);
        // TODO: settert elkéne hagyni és az addat használni
        if (isDeletable(id) || emp.IsActive()) {
            if (isDeletable(id)) {
                emp = super.delete(id);
            } else if (emp.IsActive()) {
                emp.setActive(false);
                repo.saveAndFlush(emp);
            }
            emp.setEmployeeShifts(new HashSet<EmployeeShift>(employeeShifts));
            for (EmployeeShift employeeShift : employeeShifts) {
                employeeShiftService.delete(employeeShift.getId());
            }
            return emp;
        } else {
            // TODO: készíten egy új typeot, ami jelöli hogy logikailag nem lehetséges
            throw new ServiceException(Type.UNKNOWN, "entity already deleted");
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

}
