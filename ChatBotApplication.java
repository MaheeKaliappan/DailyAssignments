package com.zoho.javaprograms;

import java.util.Scanner;
import java.util.Stack;

public class ChatBotApplication {

	Stack<Integer> chatBot = new Stack<Integer>();
	Stack<String> foodItems = new Stack<String>();

	public static void main(String[] args) {
		ChatBotApplication chatBotApplication = new ChatBotApplication();
		chatBotApplication.addFunctionality();
	}

	private void addFunctionality() {
		Scanner reader = new Scanner(System.in);
		System.out.println("1.Drinks\n2.Snaks\n3.Show Your Order\n4.Exit");

		chatBot.push(reader.nextInt());
		if (chatBot.peek() == 1) {
			drinks();

		} else if (chatBot.peek() == 2) {
			snaks();
		} else if (chatBot.peek() == 3) {
			showYourOrder();
		} else if (chatBot.peek() == 4) {
			System.out.println("Thank You");
		} else {
			System.out.println("Invalid Input");
		}

	}

	private void snaks() {
		Scanner reader = new Scanner(System.in);
		System.out.println("1.Samosa\n2.Puffs\n3Back");
		switch (reader.nextInt()) {
		case 1:
			foodItems.push("Samosa");
			snaks();
			break;
		case 2:
			foodItems.push("Puffs");
			snaks();
			break;
		case 3:
			addFunctionality();

		default:
			System.out.println("Invalid Input");
			break;
		}

	}

	private Object drinks() {
		Scanner reader = new Scanner(System.in);
		System.out.println("1.Cool DrinkS\n2.Hot Drinks\n3.Back");
		switch (reader.nextInt()) {
		case 1:
			coolDrinksCategories();
			drinks();
			break;
		case 2:
			hotDrinksCategories();
			drinks();
			break;

		case 3:
			addFunctionality();

		default:
			System.out.println("Invalid Input");
			break;
		}
		return chatBot;

	}

	private void showYourOrder() {
		Scanner reader = new Scanner(System.in);
		if (foodItems.empty()) {
			System.out.println("No Orders :( Please Order First");
			addFunctionality();
		}
		System.out.println("Your Last Order is " + foodItems.peek());
		System.out.println("Do you want cancel? press 1");
		if (reader.nextInt() == 1) {
			cancelOrder();
		} else if (reader.nextInt() == 2) {
			System.out.println("Order Is Conformed :)");
			showYourOrder();
		} else {
			System.out.println("Invalid Input");
			showYourOrder();
		}

	}

	private void cancelOrder() {
		System.out.println(foodItems.pop() + " Your Order Is Cancel ");
		showYourOrder();

	}

	private void hotDrinksCategories() {
		Scanner reader = new Scanner(System.in);
		System.out.println("1.Tea\n2.Coffee\n3.Back");
		if (reader.nextInt() == 1) {
			foodItems.push("Tea");
			hotDrinksCategories();
		} else if (reader.nextInt() == 2) {
			foodItems.push("Coffee");
			hotDrinksCategories();
		} else if (reader.nextInt() == 3) {
			drinks();
		} else {
			System.out.println("Invalid Input");
			hotDrinksCategories();
		}

	}

	private void coolDrinksCategories() {

		Scanner reader = new Scanner(System.in);
		System.out.println("1.Orange juice\n2.Mango juice\n3.Back");
		if (reader.nextInt() == 1) {
			foodItems.push("Orange Juice");
			coolDrinksCategories();
		} else if (reader.nextInt() == 2) {
			foodItems.push("Mango Juice");
			coolDrinksCategories();
		} else if (reader.nextInt() == 3) {

			drinks();
		} else {
			System.out.println("Invalid Input");
			coolDrinksCategories();
		}

	}

}
