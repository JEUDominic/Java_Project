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

public class Count {
	private static String url="jdbc:mysql://cstserver.uic.edu.hk";
	private static String username="j430003023";
	private static String password="123456";
	private static String Driver="com.mysql.jdbc.Driver";
	
	
	// Input the two int, one for oversea( 1 is oversea, 0 is not oversea, -1 is all), one for year( -1 for all)...
	// If oversea is -1, return the number of student who go to company according to year...
	// If oversea is 1, reutrn the number of student who go to oversea company according to year...
	// If oversea is 0, return the number of student who go to china company according to year...
	// If return -1, somthing wrong in class...
	// If return -2, somthing wrong in sql...
	// If return -4, can not find school information in database... 
	public static int school(int oversea, int year){
		try{
			// Check year validation...
			if(Validation.yearCheck(year) == -1) return -3;
			// Connect to database...
			Class.forName(Driver);
			Connection connection = DriverManager.getConnection(url, username, password);
			
			
			String sql = "SELECT * FROM `j430003023`.`alumni` WHERE `state` = 1";
			if(Validation.yearCheck(year) == 1) sql = sql + " AND `graYear` = '" + year + "'";
			Statement statement = connection.createStatement();
			
			// Get the row number...
			ResultSet r = statement.executeQuery(sql);
			r.last();
			int row = r.getRow();	
			
			
			if(oversea != 1 && oversea != 0) {
				statement.close();
				connection.close();
				return row;
			
			}
			// Get the id of school...
			ResultSet result =  statement.executeQuery(sql);
			
			if( !result.next() ) {
				statement.close();
				connection.close();
				return -4;
				// If can not find the corresponding school in database, return -4...
			}
			int[] id = new int[row];
			for(int i = 0;; i++){
				id[i] = result.getInt("id");
				if(!result.next()) break;
			}
			// Close database...	
			statement.close();
			connection.close();
			// Check the oversea of these school...
			int j = 0;
			for(int i = 0; i < row ; i++){
				if(Search.oversea(1, id[i]) == 1) j++;
			}
			
			if(oversea == 1) return j;
			else return row-j;
			
		}catch(ClassNotFoundException e) {
		
			e.printStackTrace();
		
			return -1;
		
		} catch(SQLException e) {
		
			e.printStackTrace();
			e.getMessage();
			return -2;
		
		}
		
	}
	
	
	// Input the two int, one for oversea( 1 is oversea, 0 is not oversea, -1 is all), one for year( -1 for all)...
	// If oversea is -1, return the number of student who go to company according to year...
	// If oversea is 1, reutrn the number of student who go to oversea company according to year...
	// If oversea is 0, return the number of student who go to china company according to year...
	// If return -1, somthing wrong in class...
	// If return -2, somthing wrong in sql...
	// If input invalid year number, return -3...
	// If return -4, can not find company information in database... 
	public static int company(int oversea, int year){
		try{
			// Check year validation...
			if(Validation.yearCheck(year) == -1) return -3;
			// Connect to database...
			Class.forName(Driver);
			Connection connection = DriverManager.getConnection(url, username, password);
			
			
			String sql = "SELECT * FROM `j430003023`.`alumni` WHERE `state` = 2";
			if(Validation.yearCheck(year) == 1) sql = sql + " AND `graYear` = '" + year + "'";
			Statement statement = connection.createStatement();
			
			// Get the row number...
			ResultSet r = statement.executeQuery(sql);
			r.last();
			int row = r.getRow();	
			
			
			if(oversea != 1 && oversea != 0) {
				statement.close();
				connection.close();
				return row;
			
			}
			// Get the id of company...
			ResultSet result =  statement.executeQuery(sql);
			if( !result.next() ) {
				statement.close();
				connection.close();
				return -4;
				// If can not find the corresponding company in database, return -4...
			}
			int[] id = new int[row];
			if(!result.next()) return 0;
			for(int i = 0;; i++){
			id[i] = result.getInt("id");
			if(!result.next()) break;
			}
			
			// Close database...	
			statement.close();
			connection.close();
			// Check the oversea of these company...
			int j = 0;
			for(int i = 0; i < row ; i++){
				if(Search.oversea(2, id[i]) == 1) {
					j++;
				}
			}
			
			if(oversea == 1) return j;
			else return row-j;
			
		}catch(ClassNotFoundException e) {
		
			e.printStackTrace();
		
			return -1;
		
		} catch(SQLException e) {
		
			e.printStackTrace();
			e.getMessage();
			return -2;
		
		}
		
	}
	
