<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<head>
<title>-MStore</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all"/>
<link href="../css/checkbox.css" rel="stylesheet" type="text/css" media="all"/>
<link href="../css/component.css" rel="stylesheet" type="text/css" media="all"/>
<link href='../images/logo.png' rel="shortcut icon" type="image/x-icon" media="screen"/>
<script type="text/javascript" src="../js/jquery-1.9.0.min.js"></script> 
<script type="text/javascript" src="../js/move-top.js"></script>

</head>
<body>
		<div class="header">
  	  		 <div class="headertop_desc">
			<div class="wrap">
				<div class="nav_list">
					<ul>
						<li><a href="index.jsp">首页</a></li>
						<li><a href="#">影片场次</a></li>
						<li><a href="http://www.wandafilm.com/jingxuan/main.jsp">电影谈资</a></li>
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
							<li><a href="/MStores/account.action">我的MStore</a></li>
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
    		<p><a href="index.html">首页</a> &gt;&gt;&gt; <a href="#" class="active">影片场次</a></p>
    	    </div>
    		<div class="clear"></div>
    	</div>
    		<div class="section group">
                <div class="cinema">
                <label><h3><b>选择影院：</b></h3></label>
                <span class="select" onclick="choose(this)">新街口万达影城<input type="checkbox" value="" name="mark[]" /></span>
                </div>
                <div class="movie">
                <label><h3><b>选择影片：</b></h3></label>
                <span onclick="choose(this)">全部<input type="checkbox" value="" name="mark[]" /></span>
                <span onclick="choose(this)">天将雄师<input type="checkbox" value="" name="mark[]" /></span>
                <span onclick="choose(this)">澳门风云2<input type="checkbox" value="" name="mark[]" /></span>
                <span onclick="choose(this)">超能陆战队<input type="checkbox" value="" name="mark[]" /></span>
                </div>
            </div>

    <div class="component">
		<table>
			<thead>
				<tr>
                    <th>影片名</th>
					<th>放映时间</th>
					<th>语言</th>
					<th>版本</th>
					<th>片长</th>
                    <th>价格</th>
                    <th>购票</th>
				</tr>
			</thead>
			<%
            String[] movie_name = (String[])request.getServletContext().getAttribute("movie_name");
			if(movie_name != null){
			   String[] start = (String[])request.getServletContext().getAttribute("start");
			   String[] language = (String[])request.getServletContext().getAttribute("language");
			   String[] version = (String[])request.getServletContext().getAttribute("version");
			   String[] howlong = (String[])request.getServletContext().getAttribute("howlong");
			   String[] price = (String[])request.getServletContext().getAttribute("price");
			   String[] pid = (String[])request.getServletContext().getAttribute("pid");
			   int num = (Integer)request.getServletContext().getAttribute("num");
             %>
			<tbody>
			<% 
			   for(int i = 0;i<num;i++){
			%>
				<tr><td><%=movie_name[i] %></td><td><%=start[i] %></td><td ><%=language[i] %></td><td><%=version[i] %></td><td><%=howlong[i] %>分钟</td><td>￥<%=price[i] %></td><td><a href="/MStores/seat?pid=<%=pid[i] %>">购票</a></td></tr>
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

