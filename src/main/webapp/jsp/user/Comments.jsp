<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	<h1>qqqq</h1>
		<c:forEach items="${list}" var="u">
			<tr>
				<td>${u.id }</td>
				<td>${user_id }</td>
				<td>${user_com }</td>
				<td>${product_id}</td>
				<td>${state }</td>
				<td>${com_grade }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>