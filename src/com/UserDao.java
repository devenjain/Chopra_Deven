package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class ConnectionToDB {

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

public class UserDao implements UserService{

	Connection conn = ConnectionToDB.getDbConnection();
	PreparedStatement pstmt;
	
	@Override
	public boolean signUp(UserBean bean) {
		
		boolean flag = false;
		
		if(conn != null) {
			
			String insert = "insert into users(user_name,user_age,user_email,user_password) values(?,?,?,?)";
			
			try {
				
				pstmt = conn.prepareStatement(insert);
				pstmt.setString(1, bean.getUserName());
				pstmt.setInt(2, bean.getUserAge());
				pstmt.setString(3, bean.getUserEmail());
				pstmt.setString(4, bean.getUserPassword());
				
				int res = pstmt.executeUpdate();
				
				if(res>0){
					flag = true;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		return flag;	
	}

	@Override
	public boolean checkLogin(String email, String password) {
		
		boolean flag = false;
		UserBean bean = null;
		
		if(conn!=null) {
			
			String loginSQL = "select * from users where user_email = ? and user_password = ?";
			
			try {
				
				pstmt = conn.prepareStatement(loginSQL);
				pstmt.setString(1, email);
				pstmt.setString(2, password);
						
				ResultSet rs = pstmt.executeQuery();
								
				while(rs.next()) {
					
					bean = new UserBean();
					
					bean.setUserEmail(rs.getString("user_email"));
					bean.setUserPassword(rs.getString("User_password"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(bean != null && email.equals(bean.getUserEmail()) && password.equals(bean.getUserPassword())) 
			flag = true;
		
		return flag;
	}
	
	
	
}
