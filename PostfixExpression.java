package com.zoho.javaprograms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostfixExpression {

	public static void main(String[] args) {
		PostfixExpression postfixExpression = new PostfixExpression();
		postfixExpression.findTheResult();
	}

	private void findTheResult() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the value");
		String expression = reader.next();
		List <Integer>ex = new ArrayList();
		int index=0;
		for(int i = 0;i<expression.length();i++)
		{
			
			if(expression.charAt(i)>=48 && expression.charAt(i)<=57)
			{
				int j = expression.charAt(i)-48;
				ex.add(j);
				index++;
			}
			else
			{
				System.out.println("ex"+expression.charAt(i));
				char operator =  expression.charAt(i);
				
				int firstNumber = ex.get(index-2);
				int secondNumber = ex.get(index-1);
				System.out.println("f"+firstNumber);
				System.out.println("s"+secondNumber);
				System.out.println(ex.toString());
				ex.remove(index-1);
				ex.remove(index-2);
				index-=1;
				int result = performOperation(operator,firstNumber,secondNumber);
				ex.add(result);
				System.out.println(ex.toString());
			}
		}
		System.out.println(ex.toString());
		
	}

	private int performOperation(char operator, int firstNumber, int secondNumber) {
		switch (operator) {
		case '+':
			return firstNumber+secondNumber;
		case '-':
			return firstNumber-secondNumber;
		case '*':
			return firstNumber*secondNumber;
		case '/':
			return firstNumber/secondNumber;
		

		default:
			System.out.println("Invalid Input");
			break;
		}
		return 0;
	}

}
