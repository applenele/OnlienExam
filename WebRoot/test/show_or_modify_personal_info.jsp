<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="org.nele.domain.Student" %>
<%@page import="org.nele.domain.Class" %>
<%@page import="org.nele.domain.Major" %>
<%@page import="org.nele.domain.XueYuan" %>
<script type="text/javascript" src="../js/test_personal_infomation.js"></script>
   
<link rel="stylesheet" type="text/css" href="../css/modifyStudent.css">
<%
   Student user=(Student)request.getSession().getAttribute("user");
   org.nele.domain.Class bj=(org.nele.domain.Class)request.getSession().getAttribute("bj");
   Major major=(Major)request.getSession().getAttribute("major");
   XueYuan  xy=(XueYuan)request.getSession().getAttribute("xy");
 %>

<div id="navigation"><span>当前位置：</span><span>个人中心</span><span>个人信息修改</span><span><a href="" class="pageId">返回主页</a></span></div>
<table border="1" id="show_user_info_table">
    <tr>
       <td>用户名</td>
       <td><span><input value="<%=user.getStudentName() %>"></span></td>
       <td><span>修改</span></td>
    </tr> 
    <tr>
      <td>学号</td>
      <td><span><input value="<%=user.getStudentNum() %>" disabled="disabled" id="sno"></span></td>
      <td><input id="pk_sno" value="<%=user.getSno() %>" type="hidden" /></td>
    </tr> 
    <tr>
      <td>密码</td>
      <td><div id="click_modify_pwd_div"><button id="click_to_modify_pwd">修改密码</button></div>
          <div id="show_modify_pwd_box">
          <div id="modify_pwd_div">
             <table id="modify_pwd_div_table" border="1">
               <tr>
                  <td>原始密码</td>
                  <td><input type="password" id="pre_pwd"></td>
               </tr>
               <tr>
                  <td>新密码</td>
                  <td><input type="password" id="new_pwd" ></td>
               </tr>
               <tr>
                  <td>密码重复</td>
                  <td><input type="password" id="new_pwd_again" ></td>
               </tr>
               <tr>
                 <td colspan="2" id="modify_pwd_btn"><button id="pwd_modify_ok">确认</button>
                            <button id="pwd_modify_cancel">取消</button>
                 </td>
               </tr>
               
             </table>
        </div>
        <div id="right_show_error_warning"></div>
        </div>
     </td>
     <td></td>
    </tr>
    <tr>
      <td><span>班级</span></td>
      <td id="show_class_td"><div id="show_class_div"><span id="bjName"><%=bj.getClassGrade() %></span><button id="test_modify_user_info_modify_class_btn">修改</button></div>
      
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
       <td id=""><button id="modify_ok">确定</button><button id="bi_modify_cancal_btn">取消</button></td>
     </tr>
       </table>
     </div>
  </td> 
      <td></td>
    </tr>
    
    <tr>
      <td><span>性别</span></td>
      <td><span><% 
          String sexDemo=user.getStudentSex();
          String sex=sexDemo.trim();
          %><select>
       <%   
          if("男".equals(sex)||sex=="男")
          {
        %>
             <option value="1" selected="selected">男</option>
             <option value="2">女</option>
             <%
           }else{
              %>
              <option value="1">男</option>
              <option value="2" selected="selected">女</option>
             <%
               }
              %>
             </select>
      </span></td>
      <td></td>
    </tr>
    <tr>
      <td><span>邮箱</span></td>
      <td><span><input value="<%=user.getEmail()%>" id="email_modify_text"></span><span><button id="email_submit_modify_btn">确认修改</button></span><span id="email_warning"></span></td>
      <td></td>
    </tr>
    <tr>
      <td><span> 职务</span></td>
      <td><span>未设置</span></td>
      <td></td>
    </tr>
    <tr>
      <td><span>等级</span></td>
      <td><span>未设置</span></td>
      <td></td>
    </tr>
    
  </table>