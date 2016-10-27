package cs414.a4.phanisag.model;

import java.util.HashSet;
import java.util.Set;

import cs414.a4.phanisag.utils.Roles;

public class Admin{


	private int adminId;
	private static int i = 1;
	private Set<ParkingSpace> parkingLot;
	
	public Admin(){
		adminId = i;
		i++;
	}
	public Set<ParkingSpace> getParkingLot() {
		return parkingLot;
	}

	public void setParkingLot(Set<ParkingSpace> parkingLot) {
		this.parkingLot = parkingLot;
	}
	
	public Set<ParkingSpace> getVacantParkingSpaces(){
		Set<ParkingSpace> vacantParkingSpaces = new HashSet<ParkingSpace>();
		for(ParkingSpace parkingSpace: parkingLot){
			if(!parkingSpace.isOccupied())
				vacantParkingSpaces.add(parkingSpace);
		}
		return vacantParkingSpaces;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	
	
}
