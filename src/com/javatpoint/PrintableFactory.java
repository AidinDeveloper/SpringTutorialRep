package com.javatpoint;

public class PrintableFactory {
	public Printable getPrintable() {
		return new A();// return any one instance, either A or B
	}
}