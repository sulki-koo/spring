<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
<h3>게시판목록</h3>
<p class="text-end">
	<input id="insertBtn" type="button" value="등록" 
		data-mid="${sessionScope.ss_mid}" data-location="/insertBoardForm.do" class="btn btn-primary">
</p>
<table class="table table-hover">
	<thead>
		<tr>
			<th>아이디</th>
			<th>게시판명</th>
			<th>게시물수</th>
			<th>수정/삭제</th>
		</tr>
	</thead>
	<c:if test="${!empty boardList}">
	<tbody>
		<c:forEach var="board" items="${boardList}">
		<tr>
			<td>${board.bid}</td>
			<td>${board.bname}</td>
			<td>${board.bacnt}</td>
			<td>
				<input type="button" value="수정" onclick="location.href='/updateBoardForm.do?bid=${board.bid}';" class="btn btn-warning">&nbsp;
				<input type="button" value="삭제" onclick="location.href='/deleteBoard.do?bid=${board.bid}';" class="btn btn-danger">
			</td>
		</tr>
		</c:forEach>
	</tbody>
	</c:if>
</table>
<%@ include file="/jsp/include/footer.jsp" %>