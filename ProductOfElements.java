package com.zoho.javaprograms;

import java.util.Arrays;
import java.util.Scanner;

public class ProductOfElements {

	public static void main(String[] args) {
		ProductOfElements productOfElements = new ProductOfElements();
		System.out.println(Arrays.toString(productOfElements.findTheProduct()));

	}

	private int[] findTheProduct() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the arraySize");
		int array[] = new int[reader.nextInt()];
		int productArray[] = new int[array.length];
		
		for(int index =0;index<array.length;index++)
		{
			array[index] = reader.nextInt();
		}
		
		for(int index = 0;index<array.length;index++)
		{	int temp = 1;
			for(int innerIndex =0;innerIndex<array.length;innerIndex++)
			{
				if(innerIndex  != index)
				{
					 temp *= array[innerIndex];
				}
			}
			
			productArray[index] = temp;
		}
		return productArray;
	}

}
