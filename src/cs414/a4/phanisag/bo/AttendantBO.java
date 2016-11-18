package cs414.a4.phanisag.bo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.Random;

import cs414.a4.phanisag.bo.intrface.AttendantBOInterface;
import cs414.a4.phanisag.dao.AttendantDAO;
import cs414.a4.phanisag.model.Attendant;
import cs414.a4.phanisag.model.Customer;

public class AttendantBO extends UnicastRemoteObject implements AttendantBOInterface{

	public AttendantBO() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

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
		.updateEndDate(ticketNumber);
	}

	@Override
	public int getNumberOfHours(String ticketNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return AttendantDAO
				.getNumberOfHours(ticketNumber);
	}

	@Override
	public boolean checkCreditCardExists(String creditCard, String month,
			String year, String cvv, double amountToDeduct)
			throws RemoteException {
		// TODO Auto-generated method stub
		return AttendantDAO
				.checkCreditCardExists(creditCard, month,
						year, cvv, amountToDeduct);
	}

	@Override
	public void updateBalance(String creditCard, String month, String year,
			String cvv, double amountToDeduct) throws RemoteException {
		// TODO Auto-generated method stub
		AttendantDAO.updateBalance(creditCard, month,
				year, cvv, amountToDeduct);
	}
	

}
