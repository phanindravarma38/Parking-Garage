package cs414.a4.phanisag.dao;

import cs414.a4.phanisag.model.Attendant;
import cs414.a4.phanisag.model.Customer;

public class AttendantDAO {

	public static Attendant getAttendant(String username, String password){
		return username.equals("test") && password.equals("test") ? new Attendant() : null;
	}
	
	public static int getCustomerIdForTicketNumber(int ticketNumber){
		Customer customer = new Customer();
		customer.setCustomerID(111);
		return customer.getCustomerID();
	}
	
	public static String getPlateNumberForCustomerId(int customerId){
		return null;
	}
	
	public static int getTicketNumberForCustomerId(int customerId){
		return 0;
	}
}
