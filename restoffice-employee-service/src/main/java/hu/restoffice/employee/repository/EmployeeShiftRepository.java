package hu.restoffice.employee.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.restoffice.employee.entity.Employee;
import hu.restoffice.employee.entity.EmployeeShift;

/**
 *
 */
public interface EmployeeShiftRepository extends JpaRepository<EmployeeShift, Long> {

    List<EmployeeShift> findByEmployeeEqualsAndShift_StartDateGreaterThanEqual(Employee e, LocalDate from);

    Long countByEmployeeAndShift_StartDateBetween(Employee e, LocalDate from, LocalDate to);

}
