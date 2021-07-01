/*
 * Creator : Chopra Deven
 * Date of creation : 30/06/2021
 * 
 * Question 4 : Write a program to call a HTTP url and print the output
				a.	URL is http://127.0.0.1:8999/test?value=p
 * 
 * */

package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 
 * here my server's Connector port is 9090 that's why URL will be
 * 
 * "http://localhost:9091/Internship_Programs/test?value=p"
*/
public class Question4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// assumption taken that when first time program will be run then there will be no any parameter will be passes in URL.....after URL rewriting parameter named "value" will be passed and output will be printed according parameter.
		
		String p = request.getParameter("value");
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		pw.print("<html><body>");		
		if(p==null) 
			pw.print("There is no parameter passed in URL... Please pass parameter in URL!!!");
		
		else 
			pw.print(p);
				
		pw.print("<html><body>");
		pw.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
