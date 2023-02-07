package com.zoho.controller;

import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.zoho.model.User;
import com.zoho.model.Product;
import com.zoho.service.LoginService;

public class LoginPage {
	static Map<String, User> userDetails = new TreeMap<>();
	static Map<String, Product> productDetails = new TreeMap<>();
	static Map<String, List<Product>> cartDetails = new TreeMap<>();

	Integer userId = 1;
	static Integer productId = 1;
	String userRole = "";
	String userMail = "";

	public void showFunctionality() {

		LoginService loginService = new LoginService();
		User user = loginService.addAdmin();

		user.setUserMailId("admin");
		user.setPersonId(userId++);

		userDetails.put(user.getUserMailId(), user);

		System.out.println("1.login\n2.Signup\n3.LogOut");
		Scanner reader = new Scanner(System.in);
		try {

			int userChoice = reader.nextInt();
			switch (userChoice) {
			case 1:
				login();
				break;
			case 2:
				signup();
				break;
			case 3:
				System.out.println("Thanks");
				showFunctionality();
				break;

			default:
				System.out.println("invalid Input");
				showFunctionality();
				break;
			}
		} catch (InputMismatchException inputMismatchException) {
			System.out.println("InputMismatchException Please GIve A Valid One");
			showFunctionality();
		}

	}

	private void signup() {

		User user = new User();
		Scanner reader = new Scanner(System.in);
		System.out.println("enter mail id");
		user.setUserMailId(reader.next());
		System.out.println("Enter the name");
		user.setPersonName(reader.next());
		System.out.println("Enter password");
		String password = reader.next();
		user.setPersonPassword(passwordEncryption(password));

		user.setPersonRole("USER");
		user.setPersonId(userId++);
		user.setUserBalance(5000);
		userMail = user.getUserMailId();
		userDetails.put(user.getUserMailId(), user);
		userFunctionality();

	}

	public String passwordEncryption(String password) {
		String encryptedString = "";
		for (int index = 0; index < password.length(); index++) {
			char c = (char) (password.charAt(index) + 1);
			encryptedString += String.valueOf(c);
		}
		return encryptedString;
	}

	private void login() {
		Scanner reader = new Scanner(System.in);
		User user = new User();
		System.out.println("Enter a mail id");
		user.setUserMailId(reader.next());
		System.out.println("Enter a Passwrd");
		String password = reader.next();
		user.setPersonPassword(passwordEncryption(password));

		if (userDetails.containsKey(user.getUserMailId())
				&& userDetails.get(user.getUserMailId()).getPersonPassword().equals(user.getPersonPassword())) {
			userMail = user.getUserMailId();
			if (userDetails.get(user.getUserMailId()).getPersonRole().equalsIgnoreCase("admin")) {
				userRole = "Admin";
				adminFunctionality();
			} else if (userDetails.get(user.getUserMailId()).getPersonRole().equalsIgnoreCase("manager")) {
				userRole = "Manager";
				managerFunctionality();
			} else {
				userFunctionality();
			}
		} else {
			System.out.println("invalid mail id password");
			signup();
		}
//		for (Map.Entry<String, User> person : userDetails.entrySet()) {
//			if (person.getKey().equalsIgnoreCase(user.getUserMailId())
//					&& person.getValue().getPersonPassword().equalsIgnoreCase(user.getPersonPassword())) {
//
//				if (person.getValue().getPersonRole().equalsIgnoreCase("admin")) {
//					userRole=person.getValue().getPersonRole();
//					adminFunctionality();
//				} else if (person.getValue().getPersonRole().equalsIgnoreCase("manager")) {
//					userRole=person.getValue().getPersonRole();
//					managerFunctionality();
//				} else {
//					userFunctionality();
//				}
//			}
//		}

	}

