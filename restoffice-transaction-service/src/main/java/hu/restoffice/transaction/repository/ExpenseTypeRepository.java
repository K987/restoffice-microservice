package hu.restoffice.transaction.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hu.restoffice.transaction.entity.ExpenseType;

/**
 *
 */
public interface ExpenseTypeRepository extends JpaRepository<ExpenseType, Long> {

    Optional<ExpenseType> findByNameIgnoreCase(String name);

    List<ExpenseType> findByProdRelated(Boolean prodRelated);

    /**
     * @param id
     * @return
     */
    @Query("select t from ExpenseType t left join fetch t.expenses e where t.id = :id and t.expenses is empty")
    Optional<ExpenseType> findIfHasExpenesesRelated(@Param("id") Long id);

}
