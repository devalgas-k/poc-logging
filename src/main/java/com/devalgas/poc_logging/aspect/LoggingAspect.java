package com.devalgas.poc_logging.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @AfterReturning(
        pointcut = "execution(* com.devalgas.poc_logging.rest.LoggingRest.logMessage(..))",
        returning = "result"
    )
    public void afterLogMessageMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Méthode '{}' exécutée avec succès. Résultat: {}", methodName, result);
    }

    @Before("execution(* com.devalgas.poc_logging.rest.LoggingRest.logMessage(..))")
    public void beforeLogMessageMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.info("Avant l'exécution de la méthode '{}' avec les paramètres: {}", methodName, Arrays.toString(args));
    }

    @AfterThrowing(pointcut = "execution(* com.devalgas.poc_logging.rest.LoggingRest.logMessage(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        logger.error("Exception in method: " + joinPoint.getSignature().getName(), ex);
    }
}