	// Input graduation year(-1 or between 2008~2016), return the number of student who is at home graduation this year..
	// If input -1, it means select all the year, return the number of student who at home for all student...
	// If return -1, somthing wrong in class...
	// If return -2, somthing wrong in sql...
	// If input invalid year number, return -3...
	// If return -4, can not find company information in database... 
	public static int home(int year){
		try{
			// Check year validation...
			if(Validation.yearCheck(year) == -1) return -3;
			// Connect to database...
			Class.forName(Driver);
			Connection connection = DriverManager.getConnection(url, username, password);
			
			
			String sql = "SELECT * FROM `j430003023`.`alumni` WHERE `state` = 0";
			if(Validation.yearCheck(year) == 1) sql = sql +" AND `graYear` = '" + year +"'";
			
			Statement statement = connection.createStatement();
			
			// Get the row number...
			ResultSet r = statement.executeQuery(sql);
			r.last();
			int row = r.getRow();	
			
			// Close database...	
			statement.close();
			connection.close();
			
			return row;
			
		}catch(ClassNotFoundException e) {
		
			e.printStackTrace();
		
			return -1;
		
		} catch(SQLException e) {
		
			e.printStackTrace();
			e.getMessage();
			return -2;
		
		}
		
	}
	
	// Input two int, top100( 1 for top 100, 0 for not top 100),year( -1 for all)...
	// Return the number of school that satisfied input parameters...
	// If return -1, somthing wrong in class...
	// If return -2, somthing wrong in sql...
	// If input invalid year number, return -3...
	// If return -4, can not find company information in database... 
	public static int top100(int top100, int year){
		try{
			// Check year validation...
			if(Validation.yearCheck(year) == -1) return -3;
			// Connect to database...
			Class.forName(Driver);
			Connection connection = DriverManager.getConnection(url, username, password);
			
				
			String sql = "SELECT * FROM `j430003023`.`alumni` WHERE `state` = 1";
			if(Validation.yearCheck(year) == 1) sql = sql + " AND `graYear` = '" + year + "'";
			Statement statement = connection.createStatement();
			
			// Get the row number...
			ResultSet r = statement.executeQuery(sql);
			r.last();
			int row = r.getRow();	
			
			
			if(top100 != 1 && top100 != 0) {
				statement.close();
				connection.close();
				return row;
					
			}
			// Get the id of school...
			ResultSet result =  statement.executeQuery(sql);
			if( !result.next() ) {
				statement.close();
				connection.close();
				return -4;
				// If can not find the corresponding company in database, return -4...
			}
			int[] id = new int[row];
			for(int i = 0;; i++){
			id[i] = result.getInt("id");
			if(!result.next()) break;
			}
			// Close database...	
			statement.close();
			connection.close();
			// Check the top100 of these school...
			int j = 0;
			for(int i = 0; i < row ; i++){
				if(Search.top100(id[i]) == 1) j++;
			}
			
			if(top100 == 1) return j;
			else return row-j;
		}catch(ClassNotFoundException e) {
		
			e.printStackTrace();
	
			return -1;
	
		}catch(SQLException e) {
	
			e.printStackTrace();
			e.getMessage();
			return -2;
	
		}
		
	}
	
}
