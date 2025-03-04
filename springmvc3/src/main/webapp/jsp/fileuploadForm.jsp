<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fileuploadForm</title>
</head>
<body>
	<form action="/fileupload/fileuploadProc.do" method="post" enctype="multipart/form-data">
		제목 : <input type="text" name="title"><br>
		첨부파일 : <input type="file" name="uploadFile"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>