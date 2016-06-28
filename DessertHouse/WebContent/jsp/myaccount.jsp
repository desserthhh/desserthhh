<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
    
    <title>我的DessertHouse</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="../css/account/reset.css"/> 
    <link rel="stylesheet" type="text/css" href="../css/account/style.css"/>
    <link rel="stylesheet" type="text/css" href="../css/account/fancybox.css"/>
    <link href="../css/style.css" rel="stylesheet" type="text/css" media="all"/>
	<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Open+Sans:400,600,300,800,700,400italic|PT+Serif:400,400italic"/>
    <link href='../images/logo.png' rel="shortcut icon" type="image/x-icon" media="screen"/>
    <script type="text/javascript" src="../js/account/jquery.min.js"></script>
    <script type="text/javascript" src="../js/account/jquery.easytabs.min.js"></script>
    <script type="text/javascript" src="../js/account/respond.min.js"></script>
    <script type="text/javascript" src="../js/account/jquery.easytabs.min.js"></script>   
	<script type="text/javascript" src="../js/account/jquery.adipoli.min.js"></script>
    <script type="text/javascript" src="../js/account/jquery.fancybox-1.3.4.pack.js"></script>
    <script type="text/javascript" src="../js/account/jquery.isotope.min.js"></script>
    <script type="text/javascript" src="../js/account/jquery.gmap.min.js"></script>
    <script type="text/javascript" src="../js/account/custom.js"></script>
    
