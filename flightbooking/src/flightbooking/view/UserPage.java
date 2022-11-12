package flightbooking.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import flightbooking.controller.FlightController;
import flightbooking.controller.TicketBookingController;
import flightbooking.dao.FlightDAO;
import flightbooking.dao.UserDAO;
import flightbooking.model.Flight;
import flightbooking.model.TicketBooking;
import flightbooking.model.User;

public class UserPage {

	private static User user = new User();
	private static TicketBookingController ticketBookingController = new TicketBookingController();
	private static FlightDAO flightDAO = new FlightDAO();
	
	public void showUserPage(User user) {
		this.user = user;
		Scanner reader = new Scanner(System.in);	
		
		try {
			
				System.out.println("enter age");
				user.setUserAge(reader.nextInt());
				System.out.println("enter gender");
				user.setUserGender(reader.next());
				System.out.println("enter user id");
				user.setUserId(reader.nextInt());
				UserDAO userDAO = new UserDAO();
				userDAO.addUser(user);
				
				showFunctionality();
			
			
		}
		catch(InputMismatchException inputMismatchException)
		{
			System.out.println("input mismatched pleasse give valid input");
			
			showUserPage(user);
		}
		
		
	}
	private void showFunctionality() {
		Scanner reader = new Scanner(System.in);
		System.out.println("1.Ticket Booking\n2.Ticket status\n3.Cancel Ticket\n4.View My Self\n5.Logout");
		Integer userChoice = reader.nextInt();
		switch (userChoice) {
		case 1: 
			ticketBooking();
			break;
		case 2: 
			ticketStatus();
			break;
		case 3: 
			cancelTicket();
			break;
		case 4: 
			viewMyDetails();
			break;
		case 5: 
			LoginPage loginPage= new LoginPage();
			loginPage.loginUser();
			break;

		default:
			System.out.println("Invalid Input");
			showFunctionality();
			break;
		}
		
	}
	private void viewMyDetails() {
		UserDAO userDao = new UserDAO();
		User userDetails = 	userDao.fetchUserDetails(user);
		showUserDetails(userDetails);
		
		
	}
	private void showUserDetails(User userDetails) {
		if(userDetails.equals(null))
		{
			System.out.println("user details not found");
		}
		else
		{
			System.out.println("User Name   : "+userDetails.getUserName());
			System.out.println("User Gender : "+userDetails.getUserGender());
			System.out.println("User Age    : "+userDetails.getUserAge());
			System.out.println("User Id     : "+userDetails.getUserId());
			
		}
		showFunctionality();
		
		
	}
	private void ticketStatus() {
		
		List<TicketBooking>ticketBookings = flightDAO.fetchBookedTicketList(user);
		
		showBookedTickets(ticketBookings);
		
	}
	private void showBookedTickets(List<TicketBooking> ticketBookings) {
		if(ticketBookings.size()==0)
		{
			System.out.println("No Ticket Bookings");
		}
		else
		{
			System.out.printf("%20s %20s %20s %20s %20s ", "Flight Id","Booked Ticket Count","Ticket Status","Ticket Number","Travel Date ");
			System.out.println();
			for (int index = 0; index < ticketBookings.size(); index++) {
				System.out.println(
						"***********************************************************************************************************************************************************************************************");
				System.out.printf("%20s %20s %20s %20s %20s ", ticketBookings.get(index).getFlightId(),
						ticketBookings.get(index).getBookedTicketCount(),
						ticketBookings.get(index).getTicketStatus(), ticketBookings.get(index).getTicketNumber(),
						ticketBookings.get(index).getTravelDate());
				System.out.println();
			}
			
		}
		showFunctionality();
		
	}
	private void cancelTicket() {
		Scanner reader = new Scanner(System.in);
		TicketBookingController ticketBookingController = new TicketBookingController();
		System.out.println("Enter flight id");
		Integer flightId = reader.nextInt();
		System.out.println("ticketCount");
		Integer ticketCount = reader.nextInt();
		System.out.println("PNR number");
		String pnrNumber = reader.next();
		flightDAO.ticketCancelling(flightId,ticketCount,pnrNumber,user);
		showFunctionality();
		
		
	}
	private void ticketBooking() {
		Scanner reader = new Scanner(System.in);
		
		List<Flight> flightList = flightDAO.getFlightList();
		if(flightList.size()==0)
		{
			System.out.println("Flight Not Avail");
		}
		else
		{
			Flight flight = new Flight();
			System.out.println("Enter Starts From");
			flight.setFlightStartsFrom(reader.next());
			System.out.println("Enter Reach To");
			flight.setFlightReachTo(reader.next());
			System.out.println("Enter Date");
			flight.setFlightStartDate(reader.next());
			List<Flight>availFlights = flightDAO.fetchTheFlightDetails(flight);
			showFlights(availFlights);
			getFlightDetails(flight);
		}
		showFunctionality();
		
		
	}
	private void getFlightDetails(Flight flightDate) {
		Scanner reader = new Scanner(System.in);
		Flight flight = new Flight();
		
		flight.setFlightStartDate(flightDate.getFlightStartDate());
		System.out.println("Enter Flight Id");
		flight.setFlightId(reader.nextInt());
		System.out.println("Enter seatCount");
		flight.setFlightSeatCount(reader.nextInt());
	
	
		ticketBookingStatus(ticketBookingController.ticketBooking(flight,user));
		
		
		
	}
	private void ticketBookingStatus(Boolean ticketBooking) {
		if(ticketBooking)
		{
			System.out.println("Ticket booking Successfully");
		}
		else
		{
			System.out.println("Ticket Count Mismatched");
		}
		
	}
	private void showFlights(List<Flight> availFlights) {
		if(availFlights.size()==0)
		{
			System.out.println("Flight Not Avail");
		}
		else
		{
			System.out.printf("%20s %20s %20s %20s %20s %20s %20s %20s", "Flight Id","Flight Name", "Start From", "Reach To",
					"Travel Date", "Travelling Time", "Avail Seat", "Ticket Price");
			System.out.println();
			for (int index = 0; index < availFlights.size(); index++) {
				System.out.println(
						"***********************************************************************************************************************************************************************************************");
				System.out.printf("%20s %20s %20s %20s %20s %20s %20s %20s", availFlights.get(index).getFlightId(),
						availFlights.get(index).getFlightName(), availFlights.get(index).getFlightStartsFrom(),
						availFlights.get(index).getFlightReachTo(), availFlights.get(index).getFlightStartDate(),
						availFlights.get(index).getFlightStartTime(), availFlights.get(index).getFlightSeatCount(),
						availFlights.get(index).getFlighTicketFare());
				System.out.println();
			}
		}
		
	}

}
