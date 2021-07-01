package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserSigupController
 */
public class UserSigupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = (String) request.getParameter("userName");
//		String age = (String) request.getParameter("userAge"); 
		
		int userAge = Integer.parseInt(request.getParameter("userAge"));
		
//		if(age != null && age.equals(""))
//			userAge = Integer.parseInt(age);
		
		String userEmail = (String) request.getParameter("email");
		String userPassword = (String) request.getParameter("pwd");
		
		System.out.println(userName);
		System.out.println(userAge);
		System.out.println(userEmail);
		System.out.println(userPassword);
		
		
		UserBean bean = new UserBean();
		
		bean.setUserName(userName);
		bean.setUserAge(userAge);
		bean.setUserEmail(userEmail);
		bean.setUserPassword(userPassword);
		
		UserService service = new UserDao();
		
		if(service.signUp(bean)) {
			response.sendRedirect("SignupSuccess.jsp");
		}
		else {
			response.sendRedirect("SignupFailed.jsp");
		}
		
		doGet(request, response);
	}

}
