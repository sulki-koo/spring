<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
<h3>회원정보</h3>
<table class="table table-hover">
	<tr>
		<td>아이디</td>
		<td>${member.mid}</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${member.mname}</td>
	</tr>
	<tr>
		<td>별칭</td>
		<td>${member.malias}</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>${member.memail}</td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td>${member.mcp}</td>
	</tr>
	<tr>
		<td>삭제여부</td>
		<td>${member.mdelyn}</td>
	</tr>
</table>
<p class="text-end">
	<input type="button" value="목록" onclick="location.href='/selectMember.do';" class="btn btn-success">
</p>
<%@ include file="/jsp/include/footer.jsp" %>