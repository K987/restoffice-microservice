package hu.restoffice.transaction.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hu.restoffice.transaction.entity.CostCenter;

/**
 *
 */
public interface CostCenterRepository extends JpaRepository<CostCenter, Long> {

    Optional<CostCenter> findByNameIgnoreCase(String name);

    @Query("select c from CostCenter c where c.defaultCostCenter = TRUE")
    Optional<CostCenter> findDefault();

}
