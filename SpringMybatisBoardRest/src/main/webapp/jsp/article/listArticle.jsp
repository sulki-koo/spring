<%@ page contentType="text/html; charset=UTF-8"%>

	<%@ include file="/jsp/include/header.jsp" %>
		<form action="/selectArticle.do" method="post">
		<select name="searchBoard" class="form-select" aria-label="Default select example">
			<option value="" <c:if test="${empty searchBoard}">selected</c:if>>게시판</option>
		</select>&nbsp;
		<select name="searchClass">
			<option <c:if test="${empty searchClass}">selected</c:if>>분류/전체</option>
			<option value="asubject" <c:if test="${searchClass=='asubject'}">selected</c:if>>제목</option>
			<option value="acontent" <c:if test="${searchClass=='acontent'}">selected</c:if>>내용</option>
			<option value="mid" <c:if test="${searchClass=='mid'}">selected</c:if>>작성자아이디</option>
		</select>&nbsp;
		<input type="text" name="searchVal" value="${searchVal}">&nbsp;
		<input type="submit" value="검색"  class="btn btn-info">
		<input id="insertBtn" type="button" value="등록" data-mid="${sessionScope.ss_mid}" data-location="/insertArticleForm.do"  class="btn btn-light">
		</form>
	<table>
		<tr>
			<th>게시물아이디</th>
			<th>게시판</th>
			<th>제목</th>
			<th>조회수</th>
			<th>작성자</th>
			<th>등록일시</th>
			<th>댓글수</th>
			<th>첨부파일수</th>
		</tr>
		<c:forEach var="article" items="${articleList}">
			<tr>
				<td>${article.aid}</td>
				<td>${article.bname}</td>
				<td><a href='getArticle.do?aid=${article.aid}';">${article.asubject}</a></td>
				<td>${article.avcnt}</td>
				<td>${article.mid}</td>
				<td><fmt:formatDate value="${article.aregdate}" pattern="YY.MM.dd  HH:mm"/></td>
				<td>${article.arcnt}</td>
				<td>${article.aafcnt}</td>
			</tr>
		</c:forEach>
	</table>
<script>
	$(function() {
   		board.getBoardList("${searchBoard}");
	});
</script>
<%@ include file="/jsp/include/footer.jsp" %>
