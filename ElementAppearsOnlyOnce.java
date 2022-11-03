package com.zoho.javaprograms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ElementAppearsOnlyOnce {

	public static void main(String[] args) {
		ElementAppearsOnlyOnce elementAppearsOnlyOnce = new ElementAppearsOnlyOnce();
		elementAppearsOnlyOnce.findTheElementOccursOnce();

	}

	private void findTheElementOccursOnce() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the arraySize");
		int arraySize = reader.nextInt();

		Map<Integer, Integer> findTheElements = new LinkedHashMap<Integer, Integer>();
		System.out.println("Enter the values");
		for (int index = 0; index < arraySize; index++) {
			int value = reader.nextInt();
			findTheElements.put(value, findTheElements.getOrDefault(value, 0) + 1);
		}

		int result = 0;
		for (Map.Entry<Integer, Integer> element : findTheElements.entrySet()) {

			if (element.getValue() == 1) {
				result = element.getKey();
				break;
			}
		}

		System.out.println(findTheElements.toString());
		System.out.println(result);
	}

}
