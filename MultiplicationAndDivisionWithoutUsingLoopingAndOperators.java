package com.zoho.javaprograms;

import java.util.Scanner;

public class MultiplicationAndDivisionWithoutUsingLoopingAndOperators {

	public static void main(String[] args) {
		MultiplicationAndDivisionWithoutUsingLoopingAndOperators multiplicationAndDivisionWithoutUsingLoopingAndOperators = new MultiplicationAndDivisionWithoutUsingLoopingAndOperators();
		multiplicationAndDivisionWithoutUsingLoopingAndOperators.finTheResult();
	}

	private void finTheResult() {
	Scanner reader = new Scanner(System.in);
	System.out.println("number");
	int number = reader.nextInt();
	System.out.println((number<<4)-number);     //15
	System.out.println(number>>1);              //7.5
	System.out.println(number>>4);              //15*n/16
	
		
	}

}
