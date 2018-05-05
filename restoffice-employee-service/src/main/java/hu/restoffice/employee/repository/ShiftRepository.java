package hu.restoffice.employee.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hu.restoffice.employee.entity.Shift;

/**
 *
 */
public interface ShiftRepository extends JpaRepository<Shift, Long> {

    @Query("SELECT DISTINCT s FROM Shift s LEFT JOIN FETCH s.employeeShifts es JOIN FETCH es.employee WHERE s.startDateTime BETWEEN :fromDate AND :toDate")
    List<Shift> getScheduleBetween(@Param("fromDate") Timestamp fromDate, @Param("toDate") Timestamp toDate);

    // @Query("SELECT DISTINCT s FROM Shift s LEFT JOIN FETCH s.employeeShifts es
    // JOIN FETCH es.employee e WHERE s.startDateTime BETWEEN :fromDate AND :toDate
    // AND e.id = :id")
    @Query("SELECT DISTINCT s FROM Shift s LEFT JOIN FETCH s.employeeShifts es JOIN FETCH es.employee e WHERE s.startDateTime BETWEEN :fromDate AND :toDate AND e.id = :id")
    List<Shift> getScheduleBetween(@Param("fromDate") Timestamp fromDate, @Param("toDate") Timestamp toDate,
            @Param("id") Long empId);

    /**
     * @param startDateTime
     * @param duration
     */
    Optional<Shift> findByStartDateTimeAndDuration(Timestamp startDateTime, Double duration);

    /**
     * @param id
     */
    @Query("select s from Shift s where s.id = :id and s.employeeShifts is Empty")
    Optional<Shift> findByIdAndEmployeeShiftIsEmpty(@Param("id") Long id);
}
