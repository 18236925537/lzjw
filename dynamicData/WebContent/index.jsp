<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.lang.*"%>
<%@ page import="java.net.InetAddress"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>二期工程mobile</title>
	</head>
	<body>
		<a id="aaa" href="">提交</a>
	</body>
	<script type="text/javascript">
		var url = window.document.location.href;
		var a = [];
		UrlSearch(url);
		aaa.href="http://20.124.143.141:8866/lzjw/user/auth?code="+a.code+"&corp_id="+a.corp_id;
		function UrlSearch(url) {
		   var name,value;
		   var str=url; //取得整个地址栏
		   var num=str.indexOf("?")
		   str=str.substr(num+1); //取得所有参数   stringvar.substr(start [, length ]
	
		   var arr=str.split("&"); //各个参数放到数组里
		   
		   for(var i=0;i < arr.length;i++){
		        num=arr[i].indexOf("=");
		        if(num>0){
		             name=arr[i].substring(0,num);
		             value=arr[i].substr(num+1);
		             arr[name]=value;
		        }
		        
		   }
		   a = arr;
		}
	</script>
</html>