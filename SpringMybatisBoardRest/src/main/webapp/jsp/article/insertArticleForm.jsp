<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
	<h3>${sessionScope.ss_mid}님 게시물등록</h3>
	<form action="/insertArticle.do" method="post">
		<input type="hidden" name="mid" value="${sessionScope.ss_mid}">
		<div class="row">
			  <div class="col">
				  <select name="searchBoard" class="form-select" aria-label="Default select example"></select>&nbsp;
			  </div>
			  <input type="hidden" name="bid" id="selectedBid" value="1">
			  <div class="col">
			    <input type="text" name="asubject" class="form-control" placeholder="제목" aria-label="제목">
			  </div>
		</div>
		<div class="form-floating">
 			 <textarea name="acontent" class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px"></textarea>
  			<label for="floatingTextarea2">Comments</label>
		</div>
	<input type="submit" value="등록" class="btn btn-outline-primary">
	<input type="button" value="취소" onclick="location.href='/selectArticle.do';" class="btn btn-outline-primary">
	</form>
<script>
	$(function() {
   		board.getBoardList("${searchBoard}");
   		
   		$("select[name='searchBoard']").change(e =>{
   			let selectedBid = $(this).find('option:selected').val();
   			$('#selectedBid').val(selectedBid);
   		});
	});
</script>
<%@ include file="/jsp/include/footer.jsp" %>