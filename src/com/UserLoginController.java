package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLoginController
 */
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userName = (String) request.getParameter("email");
		String userPassword = (String) request.getParameter("password");
		
		UserService service = new UserDao();
		
		if(service.checkLogin(userName, userPassword)) {
			response.sendRedirect("LoginSuccess.jsp");
		}
		else {
//			response.sendError(404, "Login failed");
			response.sendRedirect("LoginFailed.jsp");
		}
		
		doGet(request, response);
		
		
		
	}

}
