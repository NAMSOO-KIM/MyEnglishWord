<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" sizes="16x16" href="/xciweb01/img/favicon16.png" > 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<caption>게시물 리스트</caption>
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>이름</th>
	<th>날짜</th>
	<th>조회수</th>
</tr>
<c:forEach var="dto" items="${list}">
<tr>
	<td>${dto.no}</td>
	<td><a href="detail?no=${dto.no}">${dto.title}</a></td>
	<td>${dto.name}</td>
	<td>${dto.regdate}</td>
	<td>${dto.readcount}</td>
</tr>
</c:forEach>
</table>
<a href="insert">글쓰기</a>
</body>
</html>