<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import=" java.util.List"%>
<%@page import=" java.util.ArrayList"%>
<%@page import="org.nele.domain.XueYuan" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加一个学生</title>
<link rel="stylesheet" href="../css/addStudent.css">
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../js/addStudent.js"></script>
</head>
<body>
    <%
    XueYuan xueYuan=new XueYuan();
    List<String> listXyName=new ArrayList<String>();
    List<XueYuan> list=(ArrayList<XueYuan>)request.getAttribute("xyList");
    int num=list.size();
    for(int i=0;i<num;i++){
       xueYuan=list.get(i);
       listXyName.add(xueYuan.getXyName());
    }
   %>
    <div class="addStudentDiv">
    <h1 class="Header">增加学生</h1>
    <table class="addStudentTable">
  <tr>
     <td width="100">学生姓名</td>
     <td><input type="text" id="suserName"></td>
  </tr>
  
  <tr>
    <td>学生密码</td>
    <td><input type="password" id="spassword"></td>
  </tr>
  <tr>
    <td>密码确认</td>
    <td><input type="password" id="sconfirm"></td>
  </tr>
   <tr>
     <td width="100">学号</td>
     <td><input type="text" id="studentNum"></td>
  </tr>
  <tr>
    <td>学生性别</td>
    <td><select id="ssex">
            <option value="1">男</option>
            <option value="2">女</option>
    </select></td>
  </tr>
  <tr>
    <td>学院</td>
    <td><select id="xy">
       <option value="0">==请选择类型==</option>
    <%
    for(int i=0;i<num;i++){
       xueYuan=list.get(i);
    %>
        <option value="<%=xueYuan.getXyId()%>">
         <%=xueYuan.getXyName() %>
       </option>
    <% 
      }
    %>   
       </select></td>
  </tr>
  <tr>
    <td>专业</td>
   <td><select id="major">   
       </select></td>
  </tr>
  <tr>
    <td>班级</td>
    <td><select id="class">
        </select></td>
  </tr>
  <tr>
   <td>邮箱</td>
   <td><input type="text" id="email"></td>
  </tr>
    <tr>
  <td colspan="2"><div id="warning"></div><font style="margin-left: 300px"><input type="button" value="提交" id="addStudent" /></font></td>
  </tr>
</table>
</div>
</body>
</html>