	public void userFunctionality() {
		System.out.println(
				"1. Change Password\n2. Update profile\n3. View products ( Name, description, unit price, stock quantity)\n4. Add to Cart (making an order)\n5. Remove an item from cart\n6. View Cart (List of products, price, quantity,estimated bill & current balance in wallet)\n7. Purchase\n8. Cancel Order / Discard Cart\n9. View purchase history\n10. Add money to wallet\n11. View wallet balance\n12. Redeem reward points\n13.log out");
		UserController userController = new UserController();
		Scanner reader = new Scanner(System.in);
		ProfileUpdateController profileUpdateController = new ProfileUpdateController();
		try {
			int userChoice = reader.nextInt();
			switch (userChoice) {
			case 1:
				profileUpdateController.changePassword();
				break;
			case 2:
				profileUpdateController.updateProfile();
				break;
			case 3:
				userController.viewProducts(productDetails);
				userFunctionality();
				break;
			case 4:
				userController.addToCart();
				userFunctionality();
				break;
			case 5:
				userController.removeCart();
				userFunctionality();
				break;
			case 6:
				userController.viewCart(userRole, cartDetails,userDetails,userMail);
				userFunctionality();
				break;
			case 7:
					
				//userController.purchase();
				userFunctionality();
				break;
			case 8:
				//userController.cancelOrder();
				userFunctionality();
				break;
			case 9:
				//userController.purchaseHistory();
				// userFunctionality();
				break;

			case 10:
				addMoneyToWallet(userRole);
				userFunctionality();
				break;
			case 11:
				viewWallet(userRole);
				userFunctionality();

				break;
			case 12:
				//userController.rewardPoints();
				userFunctionality();
				break;
			case 13:
				System.out.println("Thanks For Visit");
				userRole = "";
				showFunctionality();
				break;

			default:
				System.out.println("invalid Input");
				showFunctionality();
				break;
			}
		} catch (InputMismatchException inputMismatchException) {
			System.out.println("InputMismatchException Please Give A Valid One");
			showFunctionality();
		}

	}

	private void addMoneyToWallet(String userRole) {
		userDetails.get(userRole).setUserBalance(userDetails.get(userRole).getUserBalance() + 5000);

	}

	private void viewWallet(String userRole) {
		System.out.println(userDetails.get(userRole).getUserBalance());

	}

	private void managerFunctionality() {
		System.out.println(
				"1.Change password\n2.Update Profile\n3.Add inventory\n4.Update Inventory\n5.Remove Inventory\n6.View Inventory\n7.Logout");
		AdminAndManagerController adminAndManagerController = new AdminAndManagerController();
		Scanner reader = new Scanner(System.in);
		ProfileUpdateController profileUpdateController = new ProfileUpdateController();
		try {
			int managerChoice = reader.nextInt();
			switch (managerChoice) {
			case 1:
				profileUpdateController.changePassword();
				break;
			case 2:
				profileUpdateController.updateProfile();
				break;
			case 3:
				adminAndManagerController.addInventory(userRole);
				managerFunctionality();
				break;
			case 4:
				adminAndManagerController.updateInventory(userRole);
				managerFunctionality();
				break;
			case 5:
				adminAndManagerController.removeInventory();
				managerFunctionality();
				break;
			case 6:
				adminAndManagerController.viewInventory(productDetails);
				managerFunctionality();
				break;

			case 7:
				System.out.println("Thanks For Visit");
				userRole = "";
				showFunctionality();
				break;

			default:
				System.out.println("invalid Input");
				showFunctionality();
				break;
			}
		} catch (InputMismatchException inputMismatchException) {
			System.out.println("InputMismatchException Please Give A Valid One");
			showFunctionality();
		}

	}

