<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getPerson</title>
</head>
<body>
	이름 : ${person.name}<br>
	나이 : ${person.age}<br>
	<input type="button" value="목록" onclick="location.href='/person/listPerson.do';">
</body>
</html>