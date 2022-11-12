package flightbooking.controller;

import flightbooking.model.User;
import flightbooking.view.AdminPage;
import flightbooking.view.UserPage;

public class LoginController {

	public void checkUserNameAndPassword(User user) {
		if(user.getUserName().equalsIgnoreCase("admin")&&user.getPassword().equalsIgnoreCase("admin"))
		{
			AdminPage adminPage = new AdminPage();
			adminPage.showAdminPage();
		}
		else
		{
			UserPage userPage = new UserPage();
			userPage.showUserPage(user);
			
		}
		
	}

}
