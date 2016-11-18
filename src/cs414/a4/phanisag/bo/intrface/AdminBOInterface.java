package cs414.a4.phanisag.bo.intrface;

import java.rmi.Remote;
import java.rmi.RemoteException;

import cs414.a4.phanisag.utils.ReportDuration;

public interface AdminBOInterface extends Remote{
	public boolean doLogin(String username, String password) throws RemoteException;
	public int getLotCapacity() throws RemoteException;
	public void generateReport(ReportDuration reportDuration) throws RemoteException;
	public int getNumberOfAvailableSlots() throws RemoteException;
}
