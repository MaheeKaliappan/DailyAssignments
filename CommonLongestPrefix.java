package com.zoho.javaprograms;

import java.util.Arrays;
import java.util.Scanner;

public class CommonLongestPrefix {

	public static void main(String[] args) {
		CommonLongestPrefix commonLongestPrefix = new CommonLongestPrefix();
		System.out.println("Longest Prefix : "+commonLongestPrefix.findCommonLongestPrefix());

	}

	private String findCommonLongestPrefix() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the numberOfStringValues");
		String stringArray[] = new String[reader.nextInt()];
		System.out.println("Enter the stringValues");
		for(int index = 0;index<stringArray.length;index++)
		{
			stringArray[index] = reader.next();
		}
		Arrays.sort(stringArray);
		System.out.println(Arrays.toString(stringArray));
		int findLength = (stringArray[stringArray.length-1].length()>stringArray[0].length())?stringArray[stringArray.length-1].length():stringArray[0].length();
		String longestPrefix="";
		for(int index = 0;index<findLength-1;index++)
		{
			if(stringArray[0].charAt(index) == stringArray[stringArray.length-1].charAt(index))
			{
				longestPrefix+=String.valueOf(stringArray[0].charAt(index));
			}
			else
			{
				return longestPrefix;
			}
		}
		return longestPrefix;
		
		
	}

}
