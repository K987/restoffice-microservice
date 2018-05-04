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

    List<Partner> findByTechnical(Boolean technical);

    Optional<Partner> findByNameIgnoreCase(String name);

    List<Partner> findByNameContainingIgnoreCase(String name);

    @Query("select p.contact from Partner p where p.id = :id")
    Optional<PartnerContact> findContactByPartnerId(@Param("id") Long id);

    @Query("select p from Partner p LEFT JOIN FETCH p.expenses e LEFT JOIN FETCH p.incomes i WHERE p.expenses IS EMPTY AND p.incomes IS EMPTY")
    List<Partner> findUnused();

}
