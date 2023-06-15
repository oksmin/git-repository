<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%!
	String name = "사민";
	String msg = "안녕하세요.";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>jsp-class01</title>
</head>
<body>
	sdsfsdf <br>
	<%= name %> 님, <%= msg %>	<br>
	
	<%
		Date today = new Date();
		System.out.println(today);
		SimpleDateFormat formatter = new SimpleDateFormat("YY-MM-d k:m:s"); //RR-MM-DD HH24:mi:ss
		
	%>
	
	<% 
		String presentTime = null;
		int cnt = 0;
		while( cnt < 10 ){
			today = new Date();
			presentTime = formatter.format(today);
			System.out.println(presentTime);
			Thread.sleep(1000);
			
			cnt++;
		}
	%>
	
	
		<h1> <%= presentTime %> </h1>
	http://localhost:9000/view/jsp-class01.jsp
</body>
</html>