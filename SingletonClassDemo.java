package com.zoho.javaprograms;

public class SingletonClassDemo {

	public static void main(String[] args) {
		Student student;

		student = Student.privateConstructor();

		student.getConnection();
	}
}

class Student {
	private static Student collegeName;

	private Student() {
	}

	public static Student privateConstructor() {
		if (collegeName == null) {
			collegeName = new Student();
			System.out.println("private Constructor Created");
		} else {
			System.out.println("Private Constructor called one time only");
		}
		return collegeName;
	}

	public void getConnection() {

		privateConstructor();
	}
}
