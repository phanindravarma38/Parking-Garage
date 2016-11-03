package cs414.a4.phanisag.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cs414.a4.phanisag.model.Admin;
import cs414.a4.phanisag.model.ParkingSpace;
import cs414.a4.phanisag.utils.Constants;
import cs414.a4.phanisag.utils.DatabaseConnection;

public class AdminDAO {

	private static Connection connection;

	private static Admin admin;

	public static Admin getAdmin(String username, String password) {
		connection = DatabaseConnection.getConnection();
		Admin admin = new Admin();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM admin WHERE username = '"+username+"' AND password = '"+password+"'");
			if(rs.next()){
				admin.setAdminId(rs.getInt(1));
				admin.setUsername(username);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return admin;
	}
	

	public static List<Map<String, String>> getReport(long startTime,
			long endTime) {

		connection = DatabaseConnection.getConnection();
		List<Map<String, String>> report = new ArrayList<Map<String, String>>();
		try {
			Statement statement = connection.createStatement();
			Timestamp startTimeUi = new Timestamp(startTime);
			Timestamp endTimeUi = new Timestamp(endTime);

			ResultSet rs = statement
					.executeQuery("SELECT Plate_Number, FirstName, LastName, Start_Date, End_Date, Ticket_Number FROM customer cust, vehicle veh WHERE cust.VehicleId = veh.VehicleId AND cust.Start_Date >= '"
							+ startTimeUi
							+ "' AND (cust.End_Date <= '"
							+ endTimeUi + "' OR cust.End_Date IS NULL)");
			while (rs.next()) {
				Map<String, String> tuple = new HashMap<String, String>();
				String vehicleNumber = rs.getString(1);
				String customerName = rs.getString(2) + " " + rs.getString(3);
				Timestamp startTimeDb = rs.getTimestamp(4);
				Timestamp endTimeDb = rs.getTimestamp(5);
				String ticketNumber = rs.getInt(6) + "";

				tuple.put(Constants.VEHICLE_NUMBER, vehicleNumber);
				tuple.put(Constants.CUSTOMER_NAME, customerName);
				tuple.put(Constants.START_TIME,
						startTimeDb.toLocalDateTime().toString().split("T")[0]
								+ " "
								+ startTimeDb.toLocalDateTime().toString()
										.split("T")[1]);
				if (endTimeDb != null)
					tuple.put(
							Constants.END_TIME,
							endTimeDb.toLocalDateTime().toString().split("T")[0]
									+ " "
									+ endTimeDb.toLocalDateTime().toString()
											.split("T")[1]);
				tuple.put(Constants.TICKET_NUMBER, ticketNumber);

				report.add(tuple);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return report;
	}
	
	public static int getNumberOfAvailableSlots(){
		connection = DatabaseConnection.getConnection();
		int numberOfAvailableParkingSlots = 0;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT count(*) FROM parking_space WHERE isOccupied = false");
			if(rs.next()){
				numberOfAvailableParkingSlots = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return numberOfAvailableParkingSlots;
		
	}

}
