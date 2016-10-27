package cs414.a4.phanisag.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

	public static boolean registerTicketForCustomer(Customer customer,
			int ticketNumber) {

		connection = DatabaseConnection.getConnection();

		try {
			
			Statement statement2 = connection.createStatement();
			Vehicle vehicle = customer.getVehicle();
			
			ParkingSpace parkingSpace = new ParkingSpace();
			parkingSpace.setParkingLotId(getFreeParkingSpaceId());
			parkingSpace.setOccupied(false);
			vehicle.setParkingSpace(parkingSpace);
			
			int result = registerVehicle(vehicle);
			
			
			statement2.executeUpdate("INSERT INTO customer VALUES("
					+ customer.getCustomerID() + ", " + customer.getFirstname()
					+ "," + customer.getLastname() + ", "
					+ customer.getStartTime() + ", " + customer.getEndTime()
					+ ", " + ticketNumber + "," + vehicle.getVehicleId() + ")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
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
	
	public static int getFreeParkingSpaceId(){
		connection = DatabaseConnection.getConnection();
		int lotId = 0;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT lotId from parking_space WHERE isOccupied = false");
			if(rs.next()){
				lotId = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lotId;
	}
	
	public static int registerVehicle(Vehicle vehicle){
		connection = DatabaseConnection.getConnection();
		int result = 0;
		
		try {
			Statement statement = connection.createStatement();
			result = statement.executeUpdate("INSERT INTO vehicle VALUES("
					+ vehicle.getVehicleId() + ", " + vehicle.getPlateNumber()
					+ ", " + vehicle.getMake() + "," + vehicle.getModel()
					+ ", " + vehicle.getState() + "," + vehicle.getYear() + ","
					+ vehicle.getParkingSpace().getParkingLotId()+ ")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
