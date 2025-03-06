<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
	<table>
		<thead>
			<tr>
				<th>게시판아이디</th>
				<th>게시판명</th>
				<th>게시물수</th> 
			</tr>
		</thead>
		<c:if test="${!empty boardList}">
		<tbody>
			<c:forEach var="board" items="${boardList}">
			<tr>
				<td>${board.bid}</td>			
				<td>${board.bname}</td>			
				<td>${board.bacnt}</td>	
				<c:if test="${!empty sessionScope.ss_mid}">
				<td>
					<input type="button" value="수정"  onclick="location.href='/board/updateBoardForm/${board.bid}';" class="btn btn-outline-primary">&nbsp;
				</td>	
				</c:if>
			</tr>
			</c:forEach>
		</tbody>
		</c:if>
	</table>
		<p>
			<input id="insertBtn" type="button" value="등록" data-mid="${sessionScope.ss_mid}" data-location= "/board/insertBoardForm"  class="btn btn-light">
		</p>
<%@ include file="/jsp/include/footer.jsp" %>