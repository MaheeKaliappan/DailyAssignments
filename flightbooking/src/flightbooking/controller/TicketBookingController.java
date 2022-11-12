package flightbooking.controller;

import java.util.List;
import java.util.Random;

import flightbooking.dao.FlightDAO;
import flightbooking.model.Flight;
import flightbooking.model.FlightRevenue;
import flightbooking.model.TicketBooking;
import flightbooking.model.User;

public class TicketBookingController {
	private static FlightDAO flightDAO = new FlightDAO();
	public Boolean ticketBooking(Flight flight, User user) {
		
		List<Flight> listOfFlight = flightDAO.getFlightList();
		for(int index =0;index< listOfFlight.size();index++)
		{
			if(listOfFlight.get(index).getFlightId().equals(flight.getFlightId()))
			{
				if(listOfFlight.get(index).getFlightSeatCount()>= flight.getFlightSeatCount())
				{
					
					TicketBooking ticketBooking = new TicketBooking();
					ticketBooking.setFlightId(flight.getFlightId());
					ticketBooking.setUserId(user.getUserId());
					ticketBooking.setBookedTicketCount(flight.getFlightSeatCount());
					ticketBooking.setTicketStatus("BOOKED");
					ticketBooking.setTravelDate(flight.getFlightStartDate());
					Random random = new Random();
					String ticketNumber = "PNR";
					for (int randomNumber = 0; randomNumber < 5; randomNumber++) {
						int number = random.nextInt(9);
						ticketNumber += number;
					}
					
					ticketBooking.setTicketNumber(ticketNumber);
					
					int seatCount = listOfFlight.get(index).getFlightSeatCount();
					listOfFlight.get(index).setFlightSeatCount(seatCount-flight.getFlightSeatCount()); 
					
					FlightRevenue flightRevenue = new FlightRevenue();
					
					flightRevenue.setFlightId(flight.getFlightId());
					flightRevenue.setUserId(user.getUserId());
					flightRevenue.setTicketNumber(ticketNumber);
					flightRevenue.setTicketCount(flight.getFlightSeatCount());
					flightRevenue.setTravelDate(flight.getFlightStartDate());
					flightRevenue.setRevenueAmount(flight.getFlightSeatCount() * listOfFlight.get(index).getFlighTicketFare());
					flightRevenue.setTicketStatus("BOOKED");
					
					
					flightDAO.addTicketBooking(ticketBooking);
					
					flightDAO.addFlightRevenue(flightRevenue); 
					return true;
				
					
				}
				else
				{
					System.out.println("Avail Seats : "+listOfFlight.get(index).getFlightSeatCount());
					
				}
			}
			
		}
		return false;
		
		
		
	}

}
