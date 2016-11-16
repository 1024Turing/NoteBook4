<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <script type="text/javascript" src="<c:url value='/jquery-1.10.0.js'/>"></script>
  <script type="text/javascript" >
  	function ajaxJqueryPOST(){
  		
  		   $.post("<c:url value='/message/message_ajax.action'/>",function(data){
  		   	alert( data);
  		   	},"text"
  		   ); 
  		   
		 alert("hahah"); 
	   /*  $.ajax({  
	     url:"<c:url value='/message/message_ajax.action'/>",  
	     type:'post',  
	     data:"{}",  
	     dataType:'json',  
	     success:function (data){
	    	 alert(data);
	    	 }
	     });  */
	  	}  
  </script>
  
  </head>
  
  <body>
    <br>
   	<form action="<c:url value='/message/message_publishMessage.action'/>" method="post">
   		<table>
		  	<tr><td>接收人</td><td><input type="text" name="getter" /></td></tr>
			<tr><td>发送内容</td><td><textarea name="content" rows="5" cols="20">请输入内容</textarea></td></tr>
			<tr><td><input type="submit" value="发布" /></td><td><input type="reset"  value="重新填写"/></td></tr>
 		</table>
   	</form>
   	<input type="button" value="ajax请求POST" onclick="ajaxJqueryPOST()"/>
  </body>
</html>
