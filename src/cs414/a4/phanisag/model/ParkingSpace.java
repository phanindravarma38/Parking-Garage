package cs414.a4.phanisag.model;

public class ParkingSpace {

	private int parkingLotId;
	private boolean isOccupied;
	private static int i = 1;
	
	public ParkingSpace(){
		this.parkingLotId = i;
		i++;
		isOccupied = false;
	}
	
	public int getParkingLotId() {
		return parkingLotId;
	}
	public boolean isOccupied() {
		return isOccupied;
	}
	public void setParkingLotId(int parkingLotId) {
		this.parkingLotId = parkingLotId;
	}
	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	
	
}
