package com.zoho.javaprograms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SubSequence {

	public static void main(String[] args) {
		SubSequence subSequence = new SubSequence();
		subSequence.findSubSequence();

	}

	private void findSubSequence() {
		Scanner reader = new Scanner(System.in);
		//System.out.println("Enter a String");
		//String stringValue = reader.next();
		String stringValue = "xybyaxby";
		System.out.println(stringValue);
		int count = 0;
		Map<String, Integer> subStrings = new LinkedHashMap<String, Integer>();
		// String subString ="";
//		for(int index = 0;index<stringValue.length();index++)
//		{	
//			
//			subString =	String.valueOf(stringValue.charAt(index));
//			for(int outerIndex = index+1;outerIndex < stringValue.length();outerIndex++)
//			{
//				for(int innerIndex =outerIndex+1;innerIndex<stringValue.length();innerIndex++)
//				{
//					if(subStrings.containsKey(subString))
//					{
//						subStrings.put(subString,subStrings.get(subString)+1);
//					}
//					else
//					{
//						subStrings.put(subString,1);
//					}
//					
//				}
//				
//				subString += String.valueOf(stringValue.charAt(outerIndex));
//			}
//		}
		String subString = "";
		
		for (int index = 0; index < stringValue.length(); index++) {

			subString = String.valueOf(stringValue.charAt(index));
			

			for (int outerIndex = index + 1; outerIndex < stringValue.length(); outerIndex++) {

				int j = outerIndex;
				count = 0;
				for (int i = 0; i < subString.length(); i++) {
					for (; j < stringValue.length(); j++) {
						if (subString.charAt(i) == stringValue.charAt(j)) {
							count++;
							j = j;
							break;
						}

					}
					if (count != i + 1) {
						break;
					} else if (count == subString.length()) {
						if (subStrings.containsKey(subString)) {
							subStrings.put(subString, subStrings.get(subString) + 1);
						} else {
							subStrings.put(subString, 1);
						}
					}

				}

				subString += String.valueOf(stringValue.charAt(outerIndex));
				if (subStrings.containsKey(subString)) {
					subStrings.put(subString, subStrings.get(subString) + 1);
				} else {
					subStrings.put(subString, 1);
				}
			}
		}
		for (Map.Entry<String, Integer> subSequences : subStrings.entrySet()) {
			if (subSequences.getValue() >= 2 && subSequences.getKey().length()>=2) {
				System.out.println(subSequences.getKey() + " " + subSequences.getValue());
			}

		}
	}

}
