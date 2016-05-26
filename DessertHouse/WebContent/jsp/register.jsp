<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>注册-MStore</title>
		<meta charset="utf-8">
        <link href="../css/login.css" rel="stylesheet" type="text/css" media="all"/>	
</head>
<body>
	<div id="register">
        <form action="/DessertHouse/register" method="post">
            <p id="loginInfo">&nbsp;</p>
            <%
                if(request.getParameter("error") != null && request.getParameter("error").equals("1")){
            %>
            	<script>document.getElementById("loginInfo").innerHTML="您的账号或密码有误";</script>
            <%
                }
            	if(request.getParameter("error") != null && request.getParameter("error").equals("2")){
            %>
               <script>document.getElementById("loginInfo").innerHTML="您的手机号已经注册";</script>
            <%
              	}
            	if(request.getParameter("error") != null && request.getParameter("error").equals("3")){
            %>
            	<script>document.getElementById("loginInfo").innerHTML="运行错误";</script>
            <%
            	}
            %>
            
            <input type="text" class="rinput" name="name" placeholder="请输入您的姓名"><br></br>
            <input type="text" class="rinput" name="tel" placeholder="请输入您的手机号"><br></br>
            <input type="password" class="rinput" name="password" placeholder="请输入6-16位密码"><br></br>
            <input type="password" class="rinput" name="confirm" placeholder="重复输入6-16位密码"><br></br>           
           
            <p id="logintip"><a href="login.jsp">已有账号？点此登录</a></p>
           
             <input id="rp" id="confirmsub" name = "registersub" type = "submit" value = ""/>
           
        </form>
    </div>
</body>
</html>