package com.javatpoint;

import org.aspectj.lang.JoinPoint;

public class TrackOperation {// Aspect Class
	public void myadvice(JoinPoint jp)// Advice Method
	{
		System.out.println("additional concern");
		System.out.println("Method Signature: " + jp.getSignature());
	}
}