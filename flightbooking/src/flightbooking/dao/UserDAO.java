package flightbooking.dao;

import java.util.ArrayList;
import java.util.List;

import flightbooking.model.User;

public class UserDAO {
	static private List<User> userList = new ArrayList<User>();
	public void addUser(User user) {
		
		userList.add(user);
		
	}
	public User fetchUserDetails(User user) {
		User userDetails = new User();
		for(int index = 0;index<userList.size();index++)
		{
			if(user.getUserId()== userList.get(index).getUserId())
			{
				 
				 userDetails.setUserName(userList.get(index).getUserName());
				 userDetails.setUserId(userList.get(index).getUserId());
				 userDetails.setUserGender(userList.get(index).getUserGender());
				 userDetails.setUserAge(userList.get(index).getUserAge());
				 break;
				 
			}
			
		}
		return userDetails;
		
	}

}
