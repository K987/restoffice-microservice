package hu.restoffice.cashregister.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hu.restoffice.cashregister.entity.Register;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterRepositoryTest {

    @Autowired
    private RegisterRepository repository;

    @Test
    public void findByRegistrationNoIgnoreCase_Test() {
        Optional<Register> register = repository.findByRegistrationNoIgnoreCase("ap_0123");
        assertTrue(register.isPresent());
    }

    @Test
    public void findById_Test() {
        Optional<Register> register = repository.findById(101l);
        assertTrue(register.isPresent());
        assertTrue(register.get().getRegisterCloses().size() > 0);
    }

    @Test
    public void hasCloses_Test() {
        Long closes = repository.hasCloses(101l);
        assertEquals(0l, closes.longValue());
    }

}
