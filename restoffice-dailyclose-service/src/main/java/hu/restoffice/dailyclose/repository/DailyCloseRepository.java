package hu.restoffice.dailyclose.repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.restoffice.dailyclose.entity.DailyClose;

/**
 *
 */
public interface DailyCloseRepository extends JpaRepository<DailyClose, Long> {

    /**
     * @param dt
     */
    Optional<DailyClose> findByCloseDate(Date dt);

}
