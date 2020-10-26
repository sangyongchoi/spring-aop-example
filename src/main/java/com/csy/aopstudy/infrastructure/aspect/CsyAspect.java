package com.csy.aopstudy.infrastructure.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class CsyAspect {

    @Before(value = "@annotation(csyLogging) && args(id)")
    void before(CsyLogging csyLogging, Long id) {
        log.info("AOP Before {}, id : {}", csyLogging.value(), id);
    }

    @AfterThrowing(value = "@annotation(csyLogging) && args(id)", throwing = "exception")
    void afterThrow(JoinPoint joinPoint, Exception exception, CsyLogging csyLogging, Long id){
        log.info("AOP After Throw {} Exception : {}", joinPoint, exception.getMessage());
    }

    @AfterReturning(value = "@annotation(csyLogging) && args(id)")
    void afterReturn(JoinPoint joinPoint, CsyLogging csyLogging, Long id){
        log.info("AOP After Return JoinPoint {} Returing {} id : {}", joinPoint, csyLogging.value(), id);
    }

    @After(value = "@annotation(csyLogging) && args(id)")
    void after(CsyLogging csyLogging, Long id) {
        log.info("AOP After {} id : {}", csyLogging.value(), id);
    }

    @Around(value = "@annotation(csyLogging) && args(test)")
    Object around(ProceedingJoinPoint proceedingJoinPoint, CsyLogging csyLogging, Long test) throws Throwable {
        log.info("AOP Around Start");
        Object proceed = proceedingJoinPoint.proceed();
        log.info("AOP Around {} result : {} Value : {} test : {}", proceedingJoinPoint,proceed, csyLogging.value(), test);
        return proceed;
    }

}
