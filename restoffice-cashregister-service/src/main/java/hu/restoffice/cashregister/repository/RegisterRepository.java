package hu.restoffice.cashregister.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.restoffice.cashregister.entity.Register;

/**
 *
 */
public interface RegisterRepository extends JpaRepository<Register, Long> {

    Optional<Register> findByRegistrationNoIgnoreCase(String regNo);

}
