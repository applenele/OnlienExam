<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>医学院在线考试注册</title>
<link rel="icon" href="images/logo.ico" type="image/x-icon">

<link rel="stylesheet" type="text/css" href="css/register.css" />

<script type="text/javascript" src="js/jquery-1.10.2.min.js" ></script>
<script type="text/javascript" src="js/registerVerify.js"></script>
</head>
<body style="background-image: url(images/login_bg.jpg);background-attachment: fixed">
 <h2>医学院在线考试注册</h2>
 <!-- 注册小框 -->
<div id="confirm">
  <div id="header"><span id="header_title">用户注册</span></div>
    <div id="registerForm">
    <ul>
    <li id="userLi"><span id="userSpan">用户名：</span><span><input type="text" id="suserName" /></span><span id="input_user_warning" class="input_user_warning">请输入用户名</span></li>
    <li id="passwordLi"><span id="passwordSpan">密码：</span><span><input type="password" id="register_tpassword"/></span><span id="input_password_warning" class="input_password_warning">请输入密码</span></li>
    <li id="passwordAgainLi"><span id="passwordAgainSpan">密码重复：</span><span><input type="password" id="tpasswordConfirm"/></span><span id="input_password_again_warning" class="input_password_again_warning">请再次输入密码</span></li>
    <li id="emailLi"><span>邮箱：</span><span id="emailSpan"><input type="text" id="email" /></span><span id="input_email_warning" class="input_email_warning">请输入邮箱</span></li>
    <li id="userKindLi"><span>用户类型：</span><span>
       <select id="register_userKind">
          <option value="1">学生</option>
          <option value="2">教师</option>
       </select>
    </span><span id="select_userKind_warning" class="select_userKind_warning">请选择用户类型</span></li>
    <li id="register_verifycode_li"><span>验证码：</span><sapn><input type="text" id="register_verifyCode" /></sapn><span><img src="image.jsp" id="register_rand" /></span><span id="input_verifycode_warning" class="input_verifycode_warning">请输入验证码</span></li>
    
    
    <li id="register_warning_li"><span></span></li>
    <li><span id="register_submit_span"><button id="register_submit_button">提交</button></span><span id="register_quit_span"><button id="register_quit_button">取消</button></span></li>
    </ul>
	</div>  
</div>
</body>
</html>