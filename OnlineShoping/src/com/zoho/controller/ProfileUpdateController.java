package com.zoho.controller;

import java.util.Scanner;

import com.zoho.model.User;

public class ProfileUpdateController {
	
	LoginPage loginPage = new LoginPage();
	public void changePassword() {
		LoginPage loginPage = new LoginPage();
		Scanner reader = new Scanner(System.in);
		User user = new User();
		System.out.println("enter user mail");
		user.setUserMailId(reader.next());
		System.out.println("enter old passwrd");
		user.setPersonPassword(reader.next());
		user.setPersonPassword(loginPage.passwordEncryption(user.getPersonPassword()));
		
		boolean userDataFound =  loginPage.fetchUserDataPresentOrNot(user);
		if(userDataFound)
		{
			System.out.println("enter new passwrd");
			user.setPersonPassword(reader.next());
			loginPage.updatePassword(user);
			
		}
		else
		{
			System.out.println("invalid password try again");
			changePassword();
		}
		
		
	}
	public void updateProfile() {
		User user = new User();
		Scanner reader = new Scanner(System.in);
		System.out.println("enter user mailId");
		
		user.setUserMailId(reader.next());
		System.out.println("enter updated Name");
		user.setPersonName(reader.next());
		System.out.println("enter new password");
		user.setPersonPassword(reader.next());
		user.setPersonPassword(loginPage.passwordEncryption(user.getPersonPassword()));
		loginPage.updateProfile(user);
		//loginPage.adminFunctionality();
		
	}

}
