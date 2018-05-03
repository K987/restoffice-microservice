package hu.restoffice.employee.converter;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.restoffice.employee.domain.EmployeeShiftStub;
import hu.restoffice.employee.domain.EmployeeStub;
import hu.restoffice.employee.entity.Employee;
import hu.restoffice.employee.entity.EmployeeShift;

/**
 *
 */
@Component
public class EmployeeConverterServiceImpl implements EmployeeConverterService {

    @Autowired
    private EmployeeShiftConverterService converter;

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.commons.service.DefaultConverterService#from(java.lang.Object)
     */
    @Override
    public EmployeeStub from(final Employee entity) {
        return new EmployeeStub(entity.getId(), entity.IsActive(), entity.getDefaultHourlyWage(),
                entity.getDefaultPosition(), entity.getEmployeeName(), fromEmployeeShift(entity));

    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.commons.service.DefaultConverterService#to(java.lang.Object)
     */
    @Override
    public Employee to(final EmployeeStub stub) {
        Employee e = new Employee();
        e.setEmployeeName(stub.getName());
        e.setDefaultHourlyWage(stub.getDefaultHourlyWage());
        e.setActive(stub.getActive());
        e.setDefaultPosition(stub.getDefaultPosition());
        return e;
    }

    /**
     * @param entity
     * @return
     */
    private List<EmployeeShiftStub> fromEmployeeShift(final Employee entity) {
        if (!Hibernate.isInitialized(entity.getEmployeeShifts()) || entity.getEmployeeShifts() == null)
            return null;
        else
            return converter.from(new ArrayList<EmployeeShift>(entity.getEmployeeShifts()));
    }

}
