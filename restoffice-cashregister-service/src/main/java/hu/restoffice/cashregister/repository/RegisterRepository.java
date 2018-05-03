package hu.restoffice.cashregister.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hu.restoffice.cashregister.entity.Register;
import hu.restoffice.cashregister.entity.RegisterClose;

/**
 *
 */
public interface RegisterRepository extends JpaRepository<Register, Long> {

    Optional<Register> findByRegistrationNoIgnoreCase(String regNo);

    /**
     * @return
     */
    @Query("Select r.registerCloses from Register r where r.id = :id")
    List<RegisterClose> findRegisterClosesByRegisterId(@Param("id") Long id);

    @Override
    @Query("select r from Register r join fetch r.registerCloses c where r.id = :id")
    Optional<Register> findById(@Param("id") Long id);

    /**
     * @param id
     */
    @Query("select count(r) from Register r where r.id = :id and r.registerCloses is empty")
    Long hasCloses(@Param("id") Long id);
}
