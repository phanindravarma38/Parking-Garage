package cs414.a4.phanisag.model;

import java.util.Date;

public class Customer{

	private Vehicle vehicle;
	private Date paymentDate;
	private PaymentDetails paymentDetails;

	private int customerID;
	
	private ParkingSpace parkingSlot;
	private Date startTime;
	private Date endTime;
	private int ticketNumber;
	private boolean isCarParked;
	
	private String firstname;
	private String lastname;
	

	
	public boolean isCarParked() {
		return isCarParked;
	}

	public void setCarParked(boolean isCarParked) {
		this.isCarParked = isCarParked;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public int getCustomerID() {
		return customerID;
	}

	public ParkingSpace getParkingSlot() {
		return parkingSlot;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public void setParkingSlot(ParkingSpace parkingSlot) {
		this.parkingSlot = parkingSlot;
	}

	public void setStartTime(java.util.Date startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
}
