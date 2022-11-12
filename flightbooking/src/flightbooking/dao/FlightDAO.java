package flightbooking.dao;

import java.util.ArrayList;
import java.util.List;


import flightbooking.model.Flight;
import flightbooking.model.FlightRevenue;
import flightbooking.model.TicketBooking;
import flightbooking.model.User;

public class FlightDAO {
	static private List<Flight>flightList = new ArrayList<Flight>();
	static private List<TicketBooking>ticketBookings = new ArrayList<TicketBooking>();
	static private List<FlightRevenue>flightRevenueList = new ArrayList<FlightRevenue>();
	

	public void addFlight(Flight flight) {
		flightList.add(flight);
		
	}
	public void addTicketBooking(TicketBooking ticketBooking) {
		ticketBookings.add(ticketBooking);
	}
	public void addFlightRevenue(FlightRevenue flightRevenue) {
		flightRevenueList.add(flightRevenue);
		
	}


	public List<Flight> getFlightList() {
		return flightList;
		
	}
	public List<Flight> fetchAllFlightDetails() {
		
		return flightList;
	}
	public List<FlightRevenue> fetchRevenueDetails() {
		
		return flightRevenueList;
	}

	public List<Flight> fetchTheFlightDetails(Flight flight) {
		List<Flight> availFlights = new ArrayList<Flight>();
		for(int index = 0;index<flightList.size();index++)
		{
			
			if(flightList.get(index).getFlightStartsFrom().equalsIgnoreCase(flight.getFlightStartsFrom()) && 
					flightList.get(index).getFlightReachTo().equalsIgnoreCase(flight.getFlightReachTo()) &&
					flightList.get(index).getFlightStartDate().equals(flight.getFlightStartDate()))
			{
				Flight availFlight = new Flight();
				availFlight.setFlightName(flightList.get(index).getFlightName());
				availFlight.setFlightId(flightList.get(index).getFlightId());
				availFlight.setFlightStartsFrom(flightList.get(index).getFlightStartsFrom());
				availFlight.setFlightReachTo(flightList.get(index).getFlightReachTo());
				availFlight.setFlightStartDate(flightList.get(index).getFlightStartDate());
				availFlight.setFlightStartTime(flightList.get(index).getFlightStartTime());
				availFlight.setFlightSeatCount(flightList.get(index).getFlightSeatCount());
				availFlight.setFlighTicketFare(flightList.get(index).getFlighTicketFare());
				availFlights.add(availFlight);
			}
		}
		return availFlights;
		
	}
	public Flight fetchFlightDetails(Flight flight) {
		Flight flightDetails = new Flight();
		for(int index = 0;index<flightList.size();index++)
		{
			if(flightList.get(index).getFlightId().equals(flight.getFlightId()))
			{
				flightDetails.setFlighTicketFare(flightList.get(index).getFlighTicketFare());
				flightDetails.setFlightId(flightList.get(index).getFlightId());
				flightDetails.setFlightName(flightList.get(index).getFlightName());
				flightDetails.setFlightReachTo(flightList.get(index).getFlightReachTo());
				flightDetails.setFlightSeatCount(flightList.get(index).getFlightSeatCount());
				flightDetails.setFlightStartDate(flightList.get(index).getFlightStartDate());
				flightDetails.setFlightStartsFrom(flightList.get(index).getFlightStartsFrom());
				flightDetails.setFlightStartTime(flightList.get(index).getFlightStartTime());
				
			}
			
		}
		return flightDetails;
		
	}
	
	public void ticketCancelling(Integer flightId, Integer ticketCount,String pnrNumber ,User user) {
		boolean validInput =false;
		for(int index = 0;index<ticketBookings.size();index++)
		{
			if(flightId==ticketBookings.get(index).getFlightId() &&
					ticketCount==ticketBookings.get(index).getBookedTicketCount()&&
					user.getUserId()==ticketBookings.get(index).getUserId()&&
					pnrNumber.equals(ticketBookings.get(index).getTicketNumber()))
			{
				ticketBookings.get(index).setTicketStatus("CANCEL");
				validInput = true;
				break;
			}
		}
		if(validInput)
		{
			for(int innerIndex = 0;innerIndex<flightRevenueList.size();innerIndex++)
			{
				if(flightId==flightRevenueList.get(innerIndex).getFlightId() &&
						ticketCount==flightRevenueList.get(innerIndex).getTicketCount()&&
						user.getUserId()==flightRevenueList.get(innerIndex).getUserId())
				{
					System.out.println((flightRevenueList.get(innerIndex).getRevenueAmount()) - (3*ticketCount )+" Amount Refund Sooon");
					flightRevenueList.get(innerIndex).setRevenueAmount(3*ticketCount);
					flightRevenueList.get(innerIndex).setTicketStatus("CANCEL");
					
					
				}
			}
			for(int index = 0;index<flightList.size();index++)
			{
				if(flightId==flightList.get(index).getFlightId())
				{
					
					flightList.get(index).setFlightSeatCount(flightList.get(index).getFlightSeatCount()+ticketCount);
				}
			}
		}
		else
		{
			System.out.println("Mis Matched Value");
		}
		
	}
	public List<TicketBooking> fetchBookedTicketList(User user) {
		List<TicketBooking> ticketBookingDetails = new ArrayList<TicketBooking>();
		for(int index = 0;index<ticketBookings.size();index++)
		{
			if(ticketBookings.get(index).getUserId()== user.getUserId())
			{
				TicketBooking ticketBooking = new TicketBooking();
				ticketBooking.setFlightId(ticketBookings.get(index).getFlightId());
				ticketBooking.setBookedTicketCount(ticketBookings.get(index).getBookedTicketCount());
				ticketBooking.setTicketFare(ticketBookings.get(index).getTicketFare());
				ticketBooking.setTicketNumber(ticketBookings.get(index).getTicketNumber());
				ticketBooking.setTicketStatus(ticketBookings.get(index).getTicketStatus());
				ticketBooking.setTravelDate(ticketBookings.get(index).getTravelDate());
				ticketBookingDetails.add(ticketBooking);
			}
		}
		return ticketBookingDetails;
		
	}

	
	
	
}
