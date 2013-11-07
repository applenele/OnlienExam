<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="org.nele.domain.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>考试系统</title>
 <link rel="icon" href="../images/logo.ico" type="image/x-icon">
 <link rel="stylesheet" type="text/css" href="../css/denglu.css" />
 <link rel="stylesheet" type="text/css" href="../css/test_index.css" />
 
<script type="text/javascript" src="../js/jquery-1.7.2.min.js" ></script>
<script type="text/javascript" src="../js/test_main_switch.js"></script>
</head>
<%
   Student user=(Student)request.getSession().getAttribute("user");
   if(user==null){
     out.print("<script language='javascript'>window.top.location.href='../login.jsp';</script>");
    }
  else{
 %>
<body style="background-image: url(../images/login_bg.jpg);background-attachment: fixed">
<div id="topNavWrapper"> 
<ul class="jd_menu" id="topNav">
 <li><span>医学院在线考试系统</span> </li>
</ul> 
</div>
<div id="box">
<div id="left">左侧</div>
 <div id="main">
 <div id="show_user" >
     <span id="user_name"><%=user.getStudentName()%></span>
     <span id="user_login_welcome">你好，登陆成功</span>
     <span id="loginout">退出登陆</span>
 </div>
  <div id="header_show">
   <ul class="menu">
    <li>有关咨询</li>
    <li>考试大纲</li>
    <li>考试须知</li>
    <li>章节练习</li>
    <li>题型练习</li>
    <li>综合练习</li>
    <li>错题练习</li>
    <li>开始考试</li>
    <li>个人中心</li>
   </ul>
  </div>
  
<div class="content">
          <div class="layout">infomation 1.1</div>
          <div class="layout">infomation 1.2</div>
          <div class="layout">infomation 1.3</div>
          <div class="layout">infomation 1.4</div>
          <div class="layout">infomation 1.5</div>
          <div class="layout">infomation 1.6</div>
          <div class="layout">infomation 1.7</div>
          <div class="layout">infomation 1.8</div>
          <div class="layout"></div>
 </div>
 </div>
<div id="right">右侧</div>
</div>
<%
  }
 %>
</body>
</html>