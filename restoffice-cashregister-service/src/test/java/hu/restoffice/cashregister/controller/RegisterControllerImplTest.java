package hu.restoffice.cashregister.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import hu.restoffice.cashregister.converter.RegisterConverterServiceImpl;
import hu.restoffice.cashregister.domain.RegisterStub;
import hu.restoffice.cashregister.domain.RegisterType;
import hu.restoffice.cashregister.service.RegisterServiceImpl;
import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.web.DefaultController;

/**
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(RegisterControllerImpl.class)
@ActiveProfiles("development")
@Ignore
public class RegisterControllerImplTest {


    @Configuration
    static class TestConfig {
        @Bean
        public DefaultController registerDefaultController() {

            return new DefaultController(new RegisterServiceImpl(), new RegisterConverterServiceImpl());


        }
    }

    @Autowired
    private MockMvc mvc;

    @MockBean
    @Qualifier("registerDefaultControllerTest")
    private DefaultController registerDefaultController;

    @Before
    public void setUp() throws ServiceException {
        RegisterStub r = new RegisterStub(101l, "abc-123", RegisterType.CARD, null);

        Mockito.when(registerDefaultController.findResourceById(101l)).thenReturn(ResponseEntity.ok(r));

    }

    @Test
    public void findResourceById_Test() throws Exception {
        mvc.perform(get("/register/101").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id", is(101l)));

    }

}
