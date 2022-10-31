package com.zoho.javaprograms;

import java.util.Scanner;
import java.util.Stack;

public class IncreaseDecreaseOrder {

	public static void main(String[] args) {
		IncreaseDecreaseOrder increaseDecreaseOrder = new IncreaseDecreaseOrder();
		increaseDecreaseOrder.generateIncreaseDecreaseOrder();
	}

	private void generateIncreaseDecreaseOrder() {
		Scanner  reader = new Scanner(System.in);
		System.out.println("Enter the string");
		String stringValue = reader.next();
		
		StringBuilder stringBuilder = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		
		for(int index = 0 ; index <= stringValue.length() ; index++) {
			
			stack.push(index+1);
			
			if(index == stringValue.length() || stringValue.charAt(index)=='I')
				while(!stack.isEmpty())
					stringBuilder.append(stack.pop());
					
		}
			
		
		System.out.println(stringBuilder.toString());
		
	}

		
	
}
