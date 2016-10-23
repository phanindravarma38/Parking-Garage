package cs414.a4.phanisag.bo;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import cs414.a4.phanisag.model.Admin;
import cs414.a4.phanisag.model.Customer;
import cs414.a4.phanisag.model.ParkingSpace;
import cs414.a4.phanisag.model.PaymentDetails;

public class CustomerBO {

	private static Set<ParkingSpace> availableParkingSpaces;
	static {
		ParkingSpace parkingSpace1 = new ParkingSpace();
		ParkingSpace parkingSpace2 = new ParkingSpace();
		ParkingSpace parkingSpace3 = new ParkingSpace();
		ParkingSpace parkingSpace4 = new ParkingSpace();
		
		availableParkingSpaces = new HashSet<>(Arrays.asList(parkingSpace1, parkingSpace2, parkingSpace3, parkingSpace4));
		
				
	}
	
	//park the car.
	public static boolean parkCar(Customer customer, Admin admin){
		//Randomly get vacant space
		availableParkingSpaces = admin.getVacantParkingSpaces();
		Iterator<ParkingSpace> parkingIterator = availableParkingSpaces.iterator();
		
		while(parkingIterator.hasNext()){
			ParkingSpace availableParkingSpace= parkingIterator.next();
			if(!availableParkingSpace.isOccupied()){
				customer.setParkingSlot(availableParkingSpace);
				customer.setStartTime(new Date());
				customer.setCarParked(true);
			}
		}
		return customer.isCarParked();
	}
	
	public boolean makeExit(){
		
		return false;
	}
	
	public boolean makePayment(PaymentDetails paymentDetails){
		return false;
	}
	
	
	
	
}
