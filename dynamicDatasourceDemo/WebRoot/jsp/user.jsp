<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user.jsp' starting page</title>
    
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
			var updateFlag = document.getElementById("updateFlag");
			if (updateFlag != null && updateFlag == true) {
				alert("修改成功！");
			}
		}
	</script>
  </head>
  
  <body>
    findAll方法测试：
  	<form action="user/findAll" method="post">
	    <input type="submit" value="查询">
  	</form>
  	findAll方法获取的学生信息为：
    <table>
    	<tr>
    		<td>
    			id
    		</td>
    		<td>
    			姓名
    		</td>
    		<td>
    			性别
    		</td>
    	</tr>
    	<c:forEach var="user" items="${users}">
    		<tr>
	    		<td>
	    			<c:out value="${user.id}" />
	    		</td>
	    		<td>
	    			<c:out value="${user.name}" />
	    		</td>
	    		<td>
	    			<c:out value="${user.sex}" />
	    		</td>
    		</tr>
    	</c:forEach>
    </table>
    <hr>
    
    add方法测试：
    <form action="user/add" method="post">
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
	    		<td><input id="sex" name="sex" type="text"></td>
	    	</tr>
	    </table>
	    <input type="submit" value="提交">
    </form>
    add方法返回的主键ID为：
    <c:out value="${id}" />
    <hr>
    
    update方法测试：
    <input id="updateFlag" type="hidden" value="<c:out value="${updateFlag}" />">
    <form action="user/update" method="post">
    	<table>
	    	<tr>
	    		<td>主键id：</td>
	    		<td><input id="id" name="id" type="text" value="<c:out value="${user.id}" />"></td>
	    	</tr>
	    	<tr>
	    		<td>姓名：</td>
	    		<td><input id="name" name="name" type="text" value="<c:out value="${user.name}" />"></td>
	    	</tr>
	    	<tr>
	    		<td>性别：</td>
	    		<td><input id="sex" name="sex" type="text" value="<c:out value="${user.sex}" />"></td>
	    	</tr>
	    </table>
	    <input type="submit" value="修改">
    </form>
    <hr>
  </body>
</html>
