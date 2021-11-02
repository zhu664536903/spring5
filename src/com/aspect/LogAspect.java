package com.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAspect {
    @Pointcut("execution(* com.service.*.*(..))")
    public void cut(){

    }
    @Around("cut()")
    public Object aroud(ProceedingJoinPoint join) throws Throwable {
        Signature signature = join.getSignature();

        System.out.println(signature.getName()+"方法执行前写入日志");
        Object proceed = join.proceed();
        System.out.println(signature.getName()+"方法执行后写入日志");
        return proceed;
    }
    @Before("cut()")
    public void before(){
        System.out.println("前置通知");
    }
    public void after(){
        System.out.println("后置通知");
    }
    @AfterThrowing("cut()")
    public void throwAble(){
        System.out.println("异常返回通知");
    }
}
