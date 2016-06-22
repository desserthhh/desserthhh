<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>注册-MStore</title>
		<meta charset="utf-8">
        <link href="../css/style.css" rel="stylesheet" type="text/css" media="all"/>
		<link href="../css/login-register.css" rel='stylesheet' type='text/css' />
		<link href='../images/logo.png' rel="shortcut icon" type="image/x-icon" media="screen"/>
</head>
<body>
	 <!-----start-main---->
	 <div class="main">
         <div class="wrap">
         <div class="header_top">
					<div class="logo">
						<a href="index.jsp"><img src="../images/logo.png" alt="" /></a>
					</div>
						<div class="header_top_right">
							  
						 <div class="clear"></div>
					</div>
			 <div class="clear"></div>
  		</div>
        </div>
		<div class="login-form">
			<h1><b>注册会员（四项必填）</b></h1>
					<div class="head">
						<img src="../images/user.png" alt=""/>
					</div>
				<form action="/DessertHouse/register" method="post">
				<%
                if(request.getParameter("error") != null && request.getParameter("error").equals("1")){
                %>
                        <p style="color: red;">请正确填写注册信息</p>
                <%
                }
                if(request.getParameter("error") != null && request.getParameter("error").equals("2")){
                %>
                        <p style="color: red;">您的手机号已经注册</p>
                <%
                }
                %>
						<input type="text" class="text" name="name" placeholder="请输入您的姓名" onfocus="this.value = '';" >
                        <input type="text" class="text" name="tel" placeholder="请输入您的手机号" onfocus="this.value = '';" >
						<input type="password" name="password" placeholder="请输入6-16位密码" onfocus="this.value = '';" >
                        <input type="password" name="confirm" placeholder="重复输入6-16位密码" onfocus="this.value = '';" >
						<div class="submit">
							<input type="submit" value="注册" >
					</div>	
					<p><a href="login.jsp">已有账号？点此登录</a></p>
				</form>
			</div>
			<!--//End-login-form-->
		</div>
			 <!-----//end-main---->
</body>
</html>