<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--<c:set var="dto" value="${articleDTO}" />-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="deleteAction" method="post">
<table>
<caption>게시물 삭제</caption>
<tr>
	<th>번호</th>
	<td>${no}<input type="hidden" name="no" value="${no}" /></td>
</tr>

<tr>
	<th>비밀번호</th>
	<td><input type="password" name="password" required="required" autofocus="autofocus"/><br/>
		일치하면 삭제가능
	</td>
</tr>

<tr>
	<td colspan="2" align="center"><input type="submit" value="완료" /></td>
</tr>
</table>
</form>
</body>
</html>