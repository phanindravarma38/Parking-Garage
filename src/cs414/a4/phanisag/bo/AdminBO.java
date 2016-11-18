package cs414.a4.phanisag.bo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cs414.a4.phanisag.bo.intrface.AdminBOInterface;
import cs414.a4.phanisag.dao.AdminDAO;
import cs414.a4.phanisag.model.Admin;
import cs414.a4.phanisag.utils.Constants;
import cs414.a4.phanisag.utils.ParkingStatus;
import cs414.a4.phanisag.utils.ReportDuration;

public class AdminBO extends UnicastRemoteObject implements AdminBOInterface {

	public AdminBO() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private String customerName = "Customer Name";
	private String vehicleNo = "Vehicle Number";
	private String startTime = "Start Time";
	private String endTime = "End Time";
	private String ticketNumber = "Ticket Number";
	private String status = "Status";

	private ReportDuration reportDuration;

	public boolean doLogin(String username, String password) {

		Admin admin = AdminDAO.getAdmin(username, password);

		return admin != null;
	}

	public int getLotCapacity() {
		return AdminDAO.getNumberOfAvailableSlots();
	}

	// download report as pdf.
	public void generateReport(ReportDuration reportDuration) {
		List<Map<String, String>> report = null;

		long hourMilli = 60 * 60 * 1000;
		long dayMilli = 24 * hourMilli;
		long monthMilli = 30 * dayMilli;
		long weekMilli = 7 * dayMilli;
		long now = new Date().getTime();

		switch (reportDuration) {
		case HOURLY:
			report = AdminDAO.getReport(now - hourMilli, now);
			this.reportDuration = ReportDuration.HOURLY;
			break;
		case DAILY:
			report = AdminDAO.getReport(now - dayMilli, now);
			this.reportDuration = ReportDuration.DAILY;
			break;
		case MONTHLY:
			report = AdminDAO.getReport(now - monthMilli, now);
			this.reportDuration = ReportDuration.MONTHLY;
			break;
		case WEEKLY:
			report = AdminDAO.getReport(now - weekMilli, now);
			this.reportDuration = ReportDuration.WEEKLY;
			break;
		case BI_WEEKLY:
			report = AdminDAO.getReport(now - 2 * weekMilli, now);
			this.reportDuration = ReportDuration.BI_WEEKLY;
			break;
		default:
			break;

		}

		writeFile(report);

	}

	private void writeFile(List<Map<String, String>> report) {
		String content = "This is the content to write into file";

		File file = new File("src\\report.html");

		if (!file.exists()) {
			try {
				file.createNewFile();
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);

				// Headers
				initializeHtml(bw);
				doHeaders(bw);

				for (Map<String, String> tuple : report) {

					bw.write("<tr>");
					bw.write("<td>" + tuple.get(Constants.VEHICLE_NUMBER)
							+ "</td>");
					bw.write("<td>" + tuple.get(Constants.CUSTOMER_NAME)
							+ "</td>");
					bw.write("<td>" + tuple.get(Constants.START_TIME) + "</td>");
					bw.write("<td>"
							+ ((tuple.get(Constants.END_TIME) == null) ? "N/A"
									: tuple.get(Constants.END_TIME)) + "</td>");
					bw.write("<td>" + tuple.get(Constants.TICKET_NUMBER)
							+ "</td>");
					bw.write("<td>"
							+ (tuple.get(Constants.END_TIME) == null ? ParkingStatus.ACTIVE
									: ParkingStatus.CLOSED) + "</td>");
					bw.write("</tr>");
				}

				bw.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("Done");
	}

	private void initializeHtml(BufferedWriter bw) throws IOException {
		bw.write("<html><head><title>" + reportDuration
				+ " Report</title><head><body>" + "<h1>" + reportDuration
				+ " Report</h1><table>");
	}

	private void doHeaders(BufferedWriter bw) throws IOException {
		bw.write("<tr>" + "<th>" + vehicleNo + "</th>" + "<th>" + customerName
				+ "</th>" + "<th>" + startTime + "</th>" + "<th>" + endTime
				+ "</th>" + "<th>" + ticketNumber + "</th>" + "<th>" + status
				+ "</th>" + "</tr>");
	}

	private void endHtml(BufferedWriter bw) throws IOException {
		bw.write("</table></body></html>");
	}

	@Override
	public int getNumberOfAvailableSlots() throws RemoteException {
		// TODO Auto-generated method stub
		return AdminDAO
				.getNumberOfAvailableSlots();
	}
}
