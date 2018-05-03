package hu.restoffice.employee.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.restoffice.employee.entity.EmployeeShift;

/**
 *
 */
public interface EmployeeShiftRepository extends JpaRepository<EmployeeShift, Long> {

    List<EmployeeShift> findByEmployee_IdEqualsAndShift_StartDateTimeGreaterThanEqual(Long empId, Timestamp from);

    Long countByEmployee_IdAndShift_StartDateTimeBetween(Long empId, Timestamp from, Timestamp to);

    /**
     * @param id
     * @return
     */
    Long countByIdAndActualStartNotNull(Long id);

    List<EmployeeShift> findByActualStartNotNullAndEmployee_Id(Long id);

}
