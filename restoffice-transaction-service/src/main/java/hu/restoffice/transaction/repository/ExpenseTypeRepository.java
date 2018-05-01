package hu.restoffice.transaction.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.restoffice.transaction.entity.ExpenseType;

/**
 *
 */
public interface ExpenseTypeRepository extends JpaRepository<ExpenseType, Long> {

    Optional<ExpenseType> findByNameIgnoreCase(String name);

    List<ExpenseType> findByProdRelated(Boolean prodRelated);
}
