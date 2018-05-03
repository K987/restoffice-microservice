package hu.restoffice.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.restoffice.employee.entity.Employee;

/**
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /**
     * @return
     */
    Long countByIdAndEmployeeShifts_ActualEndNotNull(Long id);

}
