package Operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Validation {
	private static String url="jdbc:mysql://cstserver.uic.edu.hk";
	private static String username="j430003023";
	private static String password="123456";
	private static String Driver="com.mysql.jdbc.Driver";
	
	// Input the name of a company, check if it exist in the database...
	// If it exist, return the id of company...
	// If there is something wrong in class, return -1...
	// If there are other wrong, return -2...
	// If it did not exist, return -4...
	public static int companyCheck(String name){
		try{
			Class.forName(Driver);
			Connection connection = DriverManager.getConnection(url, username, password);
			String search="SELECT `id` FROM `j430003023`.`company` WHERE `name` LIKE '" + name + "'";
			Statement state = connection.createStatement();
			ResultSet result = state.executeQuery(search);
			if(result.next() == false) {
				state.close();
				connection.close();
				return -4;
			}
			int reslutID = result.getInt("id");
			state.close();
			connection.close();
			return reslutID;
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			return -1;
		}
		catch(SQLException e) {
			e.printStackTrace();
			e.getMessage();
			return -2;
		
		}
	}
	
	// Input the name of a school, check if it exist in the database...
	// If it exist, return the id of school...
	// If it does't exist, return -1...
	// If there are other wrong, return -2...
	public static int schoolCheck(String name){
		try{
			Class.forName(Driver);
			Connection connection = DriverManager.getConnection(url, username, password);
			String search="SELECT `id` FROM `j430003023`.`school` WHERE `name` LIKE '" + name + "'";
			Statement state = connection.createStatement();
			ResultSet result = state.executeQuery(search);
			if(result.next() == false) {
				state.close();
				connection.close();
				return -4;
			}
			int reslutID = result.getInt("id");
			state.close();
			connection.close();
			return reslutID;
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			return -1;
		}
		catch(SQLException e) {
			e.printStackTrace();
			e.getMessage();
			return -2;
		
		}
	}
	
	// Input the name of a school, check if it exist in the database...
	// If it exist, return  1...
	// If it does't exist, return -1...
	// If there are other wrong, return -2...
	public static int alumniCheck(String studentID){
		try{
			Class.forName(Driver);
			Connection connection = DriverManager.getConnection(url, username, password);
			String search="SELECT `id` FROM `j430003023`.`alumni` WHERE `studentID` LIKE '" + studentID + "'";
			Statement state = connection.createStatement();
			ResultSet result = state.executeQuery(search);
			if(result.next() == false) {
				state.close();
				connection.close();
				return -4;
			}
			
			return 1;
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			return -1;
		}
		catch(SQLException e) {
			e.printStackTrace();
			e.getMessage();
			return -2;
		
		}
	}
	
	// Input the graduatino year(-1 or 2008~2016), check if it is valid...
	// If graduation year is -1, it means select all years graduation, return 0....
	// If graduation year is between 2008 and 2016, it is valid, return 1...
	// If graduation year is invalid, return -1...
	public static int yearCheck(int year){
		if(year == -1) return 0;
		if(year >= 2008 && year <= 2016) return 1;
		return -1;
	}
}
