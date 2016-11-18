package cs414.a4.phanisag;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

import cs414.a4.phanisag.bo.AdminBO;
import cs414.a4.phanisag.bo.AttendantBO;

public class StartServer {
	public static void main(String[] args) {
		try {
			System.setSecurityManager(new RMISecurityManager());

			AdminBO adminBO = new AdminBO();
			AttendantBO attendantBO = new AttendantBO();
			
			Naming.rebind("rmi://localhost/admin", adminBO);
			Naming.rebind("rmi://localhost/attendant", attendantBO);

			System.out.println("Server is ready.");
		} catch (Exception e) {
			System.out.println("Server failed: " + e);
		}
	}
}
