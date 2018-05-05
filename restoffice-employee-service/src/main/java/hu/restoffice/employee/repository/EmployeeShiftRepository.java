package hu.restoffice.employee.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hu.restoffice.employee.entity.EmployeeShift;

/**
 *
 */
public interface EmployeeShiftRepository extends JpaRepository<EmployeeShift, Long> {

    /**
     * jövőbeni műszakok meghatározása TODO felhasználni
     *
     * @param empId
     * @param from
     * @return
     */
    List<EmployeeShift> findByEmployee_IdEqualsAndShift_StartDateTimeGreaterThanEqual(Long empId, Timestamp from);

    /**
     * employee shifts performed TODO: felhaszálni
     *
     * @param empId
     * @param from
     * @param to
     * @return
     */
    Long countByEmployee_IdAndShift_StartDateTimeBetween(Long empId, Timestamp from, Timestamp to);


    /**
     * is deletable
     *
     * @param id
     * @return
     */
    Long countByIdAndActualStartNotNull(Long id);


    List<EmployeeShift> findByActualStartNullAndEmployee_Id(Long id);

    /**
     * @param id
     * @param id2
     * @return
     */
    Optional<EmployeeShift> findByEmployee_IdAndShift_Id(Long id, Long id2);

    /**
     * @param e
     * @param s
     */
    @Modifying
    @Query(value = "insert into employee_shifts(employee_shift_employee_id,employee_shift_shift_id) values(:e,:s)", nativeQuery = true)
    void addEmployeeShfit(@Param("e") Long e, @Param("s") Long s);

}
