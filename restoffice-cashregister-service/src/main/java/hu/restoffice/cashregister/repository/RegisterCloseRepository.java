package hu.restoffice.cashregister.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hu.restoffice.cashregister.entity.RegisterClose;

/**
 *
 */
public interface RegisterCloseRepository extends JpaRepository<RegisterClose, Long> {

    List<RegisterClose> findByCloseDateBetween(Date from, Date to);

    List<RegisterClose> findByCloseDate(Date day);

    @Query("select r from RegisterClose r where r.id in (select max(r1.id) from RegisterClose r1 group by r1.register.id)")
    List<RegisterClose> findLastCloses();

    Optional<RegisterClose> findByCloseNoAndRegister_RegistrationNo(Long closeNo, String registrationNo);
}
