package com.zoho.javaprograms;

import java.util.Arrays;

public class PushSevenAtTheEnd {

	public static void main(String[] args) {
		int array[] = new int[] { 1, 9, 8, 4, 7, 7, 2, 0, 7, 6, 7 };
		
		int arrayTwo[] = new int[]  {3, 7, 3, 7, 3, 7, 3, 7};
		
		int startPosition = 0;
		int endPosition = arrayTwo.length - 1;
		int mid = arrayTwo.length / 2;

		while (startPosition < mid || mid < endPosition) {
			if (arrayTwo[startPosition] == 7 || arrayTwo[endPosition] != 7) {

				int temp = arrayTwo[endPosition];
				arrayTwo[endPosition] = 7;
				arrayTwo[startPosition] = temp;
			}

			startPosition++;
			endPosition--;
			
		}
		System.out.println(Arrays.toString(arrayTwo));

	}

}
