package cs414.a4.phanisag.bo;

import java.util.Date;
import java.util.Random;

import cs414.a4.phanisag.dao.AttendantDAO;
import cs414.a4.phanisag.model.Attendant;
import cs414.a4.phanisag.model.Customer;
import cs414.a4.phanisag.model.Vehicle;

public class AttendantBO{

	

	// Returns ticket number
	public int issueTicket(Customer customer, Attendant attendant){		
		int ticketNumber = generateTicketNumber();
		//int ticketNumber = 1111;
		
		customer.setTicketNumber(ticketNumber);
		
		return ticketNumber;
		
	}

	public boolean canMakeExit(Customer customer){	
		String plateNumber = customer.getVehicle().getPlateNumber();
		int ticketNumber = customer.getTicketNumber();
		
		String plateNumberDb = AttendantDAO.getPlateNumberForCustomerId(customer.getCustomerID());
		int ticketNumberDb = AttendantDAO.getTicketNumberForCustomerId(customer.getCustomerID());
		return  plateNumber.equals(plateNumberDb) && (ticketNumberDb == ticketNumber);
	}
	
	
	public boolean collectPayment(Customer customer){
		//calculating bill.
		double violationAmount = 0.00;
		if(AdminBO.notifyParkingViolation(customer)){
			violationAmount = 50.00;
		}
		
		long difference = new Date().getTime() - customer.getStartTime().getTime();		
		double bill = 0.00;
		int hours = (int)(difference)/(1000*60*60);

		if(hours <= 3){
			bill = 10.00 + violationAmount;
		}else if(hours > 3 && hours <=8){
			bill = 15.00 + violationAmount;
		}else{
			bill = 18.00 + violationAmount;
		}

		if(customer.getPaymentDetails().getAmount().equals(bill)){
			return true;
		}
		
		return false;
	}
	
	private int generateTicketNumber(){
		Random rand = new Random();

		int  n = rand.nextInt(10000) + 1;
		
		return n;
	}
}
