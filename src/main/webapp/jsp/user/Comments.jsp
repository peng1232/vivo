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
    <h1>评论列表</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>用户ID</th>
            <th>评论内容</th>
            <th>产品ID</th>
            <th>状态</th>
            <th>评论等级</th>
        </tr>
        <c:forEach items="${commentsList}" var="comment">
            <tr>
                <td>${comment.id}</td>
                <td>${comment.user_id}</td>
                <td>${comment.user_com}</td>
                <td>${comment.product_id}</td>
                <td>${comment.state}</td>
                <td>${comment.com_grade}</td>
            </tr>
        </c:forEach>
    </table>
    <c:if test="${commentsList==null}">
    	<script type="text/javascript">
    		location.href = "CommentsServlet";
    	</script>
    </c:if>
</body>
</html>