package com.javatpoint;

import org.aspectj.lang.JoinPoint;

public class TrackOperation {// Aspect Class
	public void myadvice(JoinPoint jp)// Advice Method Before
	{
		System.out.println("additional concern, Before");
		System.out.println("Method Signature: " + jp.getSignature());
	}
	
	public void myadvice2(JoinPoint jp)// Advice Method After
	{
		System.out.println("additional concern, After");
		System.out.println("Method Signature: " + jp.getSignature());
	}
}