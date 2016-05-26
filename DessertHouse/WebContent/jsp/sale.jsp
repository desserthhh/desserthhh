<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<head>
<title>销售-DessertHouse</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all"/>
<link href="../css/checkbox.css" rel="stylesheet" type="text/css" media="all"/>
<link href="../css/component.css" rel="stylesheet" type="text/css" media="all"/>
<link href='../images/logo.png' rel="shortcut icon" type="image/x-icon" media="screen"/>
<link href="../css/date.css" rel="stylesheet" type="text/css" media="all"/>
<script type="text/javascript" src="../js/jquery-1.9.0.min.js"></script> 
<script type="text/javascript" src="../js/move-top.js"></script>

</head>
<body>
		<div class="header">
  	  		 <div class="headertop_desc">
			<div class="wrap">
				<div class="nav_list">
					<ul>
						<li><a href="">销售</a></li>
						<%
						String type = (String)request.getServletContext().getAttribute("accountType");
						String pwaiter = (String)request.getServletContext().getAttribute("pwaiter");
						if(pwaiter=="pwaiter"){
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
						<a href="index.html"><img src="../images/logo.png" alt="" /></a>
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
    		<p><a href="index.html">首页</a> &gt;&gt;&gt; <a href="#" class="active">购买</a></p>
    	    </div>
    		<div class="clear"></div>
    	</div>
    		<div class="section group">
                <div class="cinema">
       
                </div>
                <div class="movie">
                	<form action="">
                    <input id="date" name="date" type="text" value="--" size="14" readonly onClick="showcalendar(event,this);" onFocus="showcalendar(event, this);if(this.value=='0000-00-00')this.value=''">
                	</form>
                </div>
            </div>

    <div class="component">
		<table>
			<thead>
				<tr>
                    <th>日期</th>
                    <th>名称</th>
					<th>类型</th>
					<th>价格</th>
                    <th>预定</th>
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
               String[] status = (String[])request.getServletContext().getAttribute("status");
			   int p_len = (Integer)request.getServletContext().getAttribute("p_len");
             %>
			<tbody>
			<% 
			   for(int i = 0;i<p_len;i++){
			%>
				<tr>
                    <td style="display:none"><%=store[i] %></td>
                    <td><%=date[i] %></td>                    
                    <td><%=c_name[i] %></td>
                    <td><%=c_type[i] %></td>
                    <td>￥<%=price[i] %></td>
                    <td style="display:none"><%=num[i] %></td>
                    <td><a href="/DessertHouse/transit?pid=<%=pid[i] %>">购买</a></td>
                </tr>
			<%
			   }
			}
			%>
			</tbody>
		</table>
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
                        <li><a href="contact.html">联系我们</a></li>
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
</body>
</html>

