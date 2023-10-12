package edu.bjtu.elasticsearch.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ESServerAspect {

    @Pointcut("within(org.elasticsearch.search..*) " +
            "|| within(org.elasticsearch.ingest..*)" +
            "|| within(org.elasticsearch.client..*)" +
            "|| within(org.elasticsearch.persistent..*)" +
            "|| within(org.elasticsearch.rest..*)" +
            "|| within(org.elasticsearch.action..*)" +
            "|| within(org.elasticsearch.http..*)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = null;
        result = proceedingJoinPoint.proceed();
        return result;
    }

}
