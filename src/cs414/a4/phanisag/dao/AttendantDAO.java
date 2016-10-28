package cs414.a4.phanisag.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import cs414.a4.phanisag.model.Attendant;
import cs414.a4.phanisag.model.Customer;
import cs414.a4.phanisag.model.ParkingSpace;
import cs414.a4.phanisag.model.Vehicle;
import cs414.a4.phanisag.utils.DatabaseConnection;

public class AttendantDAO {

	private static Connection connection;

	public static Attendant getAttendant(String username, String password) {
		return username.equals("test") && password.equals("test") ? new Attendant()
				: null;
	}

	public static int getCustomerIdForTicketNumber(int ticketNumber) {
		Customer customer = new Customer();
		customer.setCustomerID(111);
		return customer.getCustomerID();
	}

	public static String getPlateNumberForCustomerId(int customerId) {
		return null;
	}

	public static int getTicketNumberForCustomerId(int customerId) {
		return 0;
	}

	public static int registerTicketForCustomer(Customer customer,
			int ticketNumber) {

		connection = DatabaseConnection.getConnection();
		int carResult = 0;
		try {

			Statement statement = connection.createStatement();
			Vehicle vehicle = customer.getVehicle();

			ParkingSpace parkingSpace = new ParkingSpace();
			parkingSpace.setParkingLotId(getFreeParkingSpaceId());
			parkingSpace.setOccupied(false);
			vehicle.setParkingSpace(parkingSpace);

			int vehicleId = parkVehicle(vehicle);

			if (vehicleId > 0) {
				carResult = statement
						.executeUpdate("INSERT INTO customer (firstname, lastname, start_date, ticket_Number, VehicleID) VALUES('"
								+ customer.getFirstname()
								+ "','"
								+ customer.getLastname()
								+ "', '"
								+ new Timestamp(customer.getStartTime()
										.getTime())
								+ "',"
								+ ticketNumber
								+ ","
								+ vehicleId + ");");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carResult;
	}

	public static int getEmptyParkingSpaces() {
		connection = DatabaseConnection.getConnection();
		int availableParkingSpaces = 0;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery("SELECT COUNT(*) FROM parking_space WHERE isOccupied = false");
			if (rs.next()) {
				availableParkingSpaces = Integer.parseInt(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return availableParkingSpaces;
	}

	public static int getFreeParkingSpaceId() {
		connection = DatabaseConnection.getConnection();
		int lotId = 0;

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery("SELECT lotId from parking_space WHERE isOccupied = false");
			if (rs.next()) {
				lotId = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lotId;
	}

	public static int parkVehicle(Vehicle vehicle) {
		connection = DatabaseConnection.getConnection();
		int vehicleId = 0;

		try {
			Statement statement = connection.createStatement();
			Statement statement2 = connection.createStatement();

			vehicleId = statement.executeUpdate(
					"INSERT INTO vehicle (plate_number,parking_space) VALUES('"
							+ vehicle.getPlateNumber() + "',"
							+ vehicle.getParkingSpace().getParkingLotId()
							+ ");", Statement.RETURN_GENERATED_KEYS);
			statement2
					.executeUpdate("UPDATE parking_space SET isOccupied = true WHERE lotId = "
							+ vehicle.getParkingSpace().getParkingLotId() + ";");
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				vehicleId = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vehicleId;
	}

	public static boolean checkTicketNumberAndNumberPlate(int ticketNumber,
			String plateNumber) {

		connection = DatabaseConnection.getConnection();
		String dbPlateNumber = null;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery("SELECT plate_number as plate FROM vehicle veh, customer cus WHERE cus.ticket_number = "
							+ ticketNumber
							+ " AND veh.vehicleId = cus.vehicleId");
			if(rs.next()){
				dbPlateNumber = rs.getString("plate");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return plateNumber.equals(dbPlateNumber);
	}

	public static void updateEndDate(String ticketNumber) {
		
		
		connection = DatabaseConnection.getConnection();
		
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		
		
		try {
			Statement statement = connection.createStatement();
			int rows = statement.executeUpdate("UPDATE customer SET End_Date = '" + currentTimestamp + "' WHERE Ticket_Number = " + ticketNumber  );
			
			
			System.out.println(rows);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	public static int getNumberOfHours(String ticketNumber) {
		
		
		connection = DatabaseConnection.getConnection();
		
		
		java.sql.Timestamp startTimeStamp = null;
		int numberOfHours =0;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * from customer WHERE Ticket_Number = '" + ticketNumber + "'");
			if(rs.next()){
				startTimeStamp = rs.getTimestamp("Start_Date");
			}
			long diff = new Date().getTime() - startTimeStamp.getTime();
		    double diffMinutes = diff / (60 * 1000) % 60;
		    
		    numberOfHours = (int) Math.ceil(diffMinutes/60.0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return numberOfHours;
		
		
		
	}

	public static boolean checkCreditCardExists(String creditCard,
			String month, String year, String cvv, double amountToDeduct) {
		
		
		
		connection = DatabaseConnection.getConnection();
		boolean isCreditCardExists = false;
		
		
		java.sql.Timestamp startTimeStamp = null;
		java.sql.Timestamp endTimeStamp = null;
		int numberOfHours =0;
		
		
		try {
			Statement statement = connection.createStatement();
			
			
			ResultSet rs = statement.executeQuery("SELECT * from creditCard WHERE cardNumber = '" + creditCard + "' AND " + "expMonth = '" + month + "' AND "+ "expYear = '" + year + "' AND "+ "CVV = '" + cvv + "'");
			
			if(rs.next()){
				
				String balance = rs.getString("balance");
				
				
				if(Double.parseDouble(balance)>amountToDeduct){
					isCreditCardExists = true;
				}else{
					
					
					JOptionPane.showMessageDialog(null, "Insufficient Funds." ,"Credit Card Error",JOptionPane.ERROR_MESSAGE);
					
				}
				
				
			}else{
				
				JOptionPane.showMessageDialog(null, "Not a valid Credit Card. Credit Card not in database" ,"Credit Card Error",JOptionPane.ERROR_MESSAGE);
			}
			
			
			
		    
		    
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return isCreditCardExists;
		
		
		
	
	}

	public static void updateBalance(String creditCard, String month,
			String year, String cvv, double amountToDeduct) {
		
		

		
		
		connection = DatabaseConnection.getConnection();
		boolean isCreditCardExists = false;
		
		
		java.sql.Timestamp startTimeStamp = null;
		java.sql.Timestamp endTimeStamp = null;
		int numberOfHours =0;
		
		
		try {
			Statement statement = connection.createStatement();
			
			
			ResultSet rs = statement.executeQuery("SELECT * from creditCard WHERE cardNumber = '" + creditCard + "' AND " + "expMonth = '" + month + "' AND "+ "expYear = '" + year + "' AND "+ "CVV = '" + cvv + "'");
			
			if(rs.next()){
				
				String balance = rs.getString("balance");
				
				double balanceUpdate = Double.parseDouble(balance) - amountToDeduct;
				
				int rows = statement.executeUpdate("UPDATE creditCard SET balance = '" + String.valueOf(balanceUpdate) + "'" + "WHERE cardNumber = '" + creditCard + "' AND " + "expMonth = '" + month + "' AND "+ "expYear = '" + year + "' AND "+ "CVV = '" + cvv + "'");
				
				
			}
			
			
		    
		    
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	
	
	}
}
