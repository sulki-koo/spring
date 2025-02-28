<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
<h3>게시판등록</h3>
<form action="/insertBoard.do" method="post">
<table class="table table-hover">
	<tr>
		<td>게시판명</td>
		<td class="text-start"><input type="text" name="bname" class="form-control d-inline-block" style="width: 250px"></td>
	</tr>
</table>
<p class="text-end">
	<input type="button" value="목록" onclick="location.href='/selectBoard.do';" class="btn btn-success">&nbsp;
	<input type="submit" value="등록" class="btn btn-primary">
</p>
</form>
<%@ include file="/jsp/include/footer.jsp" %>