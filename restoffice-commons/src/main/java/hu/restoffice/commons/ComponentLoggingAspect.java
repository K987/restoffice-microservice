package hu.restoffice.commons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Component
@Aspect
@ConditionalOnExpression("${aspect.logging.component.enabled:true}")
public class ComponentLoggingAspect {

    @Autowired
    private ServiceProperties properties;

    private static final Logger log = LogManager.getLogger();

    @Pointcut("@within(org.springframework.stereotype.Service) && execution(* hu.restoffice..*.*(..))")
    public void restofficeServiceMethodPointcut() {
    };

    @Pointcut("target(org.springframework.data.jpa.repository.JpaRepository)")
    public void jpaRepositoryMethodPointcut() {
    };

    @Pointcut("execution(* hu.restoffice..*.*(..)) && (@within(org.springframework.stereotype.Service) || @within(org.springframework.web.bind.annotation.RestController))")
    public void restofficeComponentPointCut() {

    };

    @Before("restofficeServiceMethodPointcut()")
    public void serviceMethodCall(final JoinPoint joinPoint) {
        log.info(properties.getServiceName() + " - " + joinPoint.toShortString()
        + " with args: ["
        + argsToString(joinPoint.getArgs()) + "]");
    }

    @Before("jpaRepositoryMethodPointcut()")
    public void repostioryMethodCall(final JoinPoint joinPoint) {
        log.info(properties.getServiceName() + " - " + joinPoint.toShortString()
        + " with args: [" + argsToString(joinPoint.getArgs()) + "]");
    }

    @AfterThrowing(pointcut = "restofficeComponentPointCut()", throwing = "ex")
    public void excetiponThrowing(final JoinPoint joinPoint, final Exception ex) {
        log.error("Exception at: " + properties.getServiceName() + " - "
                + joinPoint.toShortString() + ": " + ex.getMessage());
    }

    private String argsToString(final Object[] args) {
        StringBuilder sb = new StringBuilder();
        for (Object object : args) {
            if (object == null) {
                sb.append("null ");
            } else {
                sb.append(object.getClass().getSimpleName() + ": " + object + " ");
            }
        }
        return sb.toString().trim();
    }
}
