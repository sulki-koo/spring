<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>listPerson</title>
</head>
<body>
	<c:forEach var="person" items="${ personList}">
		이름 : <a href="/person/getPerson.do?name=${person.name}&age=${person.age}">${person.name}</a>, 나이 : ${ person.age }<br>
	</c:forEach>
	<a href="/person/writeForm.do">등록</a><br>
</body>
</html>