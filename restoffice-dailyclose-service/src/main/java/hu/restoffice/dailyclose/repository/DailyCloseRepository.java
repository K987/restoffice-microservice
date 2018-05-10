package hu.restoffice.dailyclose.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.restoffice.dailyclose.entity.DailyClose;

/**
 *
 */
public interface DailyCloseRepository extends JpaRepository<DailyClose, Long> {

}
