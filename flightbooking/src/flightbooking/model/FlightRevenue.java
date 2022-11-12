package flightbooking.model;

public class FlightRevenue {
	private Integer flightId;
	private Integer userId;
	private Integer revenueAmount;
	private String  ticketStatus;
	private String travelDate;
	private Integer ticketCount;
	private String ticketNumber;
	
	
	public String getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}
	public Integer getTicketCount() {
		return ticketCount;
	}
	public void setTicketCount(Integer ticketCount) {
		this.ticketCount = ticketCount;
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
	public Integer getRevenueAmount() {
		return revenueAmount;
	}
	public void setRevenueAmount(Integer revenueAmount) {
		this.revenueAmount = revenueAmount;
	}
	public String getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	


	

}
