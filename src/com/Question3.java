/*
 * Creator : Chopra Deven
 * Date of creation : 29/06/2021
 * 
 * Question 3 : Write a program to read value from the DB. The SB scheme is as follows:
					a.	Username: root
					b.	Password: root
					c.	Table name: test
					d.	Schema  
						i.	Emp name varchar 200
						ii.	Emp age int 10

 *
 * */


package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class ConnWithMySQL {

	private static String userName = "root";
	private static String password = "mysql123";

	private static String connectionURL = "jdbc:mysql://localhost:3306/test";
	private static String driverClass = "com.mysql.jdbc.Driver";

	public static Connection getDbConnection() {

		Connection conn = null;
		// loading driver....
		
		try {
			Class.forName(driverClass); // loaded..
			// getting connection...

			conn = DriverManager.getConnection(connectionURL, userName, password); //
			// conn --
			if (conn != null) {

				System.out.println("Connected with database...");
			} else {

				System.out.println("not connected with database..");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}


}


public class Question3 {

	public void getAllEmps() {
		
		Connection conn = ConnWithMySQL.getDbConnection();
		PreparedStatement pstmt;
		
		if (conn != null) {

			try {

				String selectQuery = "select * from test";
				
				pstmt = conn.prepareStatement(selectQuery);

				ResultSet rs = pstmt.executeQuery();

				System.out.println(
						"==========================");
				System.out.println();
				System.out.format("%-15s | %5s |", "Name", "Age");
				System.out.println();
				System.out.println(
						"---------------------------");
					System.out.println();
				
					while (rs.next()) {

					System.out.format(""
							+ "%-15s | %5s |",	rs.getString("Emp_name"), rs.getInt("Emp_age"));

					System.out.println();

				}
				System.out.println();
				System.out.println(
						"=============================");
				System.out.println();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		else {
			System.out.println("Not connected to database!!");
		}
		
		
	}
	
	public static void main(String[] args) {
		
		Question3 obj = new Question3();
		
		obj.getAllEmps();
		
	}

}
