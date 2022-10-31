package com.zoho.javaprograms;

import java.util.Scanner;

public class StringImmutable {

	public static void main(String[] args) {
		StringImmutable stringImmutable = new StringImmutable();
		stringImmutable.checkStringConstantPool();

	}

	private void checkStringConstantPool() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the string");
		
		String stringValue = reader.next();
		String copyValue = stringValue;
		String newMemoryValue = new String(stringValue);
		
		System.out.println(stringValue == copyValue);
		System.out.println(stringValue == newMemoryValue);
		System.out.println(stringValue.equals(newMemoryValue));
		
		
		System.out.println("Stringvalue Hashcode    : "+System.identityHashCode(stringValue)); 
		System.out.println("copyValue Hashcode      : "+System.identityHashCode(copyValue));
		System.out.println("newMemoryValue Hashcode : "+System.identityHashCode(newMemoryValue));
		System.out.println("stringValue : " +stringValue +" identityHashCode(stringValue) " +System.identityHashCode(stringValue));
		stringValue+="KISHORE";
		System.out.println("stringValue : " +stringValue +" identityHashCode(stringValue) " +System.identityHashCode(stringValue));
	}

}
