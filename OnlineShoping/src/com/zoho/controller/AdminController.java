package com.zoho.controller;

import java.util.Scanner;

import com.zoho.model.User;

public class AdminController {

	public User createManager() {

		Scanner reader = new Scanner(System.in);
		User user = new User();
		System.out.println("manager mail id");
		user.setUserMailId(reader.next());
		System.out.println("manager name");
		user.setPersonName(reader.next());
		user.setPersonRole("Manager");
		user.setPersonPassword("manager");
		LoginPage loginPage = new LoginPage();
		user.setPersonPassword(loginPage.passwordEncryption(user.getPersonPassword()));
		
		return user;
		
	}

	public void updateManager() {
		Scanner reader = new Scanner(System.in);
		User user = new User();
		System.out.println("Manager mailId");
		user.setUserMailId(reader.next());
		LoginPage loginPage = new LoginPage();
		boolean managerFound = loginPage.fetchManagerRecored(user);
		if(managerFound)
		{
			System.out.println("Manager new name");
			user.setPersonName(reader.next());
			loginPage.updateProfile(user);
		}
		else
		{
			System.out.println("Invalid manger mailId");
		}
		
	}

	public void removeManager() {
		Scanner reader = new Scanner(System.in);
		User user = new User();
		System.out.println("Manager mailId");
		user.setUserMailId(reader.next());
		LoginPage loginPage = new LoginPage();
		boolean managerFound = loginPage.fetchManagerRecored(user);
		if(managerFound)
		{
			loginPage.removeManager(user);
		}
		else
		{
			System.out.println("Invalid manger mailId");
		}
	}

}
