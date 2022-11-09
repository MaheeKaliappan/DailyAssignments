package com.zoho.javaprograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class FrequencyOfElements {

	public static void main(String[] args) {

		int array[] = new int[] { 2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12 };

		Map<Integer, Integer> valuesCount = new LinkedHashMap<Integer, Integer>();

		for (int i = 0; i < array.length; i++) {

			valuesCount.put(array[i], valuesCount.getOrDefault(array[i], 0) + 1);

		}

		ArrayList<Entry<Integer, Integer>> list = new ArrayList<>(valuesCount.entrySet());

		Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		for (Entry<Integer, Integer> entry : list) {
			int frequency = entry.getValue();
			while (frequency >= 1) {
				System.out.print(entry.getKey() + " ");
				frequency--;
			}

		}

	}
}
