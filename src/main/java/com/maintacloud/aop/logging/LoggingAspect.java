package com.maintacloud.aop.logging;

import com.maintacloud.config.Constants;
import com.maintacloud.service.exception.ComptaException;
import com.maintacloud.service.exception.DataBaseExeptionHandlerService;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.inject.Inject;
import java.util.Arrays;

/**
 * Aspect for logging execution of service and repository Spring components.
 */
@Aspect
public class LoggingAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DataBaseExeptionHandlerService dataBaseExeptionHandlerService;

    @Inject
    private Environment env;

    private String buildErrorMessage(Throwable ex) {
        return dataBaseExeptionHandlerService.buildFunctionalDataBaseExeption(ex);
    }

    @Pointcut("within(com.komptacloud.service..*) || within(com.komptacloud.web.controller..*)")
    public void loggingPointcut() {
    }


    private void logAfterException(JoinPoint joinPoint, Throwable e) {
        if (!(e instanceof ComptaException)) {
            if (env.acceptsProfiles(Constants.SPRING_PROFILE_DEVELOPMENT)) {
                log.error("Exception in {}.{}() with cause = \'{}\' and exception = \'{}\'", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL", e.getMessage(), e);

            } else {
                log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
            }
            // if we hare here it is only for catch ComptaPersistenceException in AOP,
            // all of other services must log and catch their exceptions to avoid logging many times
            String errorMessage = buildErrorMessage(e);
            if (StringUtils.isEmpty(errorMessage))
                errorMessage = "Erreur de traitement";
            throw new ComptaException("77", errorMessage);
        }
    }

    // we are using log in the catch, it is better to do this but for the moment nothing to change
    @AfterThrowing(pointcut = "loggingPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) { //
        logAfterException(joinPoint, e);
    }

    @Around("loggingPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        if (log.isDebugEnabled()) {
            log.debug("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        }
        try {
            Object result = joinPoint.proceed();
            if (log.isDebugEnabled()) {
                log.debug("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), result);
            }
            return result;
        } catch (IllegalArgumentException e) {
            log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
                joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
            throw e;
        }
    }
}
