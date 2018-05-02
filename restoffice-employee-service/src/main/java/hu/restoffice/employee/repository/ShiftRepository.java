package hu.restoffice.employee.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hu.restoffice.employee.entity.Shift;

/**
 *
 */
public interface ShiftRepository extends JpaRepository<Shift, Long> {

    @Query("SELECT DISTINCT s FROM Shift s LEFT JOIN FETCH s.employeeShifts es JOIN FETCH es.employee WHERE s.startDate BETWEEN :fromDate AND :toDate")
    List<Shift> getScheduleBetween(LocalDate fromDate, LocalDate toDate);
}
