package com.javatpoint;

public class Answer {
	int id;
	String name, by;

	public Answer(int id, String name, String by) {
		super();
		this.id = id;
		this.name = name;
		this.by = by;
	}

	public String toString() {
		return id + " " + name + " " + by;
	}
}
