<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
<h3>회원가입</h3>
<form action="/insertMember.do" method="post">
<table class="table table-hover">
	<tr>
		<td>아이디	</td>
		<td class="text-start"><input type="text" name="mid" class="form-control d-inline-block"></td>
	</tr>
	<tr>
		<td>	비밀번호</td>
		<td class="text-start"><input type="password" name="mpass" class="form-control d-inline-block"></td>
	</tr>
	<tr>
		<td>	성명</td>
		<td class="text-start"><input type="text" name="mname" class="form-control d-inline-block"></td>
	</tr>
	<tr>
		<td>별칭	</td>
		<td class="text-start"><input type="text" name="malias" class="form-control d-inline-block"></td>
	</tr>
	<tr>
		<td>	이메일</td>
		<td class="text-start"><input type="text" name="memail" class="form-control d-inline-block"></td>
	</tr>
	<tr>
		<td>	전화번호</td>
		<td class="text-start"><input type="text" name="mcp" class="form-control d-inline-block"></td>
	</tr>
</table>
<p class="text-end">
	<input type="button" value="목록" onclick="location.href='/selectMember.do';" class="btn btn-success">&nbsp;
	<input type="submit" value="등록" class="btn btn-primary">
</p>
</form>
<%@ include file="/jsp/include/footer.jsp" %>