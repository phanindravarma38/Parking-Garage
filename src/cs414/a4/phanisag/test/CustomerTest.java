package cs414.a4.phanisag.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import cs414.a4.phanisag.bo.AttendantBO;
import cs414.a4.phanisag.bo.CustomerBO;
import cs414.a4.phanisag.dao.AdminDAO;
import cs414.a4.phanisag.dao.AttendantDAO;
import cs414.a4.phanisag.model.Admin;
import cs414.a4.phanisag.model.Attendant;
import cs414.a4.phanisag.model.Customer;
import cs414.a4.phanisag.model.ParkingSpace;
import cs414.a4.phanisag.model.PaymentDetails;
import cs414.a4.phanisag.model.Vehicle;

public class CustomerTest {
	Admin admin;
	Attendant attendant;
	CustomerBO customerBo = new CustomerBO();
	AttendantBO attendantBo = new AttendantBO();
	//setup()
	@Before
	public void setUp(){
		
		admin = AdminDAO.getAdmin("test", "test");
		attendant = AttendantDAO.getAttendant("test", "test");
		
	}
	//1. Customer can park car if there is vacancy.
	//2. Customer cannot park if lot is full.
	
	@Test
	public void customerCanParkIfLotVacant(){
		//Given
		//Lot is vacant.
		if(admin.getVacantParkingSpaces() != null && admin.getVacantParkingSpaces().size() > 0){
			Customer customer = new Customer();
			Vehicle vehicle = new Vehicle();
			customer.setVehicle(vehicle);
			
			attendantBo.issueTicket(customer, attendant);
			customerBo.parkCar(customer, admin);
			//Then
			//assert true carParked.
			assertTrue(customer.isCarParked());
		}
		
	}
	@Test
	public void customerCannotParkCarsIfLotFull(){

		for(ParkingSpace parkingSpace: admin.getParkingLot()){
			parkingSpace.setOccupied(true);
		}
		
		Customer customer = new Customer();
		Vehicle vehicle = new Vehicle();
		customer.setVehicle(vehicle);
		
		
		
		attendantBo.issueTicket(customer, attendant);
		customerBo.parkCar(customer, admin);
		//Then
		//assert true carParked.
		assertFalse(customer.isCarParked());
	}
	
	@Test
	public void customerCanExitIfThePaymentSucceeds(){
		Customer customer = new Customer();
		customer.setCustomerID(111);
		customer.setVehicle(new Vehicle());
		
		attendantBo.issueTicket(customer, attendant);
		customerBo.parkCar(customer, admin);
		
		assertTrue(attendantBo.canMakeExit(customer));
		customer.setStartTime(new Date(1477265600009l));
		PaymentDetails paymentDetails = new PaymentDetails();
		paymentDetails.setAmount(10.00);
		
		
		customer.setPaymentDetails(paymentDetails);
		
		boolean isPaymentSuccessful = attendantBo.collectPayment(customer);
		assertTrue(isPaymentSuccessful);
		
	}

}
