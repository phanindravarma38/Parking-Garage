package cs414.a4.phanisag.bo.intrface;

import java.rmi.Remote;
import java.rmi.RemoteException;

import cs414.a4.phanisag.model.Attendant;
import cs414.a4.phanisag.model.Customer;

public interface AttendantBOInterface extends Remote{
	public int issueTicket(Customer customer, Attendant attendant) throws RemoteException;
	public boolean canMakeExit(int ticketNumber, String plateNumber, boolean isTicketLost) throws RemoteException;
	public void updateEndDate(String ticketNumber)throws RemoteException;
	public int getNumberOfHours(String ticketNumber) throws RemoteException;
	public boolean checkCreditCardExists(String creditCard, String month,
			String year, String cvv, double amountToDeduct)
			throws RemoteException;
	public void updateBalance(String creditCard, String month,
			String year, String cvv, double amountToDeduct) throws RemoteException;
}
