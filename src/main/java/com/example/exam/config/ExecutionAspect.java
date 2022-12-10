package com.example.tpnotee.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

@Component
@Aspect
@Slf4j
public class ExecutionAspect {
   // @Around("execution(* com.example.exam.services.*.ajouter*(..))")
    public List<Object> logMethod(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stpw=new StopWatch();
        stpw.start();
        List<Object> obj=new ArrayList<>();
        obj= (List<Object>) pjp.proceed();
        stpw.stop();
        log.info("Execution type of method : {} is {}",pjp.getSignature().getName(),stpw.getLastTaskTimeMillis());
    return obj;
    }
}
