package hu.restoffice.transaction.aspect;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
@Aspect
@ConditionalOnExpression("${aspect.logging.component.enabled:true}")
public class ComponentLoggingAspect {

    private static final Logger log = LogManager.getLogger();

    @Before("within(@org.springframework.stereotype.Service *) && execution(* hu.restoffice..*.*(..))")
    public void serviceMethodCall(final JoinPoint jointPoint) {
        String method = jointPoint.getSignature().getName();
        Object[] args = jointPoint.getArgs();
        log.info(method + " invoked with args: [" + argsToString(args) + "] on " + jointPoint.getTarget());
    }

    private String argsToString(final Object[] args) {
        StringBuilder sb = new StringBuilder();
        for (Object object : args) {
            sb.append(object);
            sb.append(" ");
        }
        return sb.toString();
    }
}
