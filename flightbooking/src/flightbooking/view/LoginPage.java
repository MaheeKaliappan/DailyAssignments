package flightbooking.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import flightbooking.controller.LoginController;
import flightbooking.model.User;

public class LoginPage {
	private Scanner reader = new Scanner(System.in);
	
	public void loginUser() {
		Scanner reader = new Scanner(System.in);
		try {
			System.out.println("enter your name");
			User user = new User();
			user.setUserName(reader.next());
			System.out.println("enter your password");
			user.setPassword(reader.next());
			LoginController loginController = new LoginController();
			loginController.checkUserNameAndPassword(user);
		}
		catch(InputMismatchException inputMismatchException)
		{
			System.out.println("input mismatch please give valid input");
			loginUser();
			
		}
		
		
	}

}
