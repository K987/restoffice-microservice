package hu.restoffice.employee.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.restoffice.employee.entity.Employee;

/**
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    // @NamedQuery(name = Employee.GET_EMPLOYEE_SCHEDULE, query = "SELECT e FROM
    // Employee e LEFT JOIN FETCH e.employeeShifts es JOIN FETCH es.shift s "
    // + "WHERE e.name=:" + Employee.NAME + " AND s.startDate BETWEEN :" +
    // Employee.START_DATE + " AND :"
    // + Employee.END_DATE),

    // @NamedQuery(name = Employee.GET_EMPLOYEE_BY_NAME, query = "SELECT e FROM
    // Employee e WHERE LOWER(e.name) =:"
    // + Employee.NAME),

    // @NamedQuery(name = Employee.COUNT_DAYS_WORKED, query = "SELECT
    // COUNT(es.rowId) FROM Employee e JOIN e.employeeShifts es "
    // + "WHERE LOWER(e.name)=:" + Employee.NAME + " AND es.shift.startDate <=:" +
    // Employee.END_DATE
    // + " AND es.actualStart != null"),

    Long countByIdAndEmployeeShifts_Shift_StartDateBetween(Long Id, LocalDate from, LocalDate to);


}
