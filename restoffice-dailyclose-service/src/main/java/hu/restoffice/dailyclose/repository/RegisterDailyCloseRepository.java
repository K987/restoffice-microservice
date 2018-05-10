package hu.restoffice.dailyclose.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.restoffice.dailyclose.entity.RegisterDailyClose;

/**
 *
 */
public interface RegisterDailyCloseRepository extends JpaRepository<RegisterDailyClose, Long> {

}
