package Operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Table.Organization;
import Table.Company;
import Table.School;
import Table.Alumni;

public class Search {
	
	private static String url="jdbc:mysql://cstserver.uic.edu.hk";
	private static String username="j430003023";
	private static String password="123456";
	private static String Driver="com.mysql.jdbc.Driver";
	
	
	// Input the student ID, return an object of student...
	public static Alumni alumni(String studentID){
		try{
			Class.forName(Driver);
			Connection connection = DriverManager.getConnection(url, username, password);
			String search="SELECT * FROM `j430003023`.`alumni` WHERE `studentID` LIKE '" + studentID + "'";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(search);
			if( !result.next() ) {
				statement.close();
				connection.close();
				return null;
			}
			String name = result.getString("name");
			int sex = result.getInt("sex");
			String major = result.getString("major");
			int graYear = result.getInt("graYear");
			int state = result.getInt("state");
			int id = result.getInt("id");
			Alumni alumni = new Alumni(studentID,name,sex,major,state,graYear,id);
		
			
			statement.close();
			connection.close();
			return alumni;
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			return null;
		}
		catch(SQLException e) {
			e.printStackTrace();
			e.getMessage();
			return null;
		
		}
	}
	// Input the student ID, return the state of studentID...
	// If the state is company(2), return 2...
	// If the state is school(1), return 1...
	// If the state is at home(0), return 0...
	// If there are something worng in class, return -1...
	// If there are some other wrong, return -2...
	// If can not find alumni information in database, return -4...
	public static int alumniState(String studentID){
		try{
			Class.forName(Driver);
			Connection connection = DriverManager.getConnection(url, username, password);
			String search="SELECT `state` FROM `j430003023`.`alumni` WHERE `studentID` LIKE '" + studentID + "'";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(search);
			if( !result.next() ) {
				statement.close();
				connection.close();
				return -4;
				// If can not find the corresponding alumni in database, return -4...
			}
			int reslutState = result.getInt("state");
			statement.close();
			connection.close();
			return reslutState;
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
	
	// Input the student ID, return the corresponding id...
	// If theere something wrong in class, return -1...
	// If there are some other wrong, return -2...
	// If can not find alumni information in database, return -4...
	public static int alumniID(String studentID){
		try{
			Class.forName(Driver);
			Connection connection = DriverManager.getConnection(url, username, password);
			String search="SELECT `id` FROM `j430003023`.`alumni` WHERE `studentID` LIKE '" + studentID + "'";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(search);
			if( !result.next() ) {
				statement.close();
				connection.close();
				return -4;
				// If can not find the corresponding alumni in database, return -4...
			}
			int reslutID = result.getInt("id");
			statement.close();
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
	
	// Input the id and state, return the corresponding organization...
	// Return an object...
	public static Organization orgnization(int id, int state){
		try{
			if(state == 1){
				Class.forName(Driver);
				Connection connection = DriverManager.getConnection(url, username, password);
				String search="SELECT * FROM `j430003023`.`school` WHERE `id` LIKE '" + id + "'";
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(search);
				if( !result.next() ) {
					statement.close();
					connection.close();
					return null;
				}
				String sname = result.getString("name");
				String scountry = result.getString("country");
				String scity = result.getString("city");
				int top100 = result.getInt("top100");
				statement.close();
				connection.close();
				School orgnazation = new School(sname,scountry,scity,top100);
				return orgnazation;
			}else if(state == 2){
				Class.forName(Driver);
				Connection connection = DriverManager.getConnection(url, username, password);
				String search="SELECT * FROM `j430003023`.`company` WHERE `id` LIKE '" + id + "'";
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(search);
				if( !result.next() ) {
					statement.close();
					connection.close();
					return null;
				}
				String cname = result.getString("name");
				String ccountry = result.getString("country");
				String ccity = result.getString("city");
				statement.close();
				connection.close();
				Company orgnazation = new Company(cname,ccountry,ccity);
				return orgnazation;
			}
			
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();	
		}
		return null;
	}
	
	public static Organization organization(String studentID){
		int id = Search.alumniID(studentID);
		int state = Search.alumniState(studentID);
		if(state == 1){
			School orgnization = (School) Search.orgnization(id, state);
			return orgnization;
		}else if(state == 2){
			Company orgnization = (Company) Search.orgnization(id, state);
			return orgnization;
		}
			return null;
		
	}

	// Input the condition, like name, country, city, top100, search them in the database...
	// If there is shool(s) satisfied these condition, return them in an array of School objet...
	// If there is no school satisfied, return null...
	public static School[] school(String name, String country, String city, int top100){
		try{
			Class.forName(Driver);
			Connection connection = DriverManager.getConnection(url, username, password);
			// Edit sql sentence according by parameters...
			String sql="SELECT * FROM `j430003023`.`school` WHERE ";
			if(name != null){ sql = sql + "`name` LIKE '" + name + "'";}
			if(name != null && (country != null || city != null || top100 != -1)){ sql = sql + "AND";}
			if(country != null){ sql = sql + "`country` LIKE '" + country +"' ";}
			if(country != null && (city != null || top100 != -1)){ sql = sql + "AND";}
			if(city != null){ sql = sql + "`city` LIKE '" + city +"' ";}
			if(city != null && top100 != -1){ sql = sql + "AND";}
			if(top100 != -1){ sql = sql+ "`top100` =" + top100;}
			
			// The end of sql sentence...
			if(name == null && country == null && city == null && top100 == -1){
				sql = sql + "1";
			}
			
			Statement statement = connection.createStatement();
			
			// Get the row number...
			ResultSet r = statement.executeQuery(sql);
			r.last();
			int row = r.getRow();
			
			
			ResultSet result = statement.executeQuery(sql);
			if(!result.next()) return null; 
			// Preparing for the store school[] information...
			
			String[] sname = new String[row];
			String[] scountry = new String[row];
			String[] scity = new String[row];
			int[] stop100 = new int[row];
			School[] school = new School[row+1];
			
			for(int i = 0;; i++){
				sname[i] = result.getString("name");
				scountry[i] = result.getString("country");
				scity[i] = result.getString("city");
				stop100[i] = result.getInt("top100");
				
				school[i] = new School(sname[i], scountry[i], scity[i], stop100[i]);
				if(!result.next()) break;
			}
			school[row] = null;
			statement.close();
			connection.close();
			return school;
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			return null;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		
		}
	}
	
	// Input the student state (1 for school, 2 for company) and corresponding organization id, return if the organization is oversea ...
	// If the organization is oversea, return 1...
	// If the organization is not oversea, return 0...
	// If something wrong in class, return -1...
	// If there are some other wrong, return -2...
	// If the input state is invalid, return -3..
	public static int oversea(int state, int id){
		try{
			if(state != 1 && state != 2) return -3;
			Class.forName(Driver);
			Connection connection = DriverManager.getConnection(url, username, password);
			
			String search="SELECT * FROM `j430003023`.";
			
			if(state == 1) {
				search = search +"`school` WHERE `id` = " + id + " AND `country` LIKE" + "'china'";
			}else{
				search = search + "`company` WHERE `id` = " + id  + " AND `country` LIKE" + "'china'";
			}
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(search);
			if( !result.next()) {
				statement.close();
				connection.close();
				return 1;
			}else{
				statement.close();
				connection.close();
				return 0;
			}
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
	
	// Input the school id, check if it is top 100...
	// If the school is top 100, return 1...
	// If the school is not top 100, return 0...
	// If something wrong in class, return -1...
	// If there are some other wrong, return -2...
	public static int top100(int id){
		try{
			Class.forName(Driver);
			Connection connection = DriverManager.getConnection(url, username, password);
			
			String search="SELECT * FROM `j430003023`.`school` WHERE `id` = " + id + " AND `top100` = 1";
			
			
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(search);
			if( !result.next()) {
				statement.close();
				connection.close();
				return 0;
			}else{
				statement.close();
				connection.close();
				return 1;
			}
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
}
