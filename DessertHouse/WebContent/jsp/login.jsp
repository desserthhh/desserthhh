<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>DESSERT HOUSE login</title>
    <link href="../css/login.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>	
	<div id="login">
	<form action="/DessertHouse/login" method="post" enctype="multipart/form-data">
 		<input  class="input" type = "text" name = "id" id="id" placeholder="账号" size = "12" maxlength = "12" />
	   <br></br>
	   <input class="input" type = "password" name = "ps" id="ps" placeholder="密码" size = "12" maxlength = "12" />  
	   <p id="loginInfo">&nbsp;</p>
	  <% if(request.getParameter("error") != null && request.getParameter("error").equals("1")){%>
	   <script>
        	document.getElementById("loginInfo").innerHTML="您的账号或密码有误";
       </script>
	   <%}%>
	   
	   <input class="sub" id="confirmsub" name = "loginsub" type = "submit" value = ""/>
	   <div class="sub" id="registersub" ><a href="register.jsp">&nbsp;&nbsp;&nbsp;</a></div>
	</form>	
	</div>	
</body>
</html>