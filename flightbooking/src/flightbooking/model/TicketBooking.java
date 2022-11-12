package flightbooking.model;

public class TicketBooking {
	private Integer flightId;
	private Integer userId;
	private Integer bookedTicketCount;
	private Integer ticketFare;
	private String  ticketStatus;
	private String ticketNumber;
	private String travelDate;
	
	
	public String getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public Integer getFlightId() {
		return flightId;
	}
	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getBookedTicketCount() {
		return bookedTicketCount;
	}
	public void setBookedTicketCount(Integer bookedTicketCount) {
		this.bookedTicketCount = bookedTicketCount;
	}
	public Integer getTicketFare() {
		return ticketFare;
	}
	public void setTicketFare(Integer ticketFare) {
		this.ticketFare = ticketFare;
	}
	public String getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	

}
