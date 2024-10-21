package com.mpsilvestri.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	
	/*
	private String URL = "jdbc:mysql://localhost:3306/capacitacao";
	private String USER = "root";
	private String PASS = "admin@123456";
	*/
	
	/*
	private String URL = "jdbc:mysql://mysql3000.mochahost.com:3306/mpsilves_capacitacao";
	private String USER = "mpsilves_mars";
	private String PASS = "M@arcosP@aulo01";
	*/
	
	private static String URL = "jdbc:mysql://148.113.153.60:3306/marco4326_capacitacao";
	private static String USER = "marco4326_admin";
	private static String PASS = "M@arcosP@aulo01";
	
	public static Connection connection;
	
	public Database() {
		
		boolean availability;
		
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(URL, USER, PASS); 
						
			if (connection != null) {
				System.out.println("Connection established!!!");
			
			availability = connection.createStatement().execute("select * from treinamento");
			if (availability)
				System.out.println("Database with data for querying! \n");
			
			Database.connection = connection;
			
			}
			
		} catch (SQLException sql_ex) {
			System.out.println("Problem to connect: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Problem to connect: " + cnfe.getMessage() + "|" + cnfe.getStackTrace());
			cnfe.printStackTrace();
		} 
		
		
		
	}

}
