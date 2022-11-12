package flightbooking.model;

public class Flight {
	
	private Integer flightId;
	private String flightName;
	private String flightStartDate;
	private String flightStartTime;
	private String flightStartsFrom;
	private String flightReachTo;
	private Integer flightSeatCount;
	private Integer flighTicketFare;
	
	
	public Integer getFlightId() {
		return flightId;
	}
	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	
	public String getFlightStartDate() {
		return flightStartDate;
	}
	public void setFlightStartDate(String flightStartDate) {
		this.flightStartDate = flightStartDate;
	}
	public String getFlightStartTime() {
		return flightStartTime;
	}
	public void setFlightStartTime(String flightStartTime) {
		this.flightStartTime = flightStartTime;
	}
	public String getFlightStartsFrom() {
		return flightStartsFrom;
	}
	public void setFlightStartsFrom(String flightStartsFrom) {
		this.flightStartsFrom = flightStartsFrom;
	}
	public String getFlightReachTo() {
		return flightReachTo;
	}
	public void setFlightReachTo(String flightReachTo) {
		this.flightReachTo = flightReachTo;
	}
	public Integer getFlightSeatCount() {
		return flightSeatCount;
	}
	public void setFlightSeatCount(Integer flightSeatCount) {
		this.flightSeatCount = flightSeatCount;
	}
	public Integer getFlighTicketFare() {
		return flighTicketFare;
	}
	public void setFlighTicketFare(Integer flighTicketFare) {
		this.flighTicketFare = flighTicketFare;
	}
	
	

}
