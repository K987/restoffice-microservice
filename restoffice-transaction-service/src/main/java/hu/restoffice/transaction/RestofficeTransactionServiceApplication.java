package hu.restoffice.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import hu.restoffice.commons.web.DefaultController;
import hu.restoffice.transaction.converter.CostCenterConverterService;
import hu.restoffice.transaction.converter.ExpenseConverterService;
import hu.restoffice.transaction.converter.ExpenseTypeConverterService;
import hu.restoffice.transaction.converter.IncomeConverterService;
import hu.restoffice.transaction.converter.IncomeTypeConverterService;
import hu.restoffice.transaction.converter.PartnerConverterService;
import hu.restoffice.transaction.service.CostCenterService;
import hu.restoffice.transaction.service.ExpenseService;
import hu.restoffice.transaction.service.ExpenseTypeService;
import hu.restoffice.transaction.service.IncomeService;
import hu.restoffice.transaction.service.IncomeTypeService;
import hu.restoffice.transaction.service.PartnerService;

@ComponentScan("hu.restoffice")
@SpringBootApplication
@EnableEurekaClient
public class RestofficeTransactionServiceApplication {

    public static void main(final String[] args) {
        SpringApplication.run(RestofficeTransactionServiceApplication.class, args);
    }

    @Bean
    public CommonsRequestLoggingFilter log() {
        return new CommonsRequestLoggingFilter();
    }

    @Bean
    public DefaultController partnerControllerDefault(final PartnerService service,
            final PartnerConverterService converter) {
        return new DefaultController(service, converter);
    }

    @Bean
    public DefaultController expenseControllerDefault(final ExpenseService service,
            final ExpenseConverterService converter) {
        return new DefaultController(service, converter);
    }

    @Bean
    public DefaultController incomeControllerDefault(final IncomeService service,
            final IncomeConverterService converter) {
        return new DefaultController(service, converter);
    }

    @Bean
    public DefaultController costCenterControllerDefault(final CostCenterService service,
            final CostCenterConverterService converter) {
        return new DefaultController(service, converter);
    }

    @Bean
    public DefaultController expenseTypeControllerDefault(final ExpenseTypeService service,
            final ExpenseTypeConverterService converter) {
        return new DefaultController(service, converter);
    }

    @Bean
    public DefaultController incomeTypeControllerDefault(final IncomeTypeService service,
            final IncomeTypeConverterService converter) {
        return new DefaultController(service, converter);
    }
}