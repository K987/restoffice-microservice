package hu.restoffice.transaction.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hu.restoffice.transaction.entity.Partner;
import hu.restoffice.transaction.entity.PartnerContact;

/**
 *
 */
public interface PartnerRepository extends JpaRepository<Partner, Long> {

    List<Partner> findByTechnical(@Param("technical") Boolean technical);

    Optional<Partner> findByNameIgnoreCase(String name);

    List<Partner> findByNameContainingIgnoreCase(String name);

    Long countByNameIgnoreCase(String name);

    @Query("select p.contact from Partner p where p.id = :id")
    Optional<PartnerContact> findContactByPartnerId(@Param("id") Long id);

}
