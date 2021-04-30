<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello</h1>
<form action="registerAction" method="post">


<table>
<caption>회원가입</caption>
<tr>
	<th>아이디</th>
	<td><input type="text" name="user_id" autofocus="autofocus" required="required"/></td>
</tr>
<tr>
	<th>비밀번호</th>
	<td><input type="text" name="password" required="required"/></td>
	
</tr>
	
<tr>
	<th>이름</th>
	<td><input type="text" name="name" required="required"/></td>
	
</tr>


<tr>
	<td colspan="2" align="center"><input type="submit" value="완료" /></td>
</tr>
</table>

<!-- </form> -->
</body>
</html>