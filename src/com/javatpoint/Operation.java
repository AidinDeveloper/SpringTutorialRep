package com.javatpoint;

public class Operation {
	public void msg() {
		System.out.println("msg method invoked");
	}

	public int m() {
		System.out.println("m method invoked");
		return 2;
	}

	public int k() {
		System.out.println("k method invoked");
		return 3;
	}
	
	public int k(int m) {
		System.out.println("k method invoked");
		return 3;
	}
	
	public int k(int i,String name)
	{		
	
		return 1;
		
	}
	
	public int k(String user,String name)
	{
		return 1;
		
	}
}