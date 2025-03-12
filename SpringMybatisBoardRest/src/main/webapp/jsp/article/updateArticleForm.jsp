<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
	<h3>게시물아이디 : ${article.aid} 수정</h3><br>
	<form name="articleForm">
		<input type="hidden" name="mid" value="${sessionScope.ss_mid}">
		<input type="hidden" name="aid" value="${article.aid}">
		<div class="row">
			  <div class="col">
				  <select name="bid" class="form-select" aria-label="Default select example"></select>&nbsp;
			  </div>
			  <div class="col">
			    <input type="text" name="asubject" value="${article.asubject}" class="form-control" placeholder="${article.asubject}" aria-label="${article.asubject}">
			  </div>
		</div>
		<div class="form-floating">
 			 <textarea name="acontent" class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px">${article.acontent}</textarea>
  			<label for="floatingTextarea2">Comments</label>
		</div>
		<ul id="attachFiles"></ul>
		<div class="row">
			  <div class="col">
			    <input type="file" id="fileInput" multiple class="form-control" placeholder="파일" aria-label="파일">
			  </div>
			  <div class="col">
				<input type=button value="수정" onclick="article.updateArticle();" class="btn btn-outline-primary">
				<input type="button" value="목록"	onclick="location.href='/article/articles';" class="btn btn-outline-primary">
			</div>
		</div>
	</form>
	<script>
		$(function() {
			article.selectAttachFile('${article.aid}', 'updateArticleForm');
			board.getBoardList("${article.bid}");
		});
	</script>	
<%@ include file="/jsp/include/footer.jsp" %>