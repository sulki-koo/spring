<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
	<h3>게시물아이디 : ${article.aid} 수정</h3><br>
	<form action="/updateArticle.do" method="post">
		<input type="hidden" name="aid" value="${article.aid}">
		<div class="row">
			  <div class="col">
			    <input type="text" name="asubject" value="${article.asubject}" class="form-control" placeholder="${article.asubject}" aria-label="${article.asubject}">
			  </div>
		</div>
		<div class="form-floating">
 			 <textarea name="acontent" class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px">${article.acontent}</textarea>
  			<label for="floatingTextarea2">Comments</label>
		</div>
	<input type="submit" value="수정" class="btn btn-outline-primary">
	<input type="button" value="목록"	onclick="location.href='/selectArticle.do';" class="btn btn-outline-primary">
	</form>
<%@ include file="/jsp/include/footer.jsp" %>