</head>

    <body>
    	<!-- Top -->
    	<div class="header">
    	  		 <div class="headertop_desc">
			<div class="wrap">
				<div class="nav_list">
					<ul>
						<li><a href="">首页</a></li>
						<li><a href="/DessertHouse/commodity.action">甜品列表</a></li>
						<li><a href="/DessertHouse/book.action">预订</a></li>
					</ul>
				</div>
					<div class="account_desc">
						<ul>
						<%
						    String name = (String)request.getServletContext().getAttribute("account_name");
						    if(name == null){
						%>
							<li><a href="login.jsp" target="_blank">请登录</a></li>
							<li><a href="register.jsp" target="_blank">免费注册</a></li>
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
	  	</div>
			<div class="top"> 
            	<!-- Logo -->
            	<div id="logo">
                	<a href="index.jsp"><img src="../images/logo.png" alt="" /></a>
                </div>
                <!-- /Logo -->
                
            </div>
            <!-- /Top -->
       <!-- Container -->
        <div id="container">
        
            
            
            <!-- Content -->
            <div id="content" >
            	 
                <!-- Profile -->
                <div id="profile"> 
                 	<!-- About section -->
                	<div class="about">
                	<%
                	     
                	     String account = (String)request.getServletContext().getAttribute("account");
                	     String tel = (String)request.getServletContext().getAttribute("tel");
                	     String credit = (String)request.getServletContext().getAttribute("credit");
                	     String status = (String)request.getServletContext().getAttribute("status");
                	     String level = (String)request.getServletContext().getAttribute("level");
                	     String money = (String)request.getServletContext().getAttribute("money");
                	     
                	     if(account==null){
                	    	 response.sendRedirect("login.jsp"); 
                	     }
                	%>
                    	<div class="photo-inner"><img src="../images/account/photo.jpg" height="186" width="153" /></div>
                        </br></br><br />
                        <h1><%=name %></h1>
                        <br />
                        <%
				        if(request.getParameter("error") != null && request.getParameter("error").equals("1")){
				        %>
				        <p style="color: red;">您输入的密码或充值金额不正确，请重新充值</p>
				        <%
				         }
				        if(request.getParameter("error") != null && request.getParameter("error").equals("2")){
				        %>
				        <p style="color: red;">第一次充值，充值金额需大于等于200元，请重新充值</p>
				        <%
				         }
				        if(request.getParameter("error") != null && request.getParameter("error").equals("3")){
				         %>
				         <p style="color: red;">第一次充值，请绑定银行卡</p>
				         <%
				         }
				        if(request.getParameter("error") != null && request.getParameter("error").equals("4")){
				         %>
				         <p style="color: red;">您的账户尚未激活，请先激活后再购票</p>
				         <%
				         }
				        if(request.getParameter("error") != null && request.getParameter("error").equals("5")){
				         %>
				         <p style="color: red;">您的账户余额不足，请先充值后购票</p>
				         <%
				         }
				        %>
                        <p style="color:white;">友情提示：当您账户余额不足30元或账户状态处于暂停时，请及时充值以确保您的账号可以正常使用。</p>
                    </div>
                    <!-- /About section -->
                     
                    <!-- Personal info section -->
                	<ul class="personal-info">
                        <li><label>手机号</label><span><%=tel %></span></li>
                        <li><label>会员卡号</label><span><%=account %></span></li>
                        <li><label>积分</label><span><%=credit %></span></li>
                        <li><label>账户级别</label><span><%=level %></span></li>
                        <li><label>账户余额</label><span><%=money %></span></li>
                        <li><label>账户状态</label><span><%=status %></span></li>
                    </ul>
                    <!-- /Personal info section -->
                </div>        
                <!-- /Profile --> 

               <!-- Menu -->
                <div class="menu">
                	<ul class="tabs">
                    	<li><a href="#profile" class="tab-profile">我的资料</a></li>
                    	<li><a href="#resume" class="tab-resume">消费记录</a></li>
                    	<li><a href="#portfolio" class="tab-portfolio">足迹</a></li>
                    	<li><a href="#contact" class="tab-contact">充值</a></li>
                    </ul>
                </div>
                <!-- /Menu --> 
                
                <!-- Resume -->
                <div id="resume">
                	 <div class="timeline-section">
                        <!-- Timeline for Employment  -->   
                        <h3 class="main-heading"><span>消费记录</span></h3>   
                        <ul class="timeline">
                        	<li>                
                                <div class="timelineUnit">
                                    <h4>消费金额<span class="timelineDate" style="color:black;">消费时间</span></h4>
                                    
                                </div>
                            </li>
                        <% 
                        		String[] dessert_name=(String[])request.getServletContext().getAttribute("cname");
                                String[] money_cost = (String[])request.getServletContext().getAttribute("money_cost");
                        		if(money_cost!=null){
                        		String[] time_cost = (String[])request.getServletContext().getAttribute("time_cost");
                        		int num_cost = (Integer)request.getServletContext().getAttribute("num_cost");
                 
                        		for(int i = 0;i<num_cost;i++){
                	     %>
                	     	
                            <li>                
                                <div class="timelineUnit">
                                    <h4><span><%=dessert_name[i] %></span>&nbsp&nbsp<span><%=money_cost[i] %></span><span class="timelineDate"><%=time_cost[i] %></span></h4>
                                    
                                </div>
                            </li>
                          <%
                        		}}
                          %>  
                            <div class="clear"></div>
                        </ul> 
                        <!-- /Timeline for Employment  -->

                        <!-- Timeline for Education  -->   
                        <h3 class="main-heading"><span>缴费记录</span></h3>   
                         <ul class="timeline">
                         <% 
                                String[] money_recharge = (String[])request.getServletContext().getAttribute("money_recharge");
                        		if(money_recharge!=null){
                        		String[] time_recharge = (String[])request.getServletContext().getAttribute("time_recharge");
                        		int num_recharge = (Integer)request.getServletContext().getAttribute("num_recharge");
                        		
                        		for(int i = 0;i<num_recharge;i++){
                	     %>
                            <li>            
                                <div class="timelineUnit">
                                    <h4>充值金额：<span><%=money_recharge[i] %></span><span class="timelineDate"><%=time_recharge[i] %></span></h4>
                                    
                                </div>
                            </li>
                         <%
                        		}}
                         %>
                            <div class="clear"></div>
                        </ul> 
                        <!-- /Timeline for Education  -->              
                    </div>
                </div>
                <!-- /Resume --> 
                                        
                <!-- Portfolio -->
                <div id="portfolio">

                    
                        	<div style="float:left;width:40%;height:300px;margin-top:5%;margin-left:50px;background-color: #F7F7F7;" onclick="window.open('/DessertHouse/book.action','_self')" >
                        		<img src="../images/5.jpg" style=""></img>
                        		<div style="margin-left:10px;width:395px;height:60px;border-radius:17px;">
                        			<h2 style="margin-left:5px;margin-top:15px;float:left;">慕斯蛋糕</h2>
                     
                        			<label style="float:left;margin-left:85px;margin-top:15px;font-size: 30px;color:red;">￥15</label>
                        			
                        		</div>
                        	</div>
                        	
                        	<div style="float:left;width:40%;height:300px;margin-top:5%;margin-left:50px;background-color: #F7F7F7;" onclick="window.open('/DessertHouse/book.action','_self')" >
                        		<img src="../images/6.jpg" style=""></img>
                        		<div style="margin-left:10px;width:395px;height:60px;border-radius:17px;">
                        			<h2 style="margin-left:5px;margin-top:15px;float:left;">薄荷心语</h2>
                     
                        			<label style="float:left;margin-left:85px;margin-top:15px;font-size: 30px;color:red;">￥42</label>
                        			
                        		</div>
                        	</div>
                        	<div style="clear:both;"></div>
                        	<div style="float:left;width:40%;height:300px;margin-top:5%;margin-left:50px;background-color: #F7F7F7;" onclick="window.open('/DessertHouse/book.action','_self')" >
                        		<img src="../images/7.jpg" style=""></img>
                        		<div style="margin-left:10px;width:395px;height:60px;border-radius:17px;">
                        			<h2 style="margin-left:5px;margin-top:15px;float:left;">樱桃布丁</h2>
                     
                        			<label style="float:left;margin-left:85px;margin-top:15px;font-size: 30px;color:red;">￥26</label>
                        			
                        		</div>
                        	</div>
                        	
                        	<div style="float:left;width:40%;height:300px;margin-top:5%;margin-left:50px;background-color: #F7F7F7;" onclick="window.open('/DessertHouse/book.action','_self')" >
                        		<img src="../images/8.jpg" style=""></img>
                        		<div style="margin-left:10px;width:395px;height:60px;border-radius:17px;">
                        			<h2 style="margin-left:5px;margin-top:15px;float:left;">拿铁咖啡</h2>
                     
                        			<label style="float:left;margin-left:85px;margin-top:15px;font-size: 30px;color:red;">￥38</label>
                        			
                        		</div>
                        	</div>
                       
                       
                </div>
                <!-- /Portfolio -->   
                
                <!-- Contact -->
                <div id="contact">
                	<!-- Contact Info -->
                    <div class="contact-info">
                    <h3 class="main-heading"><span>温馨提示</span></h3>
                	<ul>
                        <li>如果您进行过账户充值，则直接在右侧确认登录密码并输入充值金额即可<br /><br /></li>
                        <li>如果这是您第一次进行账户充值，请输入要绑定的银行卡号且充值金额不可小于200元</li>
                    </ul>
                    </div>
                    <!-- /Contact Info -->
                    
                    <!-- Contact Form -->
                    <div class="contact-form">
                        <h3 class="main-heading"><span>账户充值</span></h3>
                        <div id="contact-status"></div>
                        <form action="/DessertHouse/card" method="post" id="contactform">
                            <p>
                            	<label for="name">登录密码</label>
                            	<input type="text" name="password" class="input" >
                            </p>
                            <p>
                            	<label for="email">充值金额（RMB）</label>
                            	<input type="text" name="money" class="input">
                            </p>
                             <p>
                            	<label for="email">银行卡号</label>
                            	<input type="text" name="card" class="input">
                            </p>
                            <input type="submit" name="submit" value="确认充值" class="submit">
                        </form>
                    </div>
                    <!-- /Contact Form -->
                </div>
                <!-- /contact -->  

            </div>
            <!-- /Content -->
            
            <!-- Footer -->
			<div class="footer">
            	<div class="copyright"></div>
            </div>
            <!-- /Footer -->  
            
        </div>
		<!-- /Container -->

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>