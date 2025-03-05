<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>별칭</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>삭제여부</th>
			</tr>
		</thead>
		<c:if test="${!empty memberList}">
		<tbody>
			<c:forEach var="member" items="${memberList}">
			<tr>
				<td> <a href='getMember?mid=${member.mid}';">${member.mid}</a></td>			
				<td>${member.mname}</td>			
				<td>${member.malias}</td>			
				<td>${member.memail}</td>			
				<td>${member.mcp}</td>			
				<td>${member.mdelyn}</td>
				<c:if test="${sessionScope.ss_mid==member.mid}">
				<td>
					<input type="button" value="수정"  onclick="location.href='/updateMemberForm?mid=${member.mid}';" class="btn btn-outline-primary">&nbsp;
					<input type="button" value="삭제" onclick="location.href='/deleteMember?mid=${member.mid}';" class="btn btn-outline-primary">
				</td>
				</c:if>
			</tr>
			</c:forEach>
		</tbody>
		</c:if>
	</table>
<%@ include file="/jsp/include/footer.jsp" %>