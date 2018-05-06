package hu.restoffice.transaction.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hu.restoffice.transaction.entity.IncomeType;

/**
 *
 */
public interface IncomeTypeRepository extends JpaRepository<IncomeType, Long> {

    Optional<IncomeType> findByNameIgnoreCase(String name);

    List<IncomeType> findByProdRelated(Boolean prodRelated);

    /**
     * @param id
     * @return
     */
    @Query("select t from IncomeType t left join fetch t.incomes i where t.id = :id and t.incomes is empty")
    Optional<IncomeType> findByIdIfHasRelatedIncomes(@Param("id") Long id);
}
