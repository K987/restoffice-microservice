package hu.restoffice.dailyclose.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import hu.restoffice.dailyclose.entity.DailyClose;
import hu.restoffice.dailyclose.repository.DailyCloseRepository;
import hu.restoffice.dailyclose.repository.RegisterDailyCloseRepository;

/**
 *
 */
@RunWith(SpringRunner.class)
public class DailyCloseServiceimplTest {


    @TestConfiguration
    static class TestContext {

        @Bean
        public DailyCloseService service() {
            return new DailyCloseServiceImpl();
        }
    }

    @Autowired
    private DailyCloseService service;

    @MockBean
    private DailyCloseRepository dcRepo;

    @MockBean
    private RegisterDailyCloseRepository rdcReop;

    @Before
    public void setUp() {

        DailyClose dc = new DailyClose();
        dc.setCloseDate(Date.valueOf(LocalDate.of(2018, 05, 10)));
        Mockito.when(dcRepo.findByCloseDate(dc.getCloseDate()))
        .thenReturn(Optional.ofNullable(null));

        Mockito.when(dcRepo.saveAndFlush(dc)).thenReturn(dc);

    }




}
