package cs414.a4.phanisag.model;

import java.util.Date;

import cs414.a4.phanisag.utils.Roles;

public class Customer extends User {

	private Vehicle parkedVehicle;
	private Roles role;
	private Date paymentDate;

	private int customerID;
	
	private ParkingSpace parkingSlot;
	private Date startTime;
	private Date endTime;
	private int ticketNumber;
	private boolean isCarParked;
	
	private static int i = 1;
	public Customer(){
		this.customerID = i;
		i++;
		role = Roles.CUSTOMER;
	}
	
	@Override
	public void setRole(Roles role) {
		this.role = role;
	}

	@Override
	public Roles getRole() {
		return role;
	}
	

	public boolean isCarParked() {
		return isCarParked;
	}

	public void setCarParked(boolean isCarParked) {
		this.isCarParked = isCarParked;
	}

	public Vehicle getParkedVehicle() {
		return parkedVehicle;
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

	public void setParkedVehicle(Vehicle parkedVehicle) {
		this.parkedVehicle = parkedVehicle;
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

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	
	
}
