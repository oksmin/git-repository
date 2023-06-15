<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="com.java.servlet.vo.BoardVO" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Model2 - MVC</title>
	<style type="text/css">
		span {
			color: red;
		}
	</style>
</head>
<body>
	<h1>Hello World</h1>
	<%-- <%= request.getAttribute("boardList") %> --%>
	
	<br><br>
	<%-- ${ requestScope.boardList } --%>
	
	\${pageContext.servletContext.contextPath } : ${pageContext.servletContext.contextPath } <br>
	
	<c:forEach var="vo" items="${ requestScope.boardList }" varStatus="status" begin="1" end="3" step="1">
		\${ status.count } : ${ status.count } <br>
		\${ status.begin } : ${ status.begin } <br>
		\${ status.current } : ${ status.current } <br>
		\${ status.end } : ${ status.end } <br>
		\${ status.index } : ${ status.index } <br>
		\${ status.step } : ${ status.step } <br>
		\${ status.first } : ${ status.first } <br>
		\${ status.last } : ${ status.last } <br>
		<c:if test="${ status.first }">
			<h3>첫번째 들어옴</h3>
		</c:if>
		
		<c:if test="${ status.last }">
			<h4>마지막이지롱</h4>
		</c:if>
		
		<p>-------------------------------------------------</p>
		
	</c:forEach>
	
	<table style="border: 1px red solid;">
		<tr>
			<th>index</th>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:forEach var="vo" items="${ requestScope.boardList }" varStatus="status">
		<tr>
			<td>${vo.b_no}</td><!-- pageScope에 vo가 생성되었다.  -->
			<td><a href="${pageContext.servletContext.contextPath }/board?method=get&b_no=${vo.b_no}">${vo.title}</a></td>
			<td>${vo.id}</td>
			<td>${vo.reg_date}</td>
		</tr>
		</c:forEach>
	</table>
	
	<br>
	<table style="border: 1px red solid;">
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<% 
		    List<BoardVO> list = (List<BoardVO>)request.getAttribute("boardList");
		    
			for(int i=0; i < list.size(); i++){
				BoardVO vo = list.get(i);
			
		%>
		<tr>
			<td><%=vo.getB_no() %></td>
			<td><%=vo.getTitle() %></td>
			<td><%=vo.getId() %></td>
			<td><%=vo.getReg_date() %></td>
		</tr>
		<%
			}
		%>
	</table>
	
	
	
	
	
	
	<br><br>
	${ sessionScope.SESS_AUTH }<br>
	${ sessionScope.SESS_ID }<br>
	${ sessionScope.SESS_USERNAME }<br>
	${ sessionScope.SESS_USERNO }
	
	<br>
	\${ SESS_AUTH } : ${ SESS_AUTH }<br>
	\${ sessionScope['SESS_AUTH'] } : ${ sessionScope['SESS_AUTH'] }<br>
	<!-- 2번째 사이클에서 false 가 된다. -->
	<!-- \${ sessionScope['SESS_AUTH']= false } --> : <%-- ${ sessionScope['SESS_AUTH'] = false} --%> <br>

	
	
		
	
</body>
</html>