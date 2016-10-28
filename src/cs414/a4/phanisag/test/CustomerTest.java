package cs414.a4.phanisag.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

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
			Customer customer = new Customer();
			Vehicle vehicle = new Vehicle();
			customer.setVehicle(vehicle);
			
			attendantBo.issueTicket(customer, attendant);
			//Then
			//assert true carParked.
			assertTrue(customer.isCarParked());
		
	}
	@Test
	public void customerCannotParkCarsIfLotFull(){

		
		Customer customer = new Customer();
		Vehicle vehicle = new Vehicle();
		customer.setVehicle(vehicle);
		
		
		
		attendantBo.issueTicket(customer, attendant);
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
		
		customer.setStartTime(new Date(1477265600009l));
		PaymentDetails paymentDetails = new PaymentDetails();
		paymentDetails.setAmount(10.00);
		
		
		customer.setPaymentDetails(paymentDetails);
		
		
	}

}
