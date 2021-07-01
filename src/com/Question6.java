/*
 * Creator : Chopra Deven
 * Date of creation : 01/07/2021
 * 
 * Question 6 : Write a HTTP server program that take the print the received value read from the DB as per Q3

 * 
 * */

package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class ConnWithDB {

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

public class Question6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static List<EmployeeBean> getAllEmp(){
	   
	   List<EmployeeBean> list = new ArrayList<EmployeeBean>();
	   
	   Connection conn = ConnWithDB.getDbConnection();
	   PreparedStatement pstmt;
	   ResultSet rs;
	   
	   if(conn != null) {
		   
		   String selectQuery = "select * from test";
			
		   try {
			
			   pstmt = conn.prepareStatement(selectQuery);
			   rs = pstmt.executeQuery();
			   
			   while(rs.next()) {
				   
				   EmployeeBean bean = new EmployeeBean();
				   
				   bean.setEmpName(rs.getString("Emp_name"));
				   bean.setEmpAge(rs.getInt("Emp_age"));
				   
				   list.add(bean);
				   
			   }
			   
		   } catch (SQLException e) {
			
			   e.printStackTrace();
		   }
  
	   }
	   
		return list;
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<EmployeeBean> empList = Question6.getAllEmp();
		
		request.setAttribute("Employees", empList);
		request.getRequestDispatcher("EmployeeList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
