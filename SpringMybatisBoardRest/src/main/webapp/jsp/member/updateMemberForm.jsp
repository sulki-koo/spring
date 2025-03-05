<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
	<h3>${member.mid}님의 회원정보수정</h3><br>
	<form action="/updateMember.do" method="post">
		<input type="hidden" name="mid" value="${member.mid}">
		<div class="row">
			  <div class="col">
			  	<label for="inputName" class="form-label">Name</label>
			    <input type="text" name="mname" value="${member.mname}" class="form-control" placeholder="${member.mname}" aria-label="${member.mname}">
			  </div>
			  <div class="col">
			  	<label for="inputAlias" class="form-label">별칭</label>
			    <input type="text" name="malias" value="${member.malias}" class="form-control" placeholder="${member.malias}" aria-label="${member.malias}">
			  </div>
		</div>
		<div class="row">
			  <div class="col">
			  <label for="inputHp" class="form-label">H.P</label>
			    <input type="text" name="mcp" value="${member.mcp}" class="form-control" placeholder="${member.mcp}" aria-label="${member.mcp}">
			  </div>
			   <div class="col">
			  <label for="inputEmail4" class="form-label">E-Mail</label>
			    <input type="text" name="memail"  value="${member.memail}" class="form-control" placeholder="${member.memail}" aria-label="${member.memail}">
			  </div>
		</div>
	<input type="submit" value="수정" class="btn btn-outline-primary">
	<input type="button" value="목록"	onclick="location.href='/selectMember.do';" class="btn btn-outline-primary">
	</form>
<%@ include file="/jsp/include/footer.jsp" %>