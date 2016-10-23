package cs414.a4.phanisag.model;

import java.util.HashSet;
import java.util.Set;

import cs414.a4.phanisag.utils.Roles;

public class Admin extends User{


	private int adminId;
	private static int i = 1;
	private Roles role;
	private Set<ParkingSpace> parkingLot;


	
	public Admin(){
		adminId = i;
		i++;
		role = Roles.ADMIN;
	}
	public Set<ParkingSpace> getParkingLot() {
		return parkingLot;
	}

	public void setParkingLot(Set<ParkingSpace> parkingLot) {
		this.parkingLot = parkingLot;
	}

	@Override
	public void setRole(Roles role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Roles getRole() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Set<ParkingSpace> getVacantParkingSpaces(){
		Set<ParkingSpace> vacantParkingSpaces = new HashSet<ParkingSpace>();
		for(ParkingSpace parkingSpace: parkingLot){
			if(!parkingSpace.isOccupied())
				vacantParkingSpaces.add(parkingSpace);
		}
		return vacantParkingSpaces;
	}
	
}
