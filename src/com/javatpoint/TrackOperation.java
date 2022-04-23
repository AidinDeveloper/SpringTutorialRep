package com.javatpoint;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TrackOperation {
	@AfterThrowing(pointcut = "execution(* Operation.*(..))", throwing = "error")

	public void myadvice(JoinPoint jp, Throwable error)// it is advice
	{
		System.out.println("additional concern");
		System.out.println("Method Signature: " + jp.getSignature());
		System.out.println("Exception is: " + error);
		
		Object []inputs=jp.getArgs();
		for (Object object : inputs) {
			System.out.println("Input: "+object);
		}
	}
}