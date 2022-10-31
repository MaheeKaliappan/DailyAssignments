package com.zoho.javaprograms;

import java.util.HashSet;
import java.util.Scanner;

public class WeightedUniformStrings {

	public static void main(String[] args) {
		WeightedUniformStrings weightedUniformStrings = new WeightedUniformStrings();
		weightedUniformStrings.findWeightedStrings();

	}

	private void findWeightedStrings() {
		Scanner reader = new Scanner(System.in);
		System.out.println("enter the string");
		String stringValue = reader.next();
		System.out.println("queries size");
		int array[] = new int[reader.nextInt()];
		HashSet<Integer> hs = new HashSet<>();
		System.out.println("enter query values");
		for(int index = 0;index<array.length;index++)
		{
			array[index] = reader.nextInt();
		}
		
		int tempOne,tempTwo ,tempThree;
		tempOne = tempTwo = tempThree = stringValue.charAt(0)-96;
		hs.add(tempTwo);
		for(int index = 1;index<stringValue.length();index++)
		{
			System.out.println(tempTwo);
			tempTwo = stringValue.charAt(index)-96;
			
			 if(tempTwo == tempOne)
	            {
	                hs.add (tempThree+tempTwo);
	                tempOne = tempTwo;
	                tempThree += tempTwo;
	            }
	            else
	            {
	                hs.add(tempTwo);
	                tempOne = tempTwo;
	                tempThree = tempTwo;
	            
	            }
		}
		 for(int i=0; i<array.length; i++)
	        {
	            if(hs.contains(array[i]))
	            {
	            	System.out.println(array[i]+" YES");
	            }
	            
	        }
		
	}

}