	public void adminFunctionality() {
		Scanner reader = new Scanner(System.in);
		System.out.println(
				"1.Change password\n2.Update Profile\n3.Create Manager\n4.Update Manager\n5.Remove Manager\n6.Add inventory\n7.Update Inventory\n8.Remove Inventory\n9.View Inventory\n10.Logout");
		AdminController adminController = new AdminController();
		AdminAndManagerController adminAndManagerController = new AdminAndManagerController();

		ProfileUpdateController profileUpdateController = new ProfileUpdateController();
		try {
			int adminChoice = reader.nextInt();
			switch (adminChoice) {
			case 1:
				profileUpdateController.changePassword();
				break;
			case 2:
				profileUpdateController.updateProfile();
				break;
			case 3:
				User user = adminController.createManager();
				user.setPersonId(userId++);
				userDetails.put(user.getUserMailId(), user);
				adminFunctionality();
				break;
			case 4:
				adminController.updateManager();
				adminFunctionality();
				break;
			case 5:
				adminController.removeManager();
				adminFunctionality();
				break;
			case 6:
				adminAndManagerController.addInventory(userRole);
				adminFunctionality();
				break;
			case 7:
				adminAndManagerController.updateInventory(userRole);
				adminFunctionality();
				break;
			case 8:
				adminAndManagerController.removeInventory();
				adminFunctionality();
				break;
			case 9:
				adminAndManagerController.viewInventory(productDetails);
				adminFunctionality();
				break;

			case 10:

				System.out.println("Thanks For Visit");
				userRole = "";
				showFunctionality();
				break;

			default:
				System.out.println("invalid Input");
				showFunctionality();
				break;
			}
		} catch (InputMismatchException inputMismatchException) {
			System.out.println("InputMismatchException Please Give A Valid One");
			showFunctionality();
		}
	}

	public boolean fetchUserDataPresentOrNot(User user) {
		if (userDetails.containsKey(user.getUserMailId())) {
			if (userDetails.get(user.getUserMailId()).getPersonPassword().equals(user.getPersonPassword())) {
				return true;
			}
		}
		return false;
	}

	public void updatePassword(User user) {
		user.setPersonId(userDetails.get(user.getUserMailId()).getPersonId());
		user.setPersonRole(userDetails.get(user.getUserMailId()).getPersonRole());
		user.setUserBalance(userDetails.get(user.getUserMailId()).getUserBalance());
		userDetails.put(user.getUserMailId(), user);

	}

	public void updateProfile(User user) {
		user.setPersonId(userDetails.get(user.getUserMailId()).getPersonId());
		user.setPersonRole(userDetails.get(user.getUserMailId()).getPersonRole());
		user.setUserBalance(userDetails.get(user.getUserMailId()).getUserBalance());
		userDetails.put(user.getUserMailId(), user);
		adminFunctionality();

	}

	public boolean fetchManagerRecored(User user) {
		return userDetails.containsKey(user.getUserMailId());

	}

	public void removeManager(User user) {
		userDetails.remove(user.getUserMailId());

	}

	public void addInventory(Product product) {
		product.setProductId(productId++);
		productDetails.put(product.getProductBrandName() + product.getProductName(), product);

	}

	public boolean fetchInventoryRecord(Product product) {
		return productDetails.containsKey(product.getProductBrandName() + product.getProductName());
	}

	public void updateInventory(Product product) {
		productDetails.put(product.getProductBrandName() + product.getProductName(), product);
	}

	public void removeInventory(Product product) {
		productDetails.remove(product.getProductBrandName() + product.getProductName());

	}

	public void addCart(Product product) {
		List<Product> productList = new ArrayList<>();
		productList.add(product);
		cartDetails.put(userMail, productList);

	}

	public boolean fetchCartRecord(Product product) {

		if (cartDetails.containsKey(userMail)) {
			for (int index = 0; index < cartDetails.get(userRole).size(); index++) {
				if (cartDetails.get(userRole).get(index).getProductBrandName()
						+ cartDetails.get(userRole).get(index).getProductName()
								.equalsIgnoreCase(product.getProductBrandName() + product.getProductName()) != null) {
					return true;
				}
			}
		}
		return false;
	}

	public void removeCart(Product product) {
		if(cartDetails.containsKey(userMail))
		{
			for(int index = 0;index<cartDetails.get(userMail).size();index++)
			{
				if(cartDetails.get(userMail).get(0).getProductBrandName().equalsIgnoreCase(product.getProductBrandName()))
				{
					cartDetails.get(userMail).remove(cartDetails.get(userMail).get(index));
				}
			}
			
		}
		
	}
}
