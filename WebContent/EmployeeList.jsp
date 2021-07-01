<%@page import="com.EmployeeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Table</title>

 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" >
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"></script>
    
</head>

<header style="margin-top:40px;">
<h1><center>Employee Table</center></h1>
</header><br>

<body>

<hr>
<br>

<div class="stable">
	<!--  <table border = "3px" align="center" bgcolor="#7FFFD4">-->
	<table border = "5px" align="center" class="table table-striped">
	
		<tr>
			<b>
			<th><center>Name</center></th>
			<th><center>Age</center></th>
			</b>			
		</tr>
		
		<tr>
			<%
				List<EmployeeBean> empList = (List<EmployeeBean>)request.getAttribute("Employees");
				if(empList != null){
					
					for(int i=0 ; i<empList.size() ; i++){
						
						EmployeeBean bean = empList.get(i);
																		
			%>
			
			<td><center><%=bean.getEmpName() %></center></td>
			<td><center><%=bean.getEmpAge() %></center></td>
			
						
			
		</tr>
			
			<%
					}
				}else{
					out.println("no data");
				}
											
			%>
	
	</table>
	</div>

</body>
</html>