package cs414.a4.phanisag.model;

import cs414.a4.phanisag.utils.Roles;


public class Vehicle {

	
	private String plateNumber;
	private String make;
	private String model;
	private String year;
	private String state;
	private int vehicleId;
	
	private ParkingSpace parkingSpace;
	
	private static int i = 240;
	public Vehicle(){
		this.vehicleId = i;
		i++;
		
	}
	

	public String getPlateNumber() {
		return plateNumber;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getYear() {
		return year;
	}

	public String getState() {
		return state;
	}

	public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setParkingSpace(ParkingSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	
}
