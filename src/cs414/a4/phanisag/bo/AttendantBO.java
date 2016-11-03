package cs414.a4.phanisag.bo;

import java.util.Date;
import java.util.Random;

import cs414.a4.phanisag.dao.AttendantDAO;
import cs414.a4.phanisag.gui.UserGUI;
import cs414.a4.phanisag.model.Attendant;
import cs414.a4.phanisag.model.Customer;

public class AttendantBO{

	

	// Returns ticket number
	public int issueTicket(Customer customer, Attendant attendant){	
		
		if(AttendantDAO.getEmptyParkingSpaces() == 0)
			return 0;
		else if(AttendantDAO.isVehiclePresent(customer.getVehicle().getPlateNumber()))
			return 0;
		int ticketNumber = generateTicketNumber();
		//int ticketNumber = 1111;
		
		customer.setTicketNumber(ticketNumber);
		customer.setStartTime(new Date());
		AttendantDAO.registerTicketForCustomer(customer, ticketNumber);
		return ticketNumber;
		
	}

	public boolean canMakeExit(int ticketNumber, String plateNumber, boolean isTicketLost){	
		boolean canMakeExit = false;
		if(isTicketLost){
			canMakeExit = AttendantDAO.lostTicketCheckout(plateNumber);
		}else{
			canMakeExit =  AttendantDAO.checkTicketNumberAndNumberPlate(ticketNumber, plateNumber);
		}
		return canMakeExit;
	}
	
	private int generateTicketNumber(){
		Random rand = new Random();
		int  n = rand.nextInt(1000000) + 1;
		while(n < 100000){
			n = rand.nextInt(1000000) + 1;
		}
		return n;
	}
	
	public void updateEndDate(String ticketNumber){
		AttendantDAO
		.updateEndDate(UserGUI.ticketNumberTextArea
				.getText());
	}
	

}
