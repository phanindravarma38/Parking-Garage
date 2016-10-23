package cs414.a4.phanisag.bo;

import cs414.a4.phanisag.model.Attendant;
import cs414.a4.phanisag.model.Customer;

public class AttendantBO{


	// Returns ticket number
	public static String issueTicket(Customer customer, Attendant attendant){
		AttendantBO attendantBo = new AttendantBO();
		int ticketNumber = attendantBo.generateTicketNumber();
		
		customer.setTicketNumber(ticketNumber);
		
		return ticketNumber + "";
		
	}

	//True if payment successful.
	public boolean collectPayment(Customer customer){
		
		return false;
	}
	
	private int generateTicketNumber(){
		return (int)Math.random()*1000000;
	}
}
