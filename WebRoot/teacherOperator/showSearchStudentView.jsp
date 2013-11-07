<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import=" java.util.List"%>
<%@page import=" java.util.ArrayList"%>
<%@page import="org.nele.domain.XueYuan" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>查找学生信息</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="../css/addStudent.css"> 
	<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="../js/addStudent.js"></script>
    <script type="text/javascript" src="../js/showSearchStudentView.js"></script>
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
<h1 class="Header">学生查找</h1>
<form action="searchStudent" method="post">
<table class="addStudentTable">
  <tr>
    <td><font style="margin-left: 80px">姓名</font></td>
    <td><input type="text" id="suserName" name="studentOfsearchInfo.suserName"/></td>
  </tr>
  <tr>
    <td><font style="margin-left: 80px">学院</font></td>
    <td><select id="xy" name="studentOfsearchInfo.xyId">
        <option value="0">===请选择学院===</option>
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
    <td><font style="margin-left: 80px">专业</font></td>
    <td><select id="major" name="studentOfsearchInfo.majorId">
          <option value="0">===请选择专业===</option>
        </select></td>
  </tr>
  <tr>
    <td><font style="margin-left: 80px">班级</font></td>
    <td><select id="class" name="studentOfsearchInfo.classId">
         <option value="0">===请选择班级===</option>
        </select></td>
  </tr>
   <tr>
    <td colspan="2"><div id="warning"></div>
    <font style="margin-left: 300px"><input type="submit" id="searchOk" value="确认"/></font></td>
  </tr>
</table>
</form>
  </body>
</html>
