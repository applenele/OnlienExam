<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div>
</div>
<% 
      out.println("<script language='javascript'>window.top.location.href='../login.jsp';</script>");
      session.invalidate();
%>