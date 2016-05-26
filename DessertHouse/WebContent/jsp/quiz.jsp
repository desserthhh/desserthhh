<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>参加活动</title>

<link href="../css/quiz.css" rel="stylesheet" type="text/css" media="all"/>
<script type="text/javascript" src="../js/jquery-1.9.0.min.js"></script> 

</head>

<body>

<div id="quiz-container" class="main-quiz-holder">
    <div class="slide-container" style="display: block;">
    <%
          String activity_question = (String)request.getServletContext().getAttribute("activity_question");
          String[] choices = (String[])request.getServletContext().getAttribute("choices");
          String[] cid = (String[])request.getServletContext().getAttribute("cid");
          int num = (Integer)request.getServletContext().getAttribute("quiz_num");    	     
     %>
        <div class="question"><%=activity_question %>(单选)
        </div>
        <form action="/MStores/setanswer" method="post">
        <ul class="answer">
     <%
          for(int i = 0;i<num;i++){
     %>
            <li><input type="checkbox" value="<%=cid[i] %>" name="cid" /><%=choices[i] %></li>
     <%
          }
     %>
        </ul>
        <div class="nav-container">
        <div class="next">
            <input type="submit" value="确认"  class="nav-show-result">
        </div>
        </div>
        </form>
    </div>
    <div class="notice" style="display: none;">请选择一个选项！</div>
</div>
</body>
</html>