<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>include 처리</title>
</head>
<body>
	<div class="header">
		<%@ include file="jsp-class01.jsp" %>
	</div>
	<div class="contents">
		<h1>include 지시자로 외부페이지 가져오기</h1>
	</div>
</body>
</html>