<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showMessage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <font size="4"><b></b><a href="<c:url value='/gopublishMessage.jsp'/>">发布信息</a></b></font>
    <font size="4"><a href="<c:url value='/user/userloginOut.action'/>">退出系统</a></font>
    	欢迎:${user.username}
    <table>
    	<tr><td>发送人</td><td>发送时间</td><td>接收人</td><td>信息内容</td></tr>
    	<c:forEach items="${messageList}" var="message">
    	<tr>
	    	<td>${message.usersBySender.username}</td>
	    	<td>${message.mestime}</td>
	    	<td>${message.usersByGetter.username}</td>
	    	<td>${message.content}</td>
    	</tr>
    	</c:forEach>
    </table>
    
  </body>
</html>
