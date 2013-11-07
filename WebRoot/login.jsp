<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>医学院在线考试系统入口</title>
<link rel="icon" href="images/logo.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="css/denglu.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js" ></script>
<script type="text/javascript" src="js/loginVerify.js"></script>

</head>
<body style="background-image: url(images/login_bg.jpg);background-attachment: fixed">
<div id="topNavWrapper"> 
<ul class="jd_menu" id="topNav">
     <span>医学院在线考试系统</span> 
     <span><a href="register.jsp">注册</a></span>
</ul> 
</div> 
  <div id="warp">
  <div>
 <div id="login_box_setting"></div>
  <div id="login_box">
<ul id="login_ul" >
      <li id="suerName_li">用户名：</li>
      <li id="login_suserName_input_li"><input type="text" id="tuserName" placeholder="用户名"/></li>
     
      <li id="spassword_li">密  码：</li>
      <li id="spassword_li_input">
        <input type="password" id="tpassword" placeholder="密码" />
      </li>
     
      <li id="confirmCode_li">验证码：</li>
      <li id="confirmCode_image"><input type="text" id="verifyCode" placeholder="验证码" />
         <img src="image.jsp" id="rand">
      </li>
     
       <li id="userKind_li">用户类型</li>
       	<li id="userKind_select_li"> 
         <select id="userKind">
             <option value="1">学生</option>
             <option value="2">教师</option>
         </select>
      </li>
     
      <li id="login_btn_li"><input type="button" id="loginOK"/></li>
      <li id="warning_li">
         <div id="warning"></div>
      </li>
  </ul>
 </div>
</div>
</div>


</body>
</html>