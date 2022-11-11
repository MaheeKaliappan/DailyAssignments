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
			if(user.getUserId()==null)
			{
				request.setAttribute("errorMsg", "Invalid User Name Please Give a Valid One");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/login.jsp");
				requestDispatcher.forward(request, response);
			}
			JSONObject jsonObject = loginDAO.fetchtheUserRoleAndDateOfJoining(user);		
			 response.setContentType("application/json");
			 request.setAttribute("jsonObject", jsonObject);
			
			request.setAttribute("user", user);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/welcomepage.jsp");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
	}

	

}
