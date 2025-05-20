package de.ait.tasks.logging;

import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {
    private final Logger logger;

    @Around("execution(* de.ait.tasks.service.TaskService.*(...)")
    public void helloAOP(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info(methodName + ": start!!!!!!!!!!!" );
    }

}
