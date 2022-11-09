package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;


public class DisplayPage extends HttpServlet {
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		 LocalDateTime now = LocalDateTime.now(); 
		User user = new User();
		user.setUserName(request.getParameter("userName"));
		user.setUserPassword(request.getParameter("password"));
		user.setTodayDate(dateTimeFormatter.format(now));
		if(user.getUserName().equalsIgnoreCase("maheevk")&&user.getUserPassword().equalsIgnoreCase("12345"))
		{
			request.setAttribute("user", user);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/welcomepage.jsp");
			requestDispatcher.forward(request, response);
		}
		else
		{	user.setUserName("Invalid User Name");
			request.setAttribute("user", user);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/welcomepage.jsp");
			requestDispatcher.forward(request, response);
		}
		
	}

}
