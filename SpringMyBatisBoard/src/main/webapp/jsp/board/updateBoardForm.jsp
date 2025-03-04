<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
<h3>게시판수정</h3>
<form action="/updateBoard.do" method="post">
<input type="hidden" name="bid" value="${board.bid}">
<table class="table table-hover">
	<tr>
		<td>게시판명</td>
		<td class="text-start"><input type="text" name="bname" value="${board.bname}" class="form-control d-inline-block" style="width: 250px"></td>
	</tr>
</table>
<p class="text-end">
	<input type="button" value="목록" onclick="location.href='/selectBoard.do';" class="btn btn-success">&nbsp;
	<input type="submit" value="수정" class="btn btn-warning">
</p>
</form>
<%@ include file="/jsp/include/footer.jsp" %>