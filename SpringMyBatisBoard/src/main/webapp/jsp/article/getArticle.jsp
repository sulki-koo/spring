<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
<h3>게시물 조회</h3>
<table class="table table-hover">
	<tr>
		<td>아이디</td>
		<td class="text-start">${article.aid}</td>
	</tr>
	<tr>
		<td>게시판</td>
		<td class="text-start">${article.bname}</td>
	</tr>
	<tr>
		<td>제목</td>
		<td class="text-start">${article.asubject}</td>
	</tr>
	<tr>
		<td>내용</td>
		<td class="text-start">${article.acontent}</td>
	</tr>
	<tr>
		<td>조회수</td>
		<td class="text-start">${article.avcnt}</td>
	</tr>
	<tr>
		<td>작성자</td>
		<td class="text-start">${article.mid}</td>
	</tr>
	<tr>
		<td>등록일시</td>
		<td class="text-start"><fmt:formatDate value="${article.aregdate}" pattern="yyyy/M/dd HH:mm:ss" /></td>
	</tr>
	<tr>
		<td>첨부파일수</td>
		<td class="text-start">${article.aafcnt}</td>
	</tr>
</table>
<c:if test="${!empty sessionScope.ss_mid}">
<p class="text-start mt-5 mb-3">
	<input type="text" name="rcontent" class="form-control d-inline-block" style="width: 800px;">&nbsp;
	<input id="insertReplyBtn" type="button" value="댓글 등록"
		data-mid="${sessionScope.ss_mid}" data-aid="${article.aid}" class="btn btn-primary">
</p>
</c:if>
<ul id="replyList" class="list-group list-group-flush"></ul>
<p class="text-end">
	<c:if test="${sessionScope.ss_mid==article.mid}">
		<input type="button" value="수정" onclick="location.href='/updateArticleForm.do?aid=${article.aid}';" class="btn btn-warning">&nbsp;
		<input type="button" value="삭제" onclick="location.href='/deleteArticle.do?aid=${article.aid}';" class="btn btn-danger">&nbsp;
	</c:if>
	<input type="button" value="목록" onclick="location.href='/selectArticle.do';" class="btn btn-success">
</p>
<script>
$(function() {
	board.getReplyList('${article.aid}', '${sessionScope.ss_mid}');	
});
</script>
<%@ include file="/jsp/include/footer.jsp" %>













