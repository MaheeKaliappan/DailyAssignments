package com.zoho.javaprograms;

public class TwoStrings {

	public static void main(String[] args) {
		TwoStrings twoStrings = new TwoStrings();
		twoStrings.findStringIsSubStringOrNot();

	}

	private void findStringIsSubStringOrNot() {
		String s1 = "mahee";
		String s2 = "kishore";
		for (char i = 'a'; i <= 'z'; i++) {

			if ((s1.indexOf(i) != -1) && ((s2.indexOf(i) != -1))) {
				System.out.println("yes");
			}

		}
		System.out.println("no");
	}

}
