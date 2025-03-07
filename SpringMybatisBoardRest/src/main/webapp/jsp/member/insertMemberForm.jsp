<%@ page contentType="text/html; charset=UTF-8"%>

	<%@ include file="/jsp/include/header.jsp" %>
	<h3>회원가입</h3>
	<form name="memberForm" action="/member/members" method="post">
		<div class="row">
			  <div class="col">
			    <input type="text" name="mname" class="form-control" placeholder="name" aria-label="name">
			  </div>
			  <div class="col">
			    <input type="text" name="malias" class="form-control" placeholder="별칭" aria-label="별칭">
			  </div>
		</div>
		<div class="row">
			<div class="col">
				<label for="inputId4" class="form-label">ID</label>
			    <input type="text" name="mid" class="form-control" placeholder="ID" aria-label="ID">
			  </div>
			  <div class="col">
			  <label for="inputPassword4" class="form-label">Password</label>
			    <input type="password" name="mpass" class="form-control" placeholder="Password" aria-label="Password">
			  </div>
		</div>
		<div class="row">
			  <div class="col">
			  <label for="inputHp" class="form-label">H.P</label>
			    <input type="text" name="mcp" class="form-control" placeholder="H.P" aria-label="H.P">
			  </div>
			   <div class="col">
			  <label for="inputEmail4" class="form-label">E-Mail</label>
			    <input type="text" name="memail" class="form-control" placeholder="e-mail" aria-label="e-mail">
			  </div>
		</div>
	<input type="submit" value="등록" class="btn btn-outline-primary">
	<input type="button" value="취소" onclick="location.href='/member/members';" class="btn btn-outline-primary">
	</form>
<%@ include file="/jsp/include/footer.jsp" %>