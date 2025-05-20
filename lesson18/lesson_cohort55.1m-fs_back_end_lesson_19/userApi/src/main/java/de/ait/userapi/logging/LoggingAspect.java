package de.ait.userapi.logging;


import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Aspect
public class LoggingAspect {
    private final Logger logger;




}
