<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="net.sf.json.JSONArray"%>
<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=10" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示全部学生</title>

<link rel="icon" href="../images/logo.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="../css/showAllStudent.css">
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../js/fenYeShow.js"></script>
</head>
<body>
  <%
    String result=(String)request.getAttribute("result");
    Integer num=(Integer)request.getAttribute("count");
    int pageCount;
    if(num%8==0){
      pageCount=num/8;
    }else{
      pageCount=num/8+1;
    }
    JSONArray jsonArray=JSONArray.fromObject(result);
    int count=jsonArray.size();
    int pageIndex=1; 
   %>
   
   <h2 class="header">显示全部学生</h2>
   <div class="pageturning"><input type="button" value="首页" id="first" class="fyResultBtn" /><input type="button" value="下一页" id="next" class="fyResultBtn"/><span>
     <%
       for(int i=0;i<pageCount;i++){
     %>
       <span class="pageId" onclick="toPage()"><span class="allPageId"><span class="pageIdShow"><%=i+1 %></span></span></span>
     <%  
       }
      %>
     </span><input type="button" value="上一页" id="last" class="fyResultBtn"  o><input type="button" value="尾页" id="final" class="fyResultBtn" /></div>
    <table class="showStudentTable" cellpadding="10" cellspacing="2" border="0" id="showTable">
      <thead>
         <tr>
            <th>编号</th>
            <th>学生姓名</th>
            <th>学号</th>
            <th>学院</th>
            <th>专业</th>
            <th>班级</th>
            <th>性别</th>
            <th>邮箱</th>
            <th>操作</th>
         </tr>
       </thead>
            <%
              for(int i=0;i<count;i++){
                   JSONObject jsonObject=jsonArray.getJSONObject(i);
           %>
             <tr>
             <td><%=i+1%></td>
             <td><%=jsonObject.getString("suserName")%></td>
             <td><%=jsonObject.getString("studentNum") %></td>
             <td><%=jsonObject.getString("xyName") %></td>
             <td><%=jsonObject.getString("majorName") %></td>
             <td><%=jsonObject.getString("classGrade") %></td>
             <td><%=jsonObject.getString("studentSex") %></td>
             <td><%=jsonObject.getString("email") %></td>
             <td><a href="toModifyStudent?sno=<%=jsonObject.getString("sno") %>">修改</a><a href="">删除</a></td>
             </tr>
            <%
              }
           %>
   </table>
         <div>当前第<span id="pageIndex">1</span>页<span id="warning" class="lastWarning"></span><span class="showPageCount">总共<span id="showPageCount"><%=pageCount %></span>页</span></div>
</body>
</html>