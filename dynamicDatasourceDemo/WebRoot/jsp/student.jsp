<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'student.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		window.onload() {
			var delFlag = document.getElementById("delFlag");
			if (delFlag != null && delFlag == true) {
				alert("删除成功！");
			}
		}
	</script>
  </head>
  
  <body>
  	get方法测试：
  	<form action="student/get" method="post">
  		<div>请输入主键id：<input id="id" name="id" type="text">
	    <input type="submit" value="查询"></div>
  	</form>
  	get方法获取的学生信息为：
    <table>
    	<tr>
    		<td>
    			id
    		</td>
    		<td>
    			姓名
    		</td>
    		<td>
    			卡号
    		</td>
    	</tr>
    	<tr>
    		<td>
    			<c:out value="${student.id}" />
    		</td>
    		<td>
    			<c:out value="${student.name}" />
    		</td>
    		<td>
    			<c:out value="${student.card}" />
    		</td>
    	</tr>
    </table>
    <hr>
    
    add方法测试：
    <form action="student/add" method="post">
	    <table>
	    	<tr>
	    		<td>主键id：</td>
	    		<td><input id="id" name="id" type="text"></td>
	    	</tr>
	    	<tr>
	    		<td>姓名：</td>
	    		<td><input id="name" name="name" type="text"></td>
	    	</tr>
	    	<tr>
	    		<td>性别：</td>
	    		<td><input id="card" name="card" type="text"></td>
	    	</tr>
	    </table>
	    <input type="submit" value="提交">
    </form>
    add方法返回的主键ID为：
    <c:out value="${id}" />
    <hr>
    
    delete方法测试：
    <input id="delFlag" type="hidden" value="<c:out value="${delFlag}" />">
    <form action="student/delete" method="post">
    	<div>请输入主键id：<input id="id" name="id" type="text">
	    <input type="submit" value="删除"></div>
    </form>
    <hr>
  </body>
</html>
