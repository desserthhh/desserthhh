<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<head>
<title>批准计划-DessertHouse</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all"/>
<link href="../css/component.css" rel="stylesheet" type="text/css" media="all"/>
<link href="../css/date.css" rel="stylesheet" type="text/css" media="all"/>
<link href='../images/logo.png' rel="shortcut icon" type="image/x-icon" media="screen"/>
<script type="text/javascript" src="../js/jquery-1.9.0.min.js"></script> 
<script type="text/javascript" src="../js/move-top.js"></script>
<style>
.btn{
    text-align:center;
    cursor:pointer;
	padding:10px 10px;
	font-family: 'ambleregular';
	background:#FC7D01;
	color: #FFF;
	text-decoration: none;
	outline: 0;
}
.btn:hover{
	  text-shadow: 0px 0px 1px #000;
	  background:#292929;
}
    input{padding:8px 5px;width:18.5%;display:block; border-radius:3px;border:1px solid #ddd;outline:none;text-align:center;color:#666;box-shadow: 2px 2px 5px 0px rgba(50, 50, 50, 0.35);}
input:focus{border-color:#ccc;color:#333;}
</style>
</head>
<body>
	<div class="header">
  	  		 <div class="headertop_desc">
			<div class="wrap">
				<div class="nav_list">
					<ul>
						<%
						String type = (String)request.getServletContext().getAttribute("accountType");
						if(type=="waiter"){
						%>
						<li><a href="/DessertHouse/plan.action">制定计划</a></li>
						<%
						}
						if(type=="manager"){
						%>
						<li><a href="/DessertHouse/allowplan.action">批准计划</a></li>
						<%
						}
						%>
					</ul>
				</div>
				<div class="account_desc">
						<ul>
						<%
						    String name = (String)request.getServletContext().getAttribute("account_name");
						    if(name != null){
						%>
						    <li><a href="#" target="_blank">欢迎你，<%=name %></a></li>
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
			 <div class="clear"></div>
  		</div>     
   		</div>
   </div>
   <!------------End Header ------------>
     <div class="main">
 	<div class="wrap">
     <div class="content">
     	<div class="content_top">
    		<div class="back-links">
    		<p><a href="/DessertHouse/sale.action">售票</a> &gt;&gt; <a href="#" class="active">放映计划</a></p>
    	    </div>
    		<div class="clear"></div>
    	</div>
    <div class="component">
        <form method="post" action="#">
		<table>
			<thead>
				<tr>
                    <th>日期</th>
					<th>店铺</th>
                    <th>名称</th>
					<th>类型</th>
					<th>价格</th>
					<th>数量</th>
                    <th>批准</th>
                    <th>待修改</th>
				</tr>
			</thead>
			<%
            String[] c_name = (String[])request.getServletContext().getAttribute("c_name");
			if(c_name != null){
			   String[] date = (String[])request.getServletContext().getAttribute("date");
			   String[] store = (String[])request.getServletContext().getAttribute("store");
			   String[] c_type = (String[])request.getServletContext().getAttribute("c_type");		   
			   String[] price = (String[])request.getServletContext().getAttribute("price");
			   String[] pid = (String[])request.getServletContext().getAttribute("pid");
               String[] num = (String[])request.getServletContext().getAttribute("num");
			   int p_len = (Integer)request.getServletContext().getAttribute("p_len");
             %>
			<tbody>
			<% 
			   for(int i = 0;i<p_len;i++){
			%>
				<tr>
                    <td><%=date[i] %></td>
                    <td><%=store[i] %></td>
                    <td><%=c_name[i] %></td>
                    <td><%=c_type[i] %></td>
                    <td>￥<%=price[i] %></td>
                    <td><%=num[i] %></td>
                    <td><a href="/DessertHouse/allowandalter?pid=<%=pid[i]%>&&allow=1">批准</a></td>
                    <td><a href="/DessertHouse/allowandalter?pid=<%=pid[i]%>&&allow=-1">待修改</a></td>
                </tr>
			<%
			   }
			}
			%>
			</tbody>  
		</table>
        </form>
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

    <script type="text/javascript">
		$(document).ready(function() {			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
		});
	</script>
    <a href="#" id="toTop"><span id="toTopHover"> </span></a>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

