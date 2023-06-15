<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.java.servlet.vo.MemberVO" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>member list</title>
	<style type="text/css">
		.box-table, .box-table th, .box-table td{ 
			border: 1px red solid;
		}
	</style>
</head>
<body>
		<% 
			List<MemberVO> memberList = (List<MemberVO>) request.getAttribute("memberList") ;
		%>
	<table class="box-table">
		<thead>
			<tr>
				<th>m_no</th><th>name</th><th>jumin-number</th><th>id</th>
			</tr>
		</thead>
		<tbody>
			<%
				for(int i=0; i < memberList.size() ; i++){
					MemberVO vo = memberList.get(i);
					%>
					<tr>
						<td><%= vo.getM_no() %></td>
						<td><%= vo.getName() %></td>
						<td><%= vo.getJumin() %></td>
						<td><%= vo.getId() %></td>					
					</tr>
					<%
				}
			%>
		</tbody>
	</table>
</body>
</html>