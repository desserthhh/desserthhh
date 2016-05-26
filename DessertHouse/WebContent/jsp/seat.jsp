<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<head>
<title>在线选座-MStore</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all"/>
<link rel="stylesheet" type="text/css" href="../css/jquery.seat-charts.css">
<link href='../images/logo.png' rel="shortcut icon" type="image/x-icon" media="screen"/>

<style>
.btn{
    width:80px; 
    height:24px; 
    line-height:20px;
    text-align:center;
    margin: 10px auto;
    cursor:pointer;
	display: block;
	padding:8px 10px;
	font-family: 'ambleregular';
	background:#FC7D01;
	color: #FFF;
	text-decoration: none;
	outline: 0;
	-webkit-transition: all 0.5s ease-in-out;
	-moz-transition: all 0.5s ease-in-out;
	-o-transition: all 0.5s ease-in-out;
	transition: all 0.5s ease-in-out;
}
.btn:hover{
	  text-shadow: 0px 0px 1px #000;
	  background:#292929;
}
.hidden{
    display: none;
}
.display{
    padding: 0;
    widows: inherit;
    height: inherit;
}
.float{
float:left;

}

</style>
<script type="text/javascript" src="../js/jquery-1.9.0.min.js"></script> 
<script src="../js/jquery.seat-charts.min.js"></script> 
</head>
<body>
	<div class="header">
  	  		 <div class="headertop_desc">
			<div class="wrap">
				<div class="nav_list">
					<ul>
						<li><a href="index.jsp">首页</a></li>
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
						<%
						    }
						%>
							<li><a href="#">我的DessertHouse</a></li>
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
     	<div class="content_top">

    		<p><a href="/DessertHouse/sale">购买</a>&gt;&gt;
    		<label >下单</label>&gt;&gt;</p>
    		<script type="text/javascript">
    			function form(){
    				 document.getElementById("form").className("display");
    				 document.getElementById("memberInfo").className("hidden");				
    			}
    			function info(){
    				 document.getElementById("memberInfo").className("display");
    				 document.getElementById("form").className("hidden");			
    			}
    		</script>
    		
    		<div class="clear"></div>
    	</div>
       <div>
            <div id="memberInfo" class="hidden">
            <%	 String mid = (String)request.getServletContext().getAttribute("mid");
            String m_name = (String)request.getServletContext().getAttribute("m_name");
            String m_tel = (String)request.getServletContext().getAttribute("m_tel");
            String m_level = (String)request.getServletContext().getAttribute("m_level");
            String[] money_cost = (String[])request.getServletContext().getAttribute("money_cost");
            String[] time_cost = (String[])request.getServletContext().getAttribute("time_cost");
            String[] money_recharge = (String[])request.getServletContext().getAttribute("money_recharge");
            String[] time_recharge = (String[])request.getServletContext().getAttribute("time_recharge");
            
            %>
            <h1>顾客</h1>
            	<p>账号：<%=mid %></p>
            	<p>名称：<%=m_name %></p>
            	<p>电话：<%= m_tel%></p>
            	<p>等级：<%=m_level %></p>
            	<p>消费记录：</p>
            	<%if(money_cost!=null){
                	int num_cost = Integer.parseInt((String)request.getServletContext().getAttribute("num_cost"));
                	for(int i=0;i<num_cost;i++){
                %>
                <p><%=money_cost[i]%>  <%=time_cost[i] %></p>
            	<%}} %>
            	<p>缴费记录：</p>
            	<%if(money_recharge!=null){
                	int num_recharge = Integer.parseInt((String)request.getServletContext().getAttribute("num_recharge"));
                	for(int i=0;i<num_recharge;i++){
                %>
                <p><%=money_recharge[i]%> <%=time_recharge[i] %></p>
            	<%}} %>
            	<div class="clear"></div>
            </div>
            <br>
             <div  id="form" >
     		<h1>购买</h1>
            <form action="/DessertHouse/buy" method="post" id="buy-form">
            <%
            String c_name = (String)request.getServletContext().getAttribute("name");
            int price = Integer.parseInt((String)request.getServletContext().getAttribute("price"));
			   String date = (String)request.getServletContext().getAttribute("date");
			   String type = (String)request.getServletContext().getAttribute("type");
			   int num = Integer.parseInt((String)request.getServletContext().getAttribute("num"));
			   String pid = (String)request.getServletContext().getAttribute("pid");			 
				String u_type = (String)request.getServletContext().getAttribute("accountType");		
             %>
                <input type="text" value="<%=pid %>" name="pid" style="display:none">
                <input type="text" id="sale" value="" name="sale" style="display:none">
                <p>日期：<span><%=date %></span></p> 
                <p>名称：<span><%=c_name %></span></p>               
                <p>价钱：<span><%=price %></span></p>             
                <p>个数：<input type="number" id="counter" name="num" value="">(<%=num %>)</p>   
                 <%if(u_type=="waiter"){
                %>
               	<select name="pay">
               		<option value="1">在线支付</option>
               		<option value="0">现金</option>
               	</select>
               	<%} %>        
               	<br>                           
                <input type="submit" value="选购">
             </form>       
       	<div class="clear"></div>
            </div>
            </div>
            </div>
        </div>
    </div> 
    </div>
 </div>
   <div class="footer">
   	  <div class="wrap">	
	     <div class="section group">
				<div class="col_1_of_4 span_1_of_4">
                    <h4><b>相关信息</b></h4>
                    <ul>
                        <li><a href="contact.jsp">联系我们</a></li>
						<li><a href="#">帮助中心</a></li>
						</ul>
					</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4><b>后台入口</b></h4>
                    <ul>
						<li><a href="login.jsp" target="_blank">员工登录</a></li>
						<li><a href="login.jsp" target="_blank">经理登录</a></li>
                    </ul>
				</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4><b>联系方式</b></h4>
                    <ul>
                        <li><span>+91-123-456789</span></li>
                        <li><span>+00-123-000000</span></li>
                    </ul>
				</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4><b>链接分享</b></h4>
                    <div class="social-icons">
                        <ul>
							 <li><a href="#" target="_blank"><img src="../images/facebook.png" alt="" /></a></li>
							 <li><a href="#" target="_blank"><img src="../images/twitter.png" alt="" /></a></li>
							 <li><a href="#" target="_blank"><img src="../images/skype.png" alt="" /> </a></li>
							 <li><a href="#" target="_blank"><img src="../images/linkedin.png" alt="" /></a></li>
							 <div class="clear"></div>
                        </ul>
                    </div>
				</div>
			</div>
			 <div class="copy_right">
				<p>Copyright &copy; 2015.Company name All rights reserved.</p>
		   </div>			
        </div>
    </div>
 
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

