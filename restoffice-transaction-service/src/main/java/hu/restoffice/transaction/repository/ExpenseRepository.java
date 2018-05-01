package hu.restoffice.transaction.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.restoffice.transaction.entity.Expense;

/**
 *
 */
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    Optional<Expense> findByDocIdIgnoreCase(String docId);
}
