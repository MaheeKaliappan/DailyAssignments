package flightbooking.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import flightbooking.dao.FlightDAO;
import flightbooking.model.Flight;
import flightbooking.model.FlightRevenue;

public class AdminPage {
	FlightDAO flightDAO = new FlightDAO();
	private Scanner reader = new Scanner(System.in);
	public void showAdminPage() {
		Scanner reader = new Scanner(System.in);
		System.out.println("1.Create flight\n2.View Particular Flight\n3.View All Flight\n4.View Revenue\n5.logout");
		Integer adminChoice = reader.nextInt();
		switch (adminChoice) {
		case 1:
			createFlight();
			break;
		case 2:
			viewParticularFlight();
			break;
		case 3:
			viewAllFlight();
			break;
		case 4:
			viewRevenue();
			break;
		case 5:
			LoginPage loginPage = new LoginPage();
			loginPage.loginUser();
			break;

		default:
			System.out.println("Invalid Input");
			showAdminPage();
			break;
		}
		
		
	}
	private void viewAllFlight() {
		
		List<Flight> allFlightDetails =  flightDAO.fetchAllFlightDetails();
		showAllFlightDetails(allFlightDetails);
		
	}
	private void showAllFlightDetails(List<Flight> allFlightDetails) {
		if(allFlightDetails.size()==0)
		{
			System.out.println("Flights Not Avail");
		}
		else
		{
			System.out.printf("%20s %20s %20s %20s %20s %20s %20s %20s", "Flight Id","Flight Name", "Start From", "Reach To",
					"Travel Date", "Travelling Time", "Avail Seat", "Ticket Price");
			System.out.println();
			for (int index = 0; index < allFlightDetails.size(); index++) {
				System.out.println(
						"***********************************************************************************************************************************************************************************************");
				System.out.printf("%20s %20s %20s %20s %20s %20s %20s %20s", allFlightDetails.get(index).getFlightId(),
						allFlightDetails.get(index).getFlightName(), allFlightDetails.get(index).getFlightStartsFrom(),
						allFlightDetails.get(index).getFlightReachTo(), allFlightDetails.get(index).getFlightStartDate(),
						allFlightDetails.get(index).getFlightStartTime(), allFlightDetails.get(index).getFlightSeatCount(),
						allFlightDetails.get(index).getFlighTicketFare());
				System.out.println();
			}
			
		}
		showAdminPage();
		
		
	}
	private void viewRevenue() {
		
		List<FlightRevenue> flightRevenue = flightDAO.fetchRevenueDetails();
		showFlightRevenue(flightRevenue);
		
	}
	
	private void showFlightRevenue(List<FlightRevenue> flightRevenue) {
		if(flightRevenue.size()==0)
		{
			System.out.println("Flights Not Avail");
		}
		else
		{
			System.out.printf("%20s %20s %20s %20s  %20s %20s %20s ", "Flight Id","User Id","Travel Date","Ticket Count","Ticket Number","Ticket Status", "Revenue Amount");
			System.out.println();
			for (int index = 0; index < flightRevenue.size(); index++) {
				System.out.println(
						"***********************************************************************************************************************************************************************************************");
				System.out.printf("%20s %20s %20s %20s %20s %20s %20s", flightRevenue.get(index).getFlightId(),
						flightRevenue.get(index).getUserId(), flightRevenue.get(index).getTravelDate(),flightRevenue.get(index).getTicketCount(),flightRevenue.get(index).getTicketNumber(),flightRevenue.get(index).getTicketStatus(),
						flightRevenue.get(index).getRevenueAmount()) ;
				System.out.println();
			}
		}
		
		
		showAdminPage();
		
	}
	private void viewParticularFlight() {
		Flight flight = new Flight();
		System.out.println("Enter flight Id");
		flight.setFlightId(reader.nextInt());
		
		Flight flightDetails =  flightDAO.fetchFlightDetails(flight);
		showParticularFlightDetails(flightDetails);
		showAdminPage();
		
	}
	private void showParticularFlightDetails(Flight flightDetails) {
		if(flightDetails.getFlightId()== null)
		{
			System.out.println("Invalid flight id please give valid one");
			
		}
		else
		{
			System.out.printf("%20s %20s %20s %20s %20s %20s %20s %20s", "Flight Id","Flight Name", "Start From", "Reach To",
					"Travel Date", "Travelling Time", "Avail Seat", "Ticket Price");
			System.out.println();
			
				System.out.println(
						"***********************************************************************************************************************************************************************************************");
				System.out.printf("%20s %20s %20s %20s %20s %20s %20s %20s", flightDetails.getFlightId(),
						flightDetails.getFlightName(), flightDetails.getFlightStartsFrom(),
						flightDetails.getFlightReachTo(), flightDetails.getFlightStartDate(),
						flightDetails.getFlightStartTime(), flightDetails.getFlightSeatCount(),
						flightDetails.getFlighTicketFare());
				
		}
		showAdminPage();
				
		
	}
	private void createFlight() {
		try {
			Scanner reader = new Scanner(System.in);
			Flight flight = new Flight();
			System.out.println("enter flight name");
			flight.setFlightName(reader.next());
			System.out.println("enter flight id");
			flight.setFlightId(reader.nextInt());
			System.out.println("enter flight start date");
			flight.setFlightStartDate(reader.next());
			System.out.println("enter flight start time");
			flight.setFlightStartTime(reader.next());
			System.out.println("enter flight starts from");
			flight.setFlightStartsFrom(reader.next());
			System.out.println("enter flight reach to");
			flight.setFlightReachTo(reader.next());
			System.out.println("enter flight seat count");
			flight.setFlightSeatCount(reader.nextInt());
			System.out.println("enter flight ticket fare");
			flight.setFlighTicketFare(reader.nextInt());
			FlightDAO flightDAO = new FlightDAO();
			flightDAO.addFlight(flight);
			System.out.println("Fight Added successfully");
			showAdminPage();
			
		}
		catch(InputMismatchException inputMismatchException)
		{
			System.out.println("Input mismatch please give valid input");
			createFlight();
		}
		
	}

}
