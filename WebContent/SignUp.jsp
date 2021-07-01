<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>  
<html>  
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>  

<style>  
body{  
  font-family: Calibri, Helvetica, sans-serif;  
  background-color: E0FFFF;  
}  
.container {  
    	padding-left: 250px;
    	padding-right: 250px;  
	/* background-color: #8FBC8F; */
	/* background-color: #1a8cff;    */
}  
  
input[type=text], input[type=password], textarea {  
  width: 100%;  
  padding: 15px;  
  margin: 5px 0 22px 0;  
  display: inline-block;  
  border: none;  
  background: #f1f1f1;  
}  

input[type=text]:focus, input[type=password]:focus {  
  background-color: #ccd9ff;  
  outline: none;  
}  

/* input[type=date]{
  width: 15%;  
  padding: 10px;  
  margin: 5px 0 22px 10px;  
  display: inline-block;  
  border: none;  
  background: whitesmoke;  
}  

input[type=date]:focus{
  background-color: #b0fcb0 ;  
  outline: none;  
}   */

 div {  
            padding: 10px 0;  
         }
           
hr {  
  border: 1px solid #f1f1f1;  
  margin-bottom: 25px;  
}  
.registerbtn {  
  background-color: #4d79ff;  
  color: white;  
  padding: 16px 20px;  
  margin: 8px 0;  
  border: none;  
  cursor: pointer;  
  width: 100%;  
  opacity: 0.9;  
}  
.registerbtn:hover {  
  opacity: 1;  
}  
p{
color:red;
}

</style>  
</head>  
<body>  

<form action="UserSigupController" method="post">   
 
 <div class="container">  
    
  <center>  <h1> Sign Up</h1> </center> 
  <hr>  
    
  	<label><b> User Name :</b></label>
	<input type="text" name="userName" placeholder= "Enter User Name" size="15" required />   

	<label><b> User Age : </b></label> 
	<div class= "iphone"><input type="number" name="userAge" placeholder="Enter User age" size="3" required>   </div>   
	  
 	<label for="email"><b>Email</b></label> 
 	<input type="text" placeholder="Enter Email" name="email" required>  
	  
    	<label for="psw"><b>Password</b></label> &nbsp;&nbsp; <font color = "RED">${pwdErrormsg }</font>
    	<input type="password" placeholder="Enter Password" name="pwd" value="${upwd}" required>  
	  
    	<input type="reset" class="registerbtn"></button>   
    	<button type="submit" class="registerbtn">Sign Up</button> 
	    
<%--     <%@include file="footer.jsp" %> --%>
       
</form>  
</body>  
</html>  