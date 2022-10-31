package com.zoho.javaprograms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Triplets {

	public static void main(String[] args) {
		Triplets triplets = new Triplets();
		triplets.findTheTriplets();
	}

	private void findTheTriplets() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the arraySize");
		int array[] = new int[reader.nextInt()];
		Set set = new TreeSet();
		
		for(int index =0;index<array.length;index++)
		{
			array[index] = reader.nextInt();
			//set.add(reader.nextInt());
		}
		
		for(int index =0;index<array.length;index++)
		{
			int sum = 0;
			for(int outerIndex =index+1;outerIndex<array.length;outerIndex++)
			{
				for(int innerIndex =outerIndex+1;innerIndex<array.length;innerIndex++)
				{
					if(array[index] != array[outerIndex]&&array[outerIndex]!= array[innerIndex])
					{
						sum = array[index]+array[innerIndex]+array[outerIndex];
						if(sum==0)
						{
							//set.add(array[index]+" "+array[innerIndex]+" "+array[outerIndex]);
							int arr[] = new int[3];
							arr[0] =array[index];
							arr[1]=array[innerIndex];
							arr[2] =array[outerIndex];
							
							Arrays.sort(arr);
							set.add(Arrays.toString(arr));
							
							
							
						}
					}
					
				}
			}
		}
		System.out.println(set);
		
	}

}
