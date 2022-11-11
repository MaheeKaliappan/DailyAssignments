package loginpagecontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import loginmodel.Role;
import loginmodel.User;
import loginpageDAO.LoginDAO;


public class DisplayPage extends HttpServlet {
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		user.setUserFirstName(request.getParameter("firstName"));
		user.setUserLastName(request.getParameter("lastName"));
		user.setUserPassword(request.getParameter("password"));
		LoginDAO loginDAO = new LoginDAO();
		try {
			user.setUserId(loginDAO.fetchTheUserId(user));
			JSONObject jsonObject = loginDAO.fetchtheUserRoleAndDateOfJoining(user);
//			response.setContentType("application/json");
//			JSONObject resp = new JSONObject();
//			if(passengerObj != null) {
//				response.setStatus(HttpStatus.SC_ACCEPTED);
//				resp.put("data", new JSONArray().put(new JSONObject(passengerObj)));
//				resp.put("status", "success");
//			}
			 response.setContentType("application/json");
//			JSONObject jsonObject = new JSONObject();
//			
//			jsonObject.put("role",new JSONArray().put(new JSONObject(role)));
			request.setAttribute("jsonObject", jsonObject);
			//System.out.println("role : "+jsonObject.getString("role_id"));
			request.setAttribute("user", user);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/welcomepage.jsp");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if(user.getUserFirstName().equalsIgnoreCase("maheevk")&&user.getUserPassword().equalsIgnoreCase("12345"))
//		{
//			request.setAttribute("user", user);
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/welcomepage.jsp");
//			requestDispatcher.forward(request, response);
//		}
//		else
//		{	user.setUserFirstName("Invalid User Name");
//			request.setAttribute("user", user);
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/welcomepage.jsp");
//			requestDispatcher.forward(request, response);
//		}
		
	}

	

}
