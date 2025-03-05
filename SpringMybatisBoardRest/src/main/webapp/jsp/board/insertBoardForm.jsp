<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
	<h3>게시판등록</h3>
	<form action="/insertBoard.do" method="post">
		게시판명 : <input type="text" name="bname"><br><br>
	<input type="submit" value="등록" class="btn btn-outline-primary">
	<input type="button" value="취소" onclick="location.href='/selectBoard.do';" class="btn btn-outline-primary">
	</form>
<%@ include file="/jsp/include/footer.jsp" %>