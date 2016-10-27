package cs414.a4.phanisag.bo;

import java.util.Date;
import java.util.Random;

import cs414.a4.phanisag.dao.AttendantDAO;
import cs414.a4.phanisag.model.Attendant;
import cs414.a4.phanisag.model.Customer;

public class AttendantBO{

	

	// Returns ticket number
	public int issueTicket(Customer customer, Attendant attendant){	
		
		if(AttendantDAO.getEmptyParkingSpaces() == 0)
			return 0;
		
		int ticketNumber = generateTicketNumber();
		//int ticketNumber = 1111;
		
		customer.setTicketNumber(ticketNumber);
		customer.setStartTime(new Date());
		AttendantDAO.registerTicketForCustomer(customer, ticketNumber);
		return ticketNumber;
		
	}

	public boolean canMakeExit(int ticketNumber, String plateNumber){	
		
		return AttendantDAO.checkTicketNumberAndNumberPlate(ticketNumber, plateNumber);
	}
	
	
	public boolean collectPayment(Customer customer){
		//calculating bill.
		double violationAmount = 0.00;
		if(AdminBO.notifyParkingViolation(customer)){
			violationAmount = 50.00;
		}
		
		long difference = new java.util.Date().getTime() - customer.getStartTime().getTime();		
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

		int  n = rand.nextInt(1000000) + 1;
		
		return n;
	}
}
