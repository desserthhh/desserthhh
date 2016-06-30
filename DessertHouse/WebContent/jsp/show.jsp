<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all"/>
<link href='../images/logo.png' rel="shortcut icon" type="image/x-icon" media="screen"/>
<script type="text/javascript" src="../js/jquery-1.9.0.min.js"></script> 
<title>甜品列表</title>
</head>
<body>
	
	<div class="header">	
  	  	<div class="headertop_desc">
			<div class="wrap">
				<div class="nav_list">
					<ul>
						<li><a href="index.jsp">首页</a></li>
						<li><a href="">甜品列表</a></li>
						<li><a href="/DessertHouse/book.action">预订</a></li>
					</ul>
				</div>
					<div class="account_desc">				
						<ul>
						<%
						    String name = (String)request.getServletContext().getAttribute("account_name");
						    if(name == null){
						%>
						
							<li id="loginBtn"><a href="login.jsp" target="_blank">请登录</a></li>
							<li id="registerBtn"><a href="register.jsp" target="_blank">免费注册</a></li>
					
							
						<%
						    }else{
						%>
						    <li><a href="#" target="_blank">欢迎你，<%=name %></a></li>
						    <li><a href="/DessertHouse/account.action">账号管理</a></li>
						    <li><a href="/DessertHouse/loginout.action">登出</a></li>
						<%
						    }
						%>
							
						</ul>
					</div>
				<div class="clear"></div>
			</div>
	  	</div>
	  	
	  	
  	  		<div class="wrap">
				<div class="header_top">
					<div class="logo">
						<a href="index.jsp"><img src="../images/logo.png" alt="" /></a>
					</div>
						<div class="header_top_right">
							<div class="search_box">
					     		<form>
					     			<input type="text" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}"><input type="submit" value="">
					     		</form>
					     	</div>
						 <div class="clear"></div>
					</div>
			 <div class="clear"></div>
  			</div>     
				
 		 </div>
	</div>
	<!------------End Header ------------>
	<div class="main">
		<div class="wrap">
      		<div class="content">
      			<%  String[] cids = (String[])request.getServletContext().getAttribute("cids");
    			 	String[] c_names = (String[])request.getServletContext().getAttribute("c_names");
    			 	String[] images = (String[])request.getServletContext().getAttribute("images");
    			 	String[] cidd = (String[])request.getServletContext().getAttribute("cidd");
    			 	String[] d_names = (String[])request.getServletContext().getAttribute("d_names");
    			 	String[] d_images = (String[])request.getServletContext().getAttribute("d_images");
    			%>
      			<!------------content_top ------------>
      	
    			<div class="content_top">
    				<div class="heading">
    					<h3>甜品</h3>
    				</div>
    			</div>
    			
    			<div class="section group">
    			<% for(int i=0;i<15;i++){
    			
    			%>
    				<div class="grid_1_of_5 images_1_of_5">
					 	<a href="preview.html"><img src="<%=images[i] %>"  alt="" /></a>
						<div class="price-details">
				       		<div class="price-number">
								<p><span class="rupees"><%=c_names[i] %></span></p>
					    	</div>
					       	<div class="add-cart">		
					       		<h4><a href="/DessertHouse/show?cid=<%=cids[i] %>">购买</a></h4>
							</div>
							<div class="clear"></div>
						</div>
    				</div>
    			<%
    				}
    			%>
    			
    			</div>
    		
    			<!------------content_bottom ------------>
    		
    			<div class="content_bottom">
    				<div class="heading">
    					<h3>饮品</h3>
    				</div>
    	  		</div>
    	  		
    	  		<div class="section group">
    			<% for(int i=0;i<5;i++){
    			
    			%>
    				<div class="grid_1_of_5 images_1_of_5">
					 	<a href="preview.html"><img src="<%=d_images[i] %>" alt="" /></a>
						<div class="price-details">
				       		<div class="price-number">
								<p><span class="rupees"><%=d_names[i] %></span></p>
					    	</div>
					       	<div class="add-cart">		
					       		<h4><a href="/DessertHouse/show?cid=<%=cidd[i] %>">购买</a></h4>
							</div>
							<div class="clear"></div>
						</div>
    				</div>
    			<%
    				}
    			%>
    			</div>
 
    		</div>
    	</div>
	</div>
	
</body>
</html>