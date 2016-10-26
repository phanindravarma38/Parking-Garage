package cs414.a4.phanisag.bo;

import java.util.Calendar;
import java.util.Date;

import cs414.a4.phanisag.model.Customer;
import cs414.a4.phanisag.model.User;
import cs414.a4.phanisag.utils.AccountStatus;
import cs414.a4.phanisag.utils.ReportDuration;

public class AdminBO{

	
	
	//download report as pdf.
	public void generateReport(String reportId, ReportDuration reportDuration){
		
		//vehicle, no. of hours, customerName, in-time, exit-time
		
	}
	//return true if violated.(after hours parking)/(more than one vehicle for customer)/
	public static boolean notifyParkingViolation(Customer customer){
		
		Calendar presentTime = Calendar.getInstance();
		presentTime.setTime(new Date());
		
		if(presentTime.get(Calendar.HOUR_OF_DAY) < 8 || presentTime.get(Calendar.HOUR_OF_DAY) > 22){
			return true;
		}
		
		return false;
	}



}
