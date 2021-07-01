<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type = "text/javascript">
	function myfunction() {
	
		/* alert("Invalid Id or Password\nPlease Try Again!!!"); */
		if (confirm("SignUp Successfull\nLogin your Account")) {
	        window.location.href = "Question9.jsp";
	    }
		
	}
</script>

</head>
<body onload="myfunction()">

</body>
</html>