package cs414.a4.phanisag.model;

import java.io.Serializable;



public class Vehicle implements Serializable {

	
	private String plateNumber;
	private int vehicleId;
	private ParkingSpace parkingSpace;
	

	public String getPlateNumber() {
		return plateNumber;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public void setParkingSpace(ParkingSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
	}
	

}
