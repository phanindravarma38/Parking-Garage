package cs414.a4.phanisag.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import cs414.a4.phanisag.model.Admin;
import cs414.a4.phanisag.model.ParkingSpace;
import cs414.a4.phanisag.utils.DatabaseConnection;

public class AdminDAO {

	private static Connection connection;
	
	private static Admin admin;
	static {
		admin = new Admin();
		ParkingSpace parkingSpace1 = new ParkingSpace();
		ParkingSpace parkingSpace2 = new ParkingSpace();
		ParkingSpace parkingSpace3 = new ParkingSpace();
		ParkingSpace parkingSpace4 = new ParkingSpace();
		ParkingSpace parkingSpace5 = new ParkingSpace();
		
		
				
		Set<ParkingSpace> parkingLot = new HashSet<ParkingSpace>(Arrays.asList(parkingSpace1, parkingSpace2, parkingSpace3, parkingSpace4, parkingSpace5));
		admin.setParkingLot(parkingLot);
	}
	
	public static Admin getAdmin(String username, String password)
	{
		return (username.equals("test") && password.equals("test"))? admin : null ;
	}

}
