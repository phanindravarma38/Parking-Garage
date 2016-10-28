package cs414.a4.phanisag.bo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cs414.a4.phanisag.dao.AdminDAO;
import cs414.a4.phanisag.utils.ReportDuration;

public class AdminBO{
	
	//download report as pdf.
	public void generateReport(ReportDuration reportDuration){
		List<Map<String, String>> report = null;
		
		long hourMilli = 60*60*1000;
		long dayMilli = 24*hourMilli;
		long monthMilli = 30*dayMilli;
		long weekMilli = 7*dayMilli;
		long now = new Date().getTime();
		
		switch(reportDuration){
		case HOURLY: report = AdminDAO.getReport(now - hourMilli, now);
						break;
		case DAILY: report = AdminDAO.getReport(now - dayMilli, now);
						break;
		case MONTHLY: report = AdminDAO.getReport(now - monthMilli, now);
						break;
		case WEEKLY: report = AdminDAO.getReport(now - weekMilli, now);
						break;
		case BI_WEEKLY: report = AdminDAO.getReport(now - 2 * weekMilli, now);
						break;
		default : break;
		
		}
		
		writeFile(report);
		
		
	}

	private void writeFile(List<Map<String, String>> report){
		String content = "This is the content to write into file";

		File file = new File("./");
		
		if (!file.exists()) {
			try {
				System.out.println(file.getAbsolutePath());
				file.createNewFile();
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(content);
				bw.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		System.out.println("Done");
	}



}
