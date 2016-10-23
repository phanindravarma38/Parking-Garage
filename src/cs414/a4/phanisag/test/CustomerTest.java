package cs414.a4.phanisag.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


import org.junit.Before;
import org.junit.Test;

import cs414.a4.phanisag.bo.AttendantBO;
import cs414.a4.phanisag.bo.CustomerBO;
import cs414.a4.phanisag.model.Admin;
import cs414.a4.phanisag.model.Attendant;
import cs414.a4.phanisag.model.Customer;
import cs414.a4.phanisag.model.ParkingSpace;
import cs414.a4.phanisag.model.Vehicle;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class CustomerTest {
	Admin admin;
	Attendant attendant;
	//setup()
	@Before
	public void setUp(){
		admin = new Admin();
		attendant = new Attendant();
		
	}
	//1. Customer can park car if there is vacancy.
	//2. Customer cannot park if lot is full.
	
	@Test
	public void customerCanParkIfLotVacant(){
		//Given
		//Lot is vacant.
		populateParkingLot(admin);
		
		//When
		//Customer parks car.
		Customer customer = new Customer();
		Vehicle vehicle = new Vehicle();
		customer.setParkedVehicle(vehicle);
		
		AttendantBO.issueTicket(customer, attendant);
		CustomerBO.parkCar(customer, admin);
		//Then
		//assert true carParked.
		assertTrue(customer.isCarParked());
	}
	@Test
	public void customerCannotParkCarsIfLotFull(){
		populateParkingLot(admin);
		for(ParkingSpace parkingSpace: admin.getParkingLot()){
			parkingSpace.setOccupied(true);
		}
		
		Customer customer = new Customer();
		Vehicle vehicle = new Vehicle();
		customer.setParkedVehicle(vehicle);
		
		AttendantBO.issueTicket(customer, attendant);
		CustomerBO.parkCar(customer, admin);
		//Then
		//assert true carParked.
		assertFalse(customer.isCarParked());
	}
	
	@Test
	public void customerCanExitIfThePaymentSucceeds(){
		
	}
	
	private void populateParkingLot(Admin admin){
		
		ParkingSpace parkingSpace1 = new ParkingSpace();
		ParkingSpace parkingSpace2 = new ParkingSpace();
		ParkingSpace parkingSpace3 = new ParkingSpace();
		ParkingSpace parkingSpace4 = new ParkingSpace();
		ParkingSpace parkingSpace5 = new ParkingSpace();
		
		
				
		Set<ParkingSpace> parkingLot = new HashSet<ParkingSpace>(Arrays.asList(parkingSpace1, parkingSpace2, parkingSpace3, parkingSpace4, parkingSpace5));
		admin.setParkingLot(parkingLot);
		
		
	}
}
