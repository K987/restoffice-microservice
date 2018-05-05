package hu.restoffice.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import hu.restoffice.commons.web.DefaultController;
import hu.restoffice.employee.converter.EmployeeConverterService;
import hu.restoffice.employee.converter.EmployeeShiftConverterService;
import hu.restoffice.employee.converter.ShiftConverterService;
import hu.restoffice.employee.service.EmployeeService;
import hu.restoffice.employee.service.EmployeeShiftService;
import hu.restoffice.employee.service.ShiftService;

@ComponentScan("hu.restoffice")
@SpringBootApplication
public class RestofficeEmployeeServiceApplication {

    public static void main(final String[] args) {
        SpringApplication.run(RestofficeEmployeeServiceApplication.class, args);
    }

    @Bean
    public CommonsRequestLoggingFilter log() {
        return new CommonsRequestLoggingFilter();
    }

    @Bean
    public DefaultController employeeDefaultController(final EmployeeService s, final EmployeeConverterService c) {
        return new DefaultController(s, c);
    }

    @Bean
    public DefaultController employeeShiftDefaultController(final EmployeeShiftService s,
            final EmployeeShiftConverterService c) {
        return new DefaultController(s, c);
    }

    @Bean
    public DefaultController shiftDefaultController(final ShiftService s, final ShiftConverterService c) {
        return new DefaultController(s, c);
    }
}
