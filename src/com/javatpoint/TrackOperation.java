package com.javatpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;  
import org.aspectj.lang.annotation.Aspect;  
import org.aspectj.lang.annotation.Pointcut;  
  
@Aspect  
public class TrackOperation  
{  
    @Pointcut("execution(* Operation.*(..))")  
    public void abcPointcut(){}  
      
    @Around("abcPointcut()")  
    public Object myadvice(ProceedingJoinPoint pjp) throws Throwable   
    {  
        System.out.println("Additional Concern Before calling actual method proceed");  
        Object obj=pjp.proceed();  
        System.out.println("Additional Concern After calling actual method proceed");  
        return obj;  
    }  
    @After("abcPointcut()")
    public void myadvice(JoinPoint pjp)    
    {  
        System.out.println("Additional Concern After calling actual method");  
    }  
}  