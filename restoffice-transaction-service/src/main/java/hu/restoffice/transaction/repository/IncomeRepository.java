package hu.restoffice.transaction.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.restoffice.transaction.entity.Income;

/**
 *
 */
public interface IncomeRepository extends JpaRepository<Income, Long> {

    Optional<Income> findByDocIdIgnoreCase(String docId);

}
