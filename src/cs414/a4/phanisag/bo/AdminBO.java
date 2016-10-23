package cs414.a4.phanisag.bo;

import cs414.a4.phanisag.model.Customer;
import cs414.a4.phanisag.model.User;
import cs414.a4.phanisag.utils.AccountStatus;
import cs414.a4.phanisag.utils.ReportDuration;

public class AdminBO{

	//download report as pdf.
	public void generateReport(String reportId, ReportDuration reportDuration){
		
	}
	//return true if violated.(after hours parking)/(more than one vehicle for customer)/
	public boolean notifyParkingViolation(Customer customer){
		return false;
	}
	//return true if due.
	public String notifyPaymentDue(Customer customer){
		return null;
	}
	//Active if parked without above two. 
	//Inactive if not parked
	//Pending if either of both of above.
	// or status. More than two parking violations. 
	public AccountStatus accountStatus(Customer customer){
		return AccountStatus.INACTIVE;
	}

}
