package loginpageDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.json.JSONObject;

import loginmodel.Role;
import loginmodel.User;


public class LoginDAO {
	
	static Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	private void getConnection() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/employee?characterEncoding=latin1&useConfigs=maxPerformance", "root",
				"root");
	}
	
	public Integer fetchTheUserId(User user) throws SQLException, ClassNotFoundException {
		getConnection();
		String sqlQuery="SELECT ID FROM USER WHERE FIRST_NAME=? AND LAST_NAME=? AND PASSWORD=?";
		preparedStatement = connection.prepareStatement(sqlQuery);
		
		preparedStatement.setString(1,user.getUserFirstName());
		preparedStatement.setString(2,user.getUserLastName());
		preparedStatement.setString(3,user.getUserPassword());
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			return resultSet.getInt(1);

		}
		
		return null;
	}

	public JSONObject fetchtheUserRoleAndDateOfJoining(User user) throws SQLException, ClassNotFoundException {
		getConnection();
		
		String sqlQuery="SELECT ROLE_ID,date_of_joining FROM user_details WHERE user_id=?";
		
		preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setInt(1,user.getUserId());
		resultSet = preparedStatement.executeQuery();
		Role role = new Role();
		 JSONObject obj = new JSONObject();
		while (resultSet.next()) {
			

		      obj.put("role_id",resultSet.getInt(1));
		      obj.put("date_of_joining",resultSet.getDate(2));
		     
			System.out.println("im here");
			role.setRoleId(resultSet.getInt(1));
			role.setDateOfJoining(resultSet.getDate(2));
			
			
	
		}
		
		return obj;
			
		}
}
