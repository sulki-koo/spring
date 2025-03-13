<%@ page contentType="text/html; charset=UTF-8"%>

	<%@ include file="/jsp/include/header.jsp" %>
		<form name="articleSearchForm" action="/article/articles">
			<input type="hidden" name="pageNum" />
			<input type="hidden" name="pageSize" />
			<select name="bid" class="form-select" aria-label="Default select example">
				<option value="" <c:if test="${empty articleCriteria.bid}">selected</c:if>>게시판</option>
			</select>&nbsp;
			<select name="searchClass">
				<option <c:if test="${empty articleCriteria.searchClass}">selected</c:if>>분류/전체</option>
				<option value="asubject" <c:if test="${articleCriteria.searchClass=='asubject'}">selected</c:if>>제목</option>
				<option value="acontent" <c:if test="${articleCriteria.searchClass=='acontent'}">selected</c:if>>내용</option>
				<option value="mid" <c:if test="${articleCriteria.searchClass=='mid'}">selected</c:if>>작성자아이디</option>
			</select>&nbsp;
			<input type="text" name="searchVal" value="${articleCriteria.searchVal}">&nbsp;
			<input type="button" onclick="article.selectArticle('1', '${articleCriteria.pageSize}');" value="검색"  class="btn btn-info">
			&nbsp;&nbsp;등록된 게시물 : ${articleCriteria.totalRowCount}&nbsp;&nbsp;
			<input id="insertBtn" type="button" value="등록" data-mid="${sessionScope.ss_mid}" data-location="/article/insertArticleForm"  class="btn btn-light">
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
				<td><a href='articles/${article.aid}';">${article.asubject}</a></td>
				<td>${article.avcnt}</td>
				<td>${article.mid}</td>
				<td><fmt:formatDate value="${article.aregdate}" pattern="YY.MM.dd  HH:mm"/></td>
				<td>${article.arcnt}</td>
				<td>${article.aafcnt}</td>
			</tr>
		</c:forEach>
	</table>
	
	    <!-- 페이징 처리 -->
        <ul class="pagination">
            <c:if test="${articleCriteria.pageNum > 1}">
                <li class="page-item">
                    <a class="page-link"  href="javascript:article.selectArticle('${articleCriteria.pageNum - 1}', '${articleCriteria.pageSize}');">이전</a>
                </li>
            </c:if>
            <c:forEach var="i" begin="1" end="${articleCriteria.totalPageCount}">
                <li class="page-item ${i == articleCriteria.pageNum ? 'active' : ''}">
                    <a class="page-link" href="javascript:article.selectArticle('${i}', '${articleCriteria.pageSize}');">${i}</a>
                </li>
            </c:forEach>
            <c:if test="${articleCriteria.pageNum < articleCriteria.totalPageCount}">
                <li class="page-item">
                    <a class="page-link" href="javascript:article.selectArticle('${articleCriteria.pageNum + 1}', '${articleCriteria.pageSize}');">다음</a>
                </li>
            </c:if>
        </ul>
	
<script>
	$(function() {
   		board.getBoardList("${articleCriteria.bid}");
	});
</script>
<%@ include file="/jsp/include/footer.jsp" %>
