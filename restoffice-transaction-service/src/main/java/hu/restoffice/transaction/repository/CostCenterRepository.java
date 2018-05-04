package hu.restoffice.transaction.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hu.restoffice.transaction.entity.CostCenter;

/**
 *
 */
public interface CostCenterRepository extends JpaRepository<CostCenter, Long> {

    Optional<CostCenter> findByNameIgnoreCase(String name);

    @Query("select c from CostCenter c where c.defaultCostCenter = TRUE")
    Optional<CostCenter> findDefault();

    /**
     * @param id
     * @return
     */
    @Query("select c from CostCenter c join fetch c.expenses e where c.id = :id and c.expenses is empty")
    Optional<CostCenter> findIfNotReferencedByTransaction(@Param("id") Long id);

}
