package formValidation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import formValidation.model.Form;


public class FormValidator extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Form form = new Form();
		form.setFirstName(request.getParameter("firstName"));
		form.setLastName(request.getParameter("lastName"));
		form.setEmailId(request.getParameter("email"));
		form.setMobileNumber(request.getParameter("mobileNumber"));
		form.setAadharNumber(request.getParameter("aadharNumber"));
		form.setDateOfBirth(request.getParameter("dateOfBirth"));
		form.setGender(request.getParameter("gender"));
		request.setAttribute("form", form);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/applicationDetails.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
