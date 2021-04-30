  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:redirect url="myword/register" />


<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>하잉!!!</h1>
<%
	response.sendRedirect("myword/register");
	//response.sendRedirect("myword/crawler"); //크롤링 테슽크
%>
</body>
</html>