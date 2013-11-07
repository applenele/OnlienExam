<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@page import="org.nele.domain.*" %>   
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="../css/modifyStudent.css">
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../js/modifyStudent.js"></script>
</head>
<body>
	<%
	  Student student=(Student)request.getAttribute("student");
	  XueYuan xueYuan=(XueYuan)request.getAttribute("xueYuan");
	  Major major=(Major)request.getAttribute("major");
	  org.nele.domain.Class classInfo=(org.nele.domain.Class)request.getAttribute("classInfo");
	  
	  List<XueYuan> allXueYuan=(ArrayList<XueYuan>)request.getAttribute("allXueYuan");
	  List<Major>  allMajor=(ArrayList<Major>)request.getAttribute("allMajor");
	  List<org.nele.domain.Class>  allClass=(ArrayList<org.nele.domain.Class>)request.getAttribute("allClass");
	  
	  int xueYuanCount=allXueYuan.size();
	  int majorCount=allMajor.size();
	  int classCount=allClass.size();
	  
	  
	 %>
    <h2 class="header">修改学生信息</h2>
    
    <table>
        <tr>
           <th>编号</th>
           <td><input type="text" value="<%=student.getSno() %>" disabled="disabled" id="sno"></td>
        </tr> 
        <tr>
          <th>姓名</th>
          <td><input type="text" value="<%=student.getStudentName() %>" id="suserName"/></td>
        </tr>
        <tr>
          <th>学号</th>
          <% 
            if("".equals(student.getStudentNum())||student.getStudentNum()==null){
          %>
          <td><input type="text" value="" id="studnetNum"/></td>
          <% 
            }else{
          %>
          <td><input type="text" value="<%=student.getStudentNum() %>" id="studnetNum"/></td>
          <%  
            }
          %>
        </tr>
        
        <tr>
          <th>学院</th>
          <td><select id="xy">
           <% 
              for(int i=0;i<xueYuanCount;i++){
                XueYuan xueYuanDemo=allXueYuan.get(i);
                 if(xueYuanDemo.getXyId()==xueYuan.getXyId()){                 
            %>
               <option value="<%=xueYuanDemo.getXyId()%>" selected="selected"><%=xueYuanDemo.getXyName() %></option> 
            <%  
              }else{
          
           %>
              <option value="<%=xueYuanDemo.getXyId()%>"><%=xueYuanDemo.getXyName() %></option>
           <%    
              }
              }
           %>
              </select></td>
        </tr>
        <tr>
          <th>专业</th>
          <td><select id="major">
          <%
            for(int i=0;i<majorCount;i++){
                Major majorDemo=allMajor.get(i);
                if(majorDemo.getMajorId()==major.getMajorId()){
           %>
              <option value="<%=majorDemo.getMajorId() %>" selected="selected"><%=majorDemo.getMajorName() %></option>
           <%     
                }else{
            %>
            <option value="<%=majorDemo.getMajorId() %>"><%=majorDemo.getMajorName() %></option>
            <%      
                }
            }
          %> 
             </select></td>
        </tr>
        
        <tr>
          <th>班级</th>
          <td>
             <select id="classId">
             <%
                for(int i=0;i<classCount;i++){
                   org.nele.domain.Class classDemo=allClass.get(i);
                   if(classDemo.getClassId()==classInfo.getClassId()) {
              %>
               <option value="<%=classDemo.getClassId() %>" selected="selected"><%=classDemo.getClassGrade() %></option>
              <%     
                   }else{
              %>
                 <option value="<%=classDemo.getClassId() %>"><%=classDemo.getClassGrade() %></option>
              <%     
                   }
                
                }
              %>
             </select>
          </td>
        </tr>
        <tr>
          <th>邮箱</th>
          <td><input type="text" value="<%=student.getEmail() %>" id="email" /></td>
        </tr>
        <tr>
          <th>性别</th>
          <td><input type="text" value="<%=student.getStudentSex() %>" id="studentSex" /></td>
        </tr>
        <tr>
          <th>旧密码</th>
          <td><input type="password" id="oldPassword" ></td>
        </tr>
        <tr>
          <th>新密码</th>
          <td><input type="password" id="newPassword"></td>
        </tr>
        <tr>
          <th>确认新密码</th>
          <td><input type="password" id="ConfirmTewPassword"></td>
        </tr>
        <tr><td><input type="button" value="提交" id="submit"/></td></tr>
    </table>
    <div id="warning"></div>
</body>
</html>