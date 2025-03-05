<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
	<h3>제목 : ${article.asubject}</h3>
	<table id="article">
		<tbody>
			<tr>
				<td>게시물아이디</td>
				<td>${article.aid}</td>
			</tr>
			<tr>
				<td>게시판</td>
				<td>${article.bname}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${article.avcnt}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${article.mid}</td>
			</tr>
			<tr>
				<td>등록일시</td>
				<td><fmt:formatDate value="${article.aregdate}" pattern="M월 dd일 HH:mm"/></td>
			</tr>
			<tr>
				<td>첨부파일수</td>
				<td>${article.aafcnt}</td>
			</tr>
		</tbody>
	</table>
	<p>
		<input id="updateBtn"  type="button" value="수정" data-mid="${article.mid}" data-ssmid="${sessionScope.ss_mid}" data-location="/updateArticleForm.do?aid=${article.aid}" class="btn btn-outline-primary">&nbsp;
		<input id="deleteBtn"  type="button" value="삭제" data-mid="${article.mid}"  data-ssmid="${sessionScope.ss_mid}" data-location="/deleteArticle.do?aid=${article.aid}" class="btn btn-outline-primary">&nbsp;
		<input type="button" value="목록" onclick="location.href='/selectArticle.do';" class="btn btn-outline-primary">
	</p>
		<table id="content">
			<tr>
				<td>내용</td>
			</tr>
			<tr>
				<td>${article.acontent}</td>
			</tr>
		</table>
	<br><br>
	<c:if test="${!empty sessionScope.ss_mid }">
	<p>
		[${sessionScope.ss_mid}님 댓글등록] 내용 : <input type="text" name="rcontent"> 
		<input id="insertReplyBtn" type="button" value="등록" data-mid="${sessionScope.ss_mid}" data-aid="${article.aid}" class="btn btn-light">
	</p>
	</c:if>
	<ul id="replyList">
		<li></li>
	</ul>
	<script>
		$(function() {
			board.getReplyList('${article.aid}', '${sessionScope.ss_mid}' );
		});
	</script>
<%@ include file="/jsp/include/footer.jsp" %>