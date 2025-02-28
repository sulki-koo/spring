<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
<h3>회원수정</h3>
<form action="/updateMember.do" method="post">
<input type="hidden" name="mid" value="${member.mid}">
<table class="table table-hover">
	<tr>
		<td>아이디	</td>
		<td class="text-start">${member.mid}</td>
	</tr>
	<tr>
		<td>	성명</td>
		<td class="text-start"><input type="text" name="mname" value="${member.mname}" class="form-control d-inline-block"></td>
	</tr>
	<tr>
		<td>별칭	</td>
		<td class="text-start"><input type="text" name="malias" value="${member.malias}" class="form-control d-inline-block"></td>
	</tr>
	<tr>
		<td>	이메일</td>
		<td class="text-start"><input type="text" name="memail" value="${member.memail}" class="form-control d-inline-block"></td>
	</tr>
	<tr>
		<td>	전화번호</td>
		<td class="text-start"><input type="text" name="mcp" value="${member.mcp}" class="form-control d-inline-block"></td>
	</tr>
</table>
<p class="text-end">
	<input type="button" value="목록" onclick="location.href='/selectMember.do';" class="btn btn-success">&nbsp;
	<input type="submit" value="수정" class="btn btn-warning">
</p>
</form>
<%@ include file="/jsp/include/footer.jsp" %>