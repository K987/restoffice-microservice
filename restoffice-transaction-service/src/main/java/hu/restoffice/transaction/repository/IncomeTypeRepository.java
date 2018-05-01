package hu.restoffice.transaction.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.restoffice.transaction.entity.IncomeType;

/**
 *
 */
public interface IncomeTypeRepository extends JpaRepository<IncomeType, Long> {

    Optional<IncomeType> findByNameIgnoreCase(String name);

    List<IncomeType> findByProdRelated(Boolean prodRelated);
}
