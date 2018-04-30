package hu.restoffice.transaction.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import hu.restoffice.transaction.entity.Partner;

/**
 *
 */
public interface PartnerRepository extends JpaRepository<Partner, Long> {

    List<Partner> findByTechnical(@Param("technical") Boolean technical);

    Optional<Partner> findByNameIgnoreCase(String name);

    List<Partner> findByNameContainingIgnoreCase(String name);

    Long countByNameIgnoreCase(String name);

}
