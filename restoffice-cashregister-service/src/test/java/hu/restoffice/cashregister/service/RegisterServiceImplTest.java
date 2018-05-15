package hu.restoffice.cashregister.service;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import hu.restoffice.cashregister.domain.RegisterType;
import hu.restoffice.cashregister.entity.Register;
import hu.restoffice.cashregister.repository.RegisterRepository;
import hu.restoffice.cashregister.service.RegisterService;
import hu.restoffice.cashregister.service.RegisterServiceImpl;
import hu.restoffice.commons.error.ServiceException;

/**
 *
 */
@RunWith(SpringRunner.class)
public class RegisterServiceImplTest {

    @TestConfiguration
    static class TestContext {

        @Bean
        public RegisterService service() {
            return new RegisterServiceImpl();
        }
    }

    @Autowired
    private RegisterService service;

    @MockBean
    private RegisterRepository repo;

    @Before
    public void setUp() {
        Register r = new Register();
        r.setRegisterType(RegisterType.CARD);
        r.setRegistrationNo("abc_123");

        Mockito.when(repo.findByRegistrationNoIgnoreCase(r.getRegistrationNo())).thenReturn(Optional.ofNullable(r));
        Mockito.when(repo.findByRegistrationNoIgnoreCase("abc_124")).thenReturn(Optional.ofNullable(null));
        Mockito.when(repo.hasCloses(101l)).thenReturn(1l);
    }

    @Test(expected = ServiceException.class)
    public void add_with_Exception_Test() throws Exception {
        Register r = new Register();
        r.setRegisterType(RegisterType.CARD);
        r.setRegistrationNo("abc_123");
        service.add(r);
    }

    @Test
    public void add_Test() throws Exception {
        Register r = new Register();
        r.setRegisterType(RegisterType.CARD);
        r.setRegistrationNo("abc_124");
        service.add(r);
    }

    @Test(expected = ServiceException.class)
    public void delete_with_Exception_Test() throws Exception {
        service.delete(101l);
    }

}
