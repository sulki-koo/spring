<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
<h3>게시물 수정</h3>
<form action="/updateArticle.do" method="post">
<input type="hidden" name="aid" value="${article.aid}">
<table class="table table-hover">
	<tr>
		<td>게시판</td>
		<td class="text-start">
			<select name="bid" class="form-select d-inline-block w-auto"></select>
		</td>
	</tr>
	<tr>
		<td>제목</td>
		<td class="text-start"><input type="text" value="${article.asubject}" name="asubject" class="form-control d-inline-block w-60"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td class="text-start"><textarea rows="10" cols="120" name="acontent" class="form-control d-inline-block w-auto">${article.acontent}</textarea></td>
	</tr>
</table>
<p class="text-end">
	<input type="submit" value="수정" class="btn btn-primary">&nbsp;
	<input type="button" value="목록" onclick="location.href='/selectArticle.do';" class="btn btn-success">
</p>
</form>
<script>
$(function() {
	board.getBoardList("${searchBoard}");
});
</script>
<%@ include file="/jsp/include/footer.jsp" %>