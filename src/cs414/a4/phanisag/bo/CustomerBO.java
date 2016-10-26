package cs414.a4.phanisag.bo;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import cs414.a4.phanisag.model.Admin;
import cs414.a4.phanisag.model.Attendant;
import cs414.a4.phanisag.model.Customer;
import cs414.a4.phanisag.model.ParkingSpace;
import cs414.a4.phanisag.model.PaymentDetails;

public class CustomerBO {

	private static Set<ParkingSpace> availableParkingSpaces;

	
	//park the car.
	public boolean parkCar(Customer customer, Admin admin){
		
		if(AdminBO.notifyParkingViolation(customer)){
			return false;
		}
		
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
		
	
}
