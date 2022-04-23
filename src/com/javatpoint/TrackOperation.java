package com.javatpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect  
public class TrackOperation{  
    @AfterReturning(  
              pointcut = "execution(* Operation.*(..))",  
              returning= "results")                  
    public void myadvice(JoinPoint jp,Object results)//it is advice (after returning advice)
    //The results parameter should have same name as returning param in annotation!
    {  
        System.out.println("additional concern");  
        System.out.println("Method Signature: "  + jp.getSignature());  
        System.out.println("Result in advice: "+results);  
        System.out.println("end of after returning advice...");  
    }  
    
    @Pointcut("execution(* Operation.*(..))")  
    public void k(){
    	System.out.println("Point cut K is called");
    }
    
    @After("k()")//applying pointcut on after advice  
    public void myadvice(JoinPoint jp)//it is advice (after advice)  
    {  
        System.out.println("1 additional concerns");  
    }
    
    @Before("execution(* Operation.*(..))")
    public void myadvice2(JoinPoint jp)//it is advice (after advice)  
    {  
        System.out.println("2 additional concerns for "+jp.getTarget() );  


    }
}


//This is to possible have as many pointcuts in an aspect file, this is my personal note.