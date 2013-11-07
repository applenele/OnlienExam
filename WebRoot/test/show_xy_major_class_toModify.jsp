<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="org.nele.domain.Class" %>
<%@page import="org.nele.domain.Major" %>
<%@page import="org.nele.domain.XueYuan"%>
<script type="text/javascript" src="../js/test_personal_infomation.js"></script>
<%
 org.nele.domain.Class bj=(org.nele.domain.Class)request.getSession().getAttribute("bj");
 Major major=(Major)request.getSession().getAttribute("major");
 XueYuan  xy=(XueYuan)request.getSession().getAttribute("xy");
%>

<div id="show_xy_major_class">
   <table>
     <tr id="modify_to_user_show_xy_table_tr">
         <td>学院</td>
         <td><select id="xy">
             <option value="<%=xy.getXyId() %>"><%=xy.getXyName() %></option>
             </select></td>
     </tr>
     <tr id="modify_to_user_show_major_table_tr">
       <td>专业</td>
       <td>
           <select id="major">
              <option value="<%=major.getMajorId()%>"><%=major.getMajorName() %></option>
           </select></td>
     </tr>
     <tr>
        <td>班级</td>
        <td>
           <select id="bj">
             <option value="<%=bj.getClassId()%>"><%=bj.getClassGrade() %></option>
           </select>
         </td>
     </tr>
     <tr>
       <td><button id="modify_ok">确定</button></td>
     </tr>
   </table>
</div>