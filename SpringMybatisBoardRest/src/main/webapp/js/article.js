const article = {
	updateArticle: function() {
		const articleForm = $("form[name='articleForm']");
		let aid = articleForm.find("[name='aid']").val();
		if (confirm("수정하시겠습니까?")) {
			axios.put('/article/articles', {
				aid: aid,
				asubject: articleForm.find("[name='asubject']").val(),
				acontent: articleForm.find("[name='acontent']").val(),
			}, {
				headers: {
					'Content-Type': 'application/json'
				}
			}).then(response => {
				if (response.data.result > 0) {
					location.href = "/article/articles/" + aid;
				}
			});
		}
	},
	deleteArticle: function(aid) {
		if (confirm("삭제하시겠습니까?")) {
			axios.delete('/article/articles/' + aid)
				.then(response => {
					if (response.data.result > 0) {
						location.href = "/article/articles";
					}
				});
		}
	}

}

const articleForm = $("form[name='articleForm']");
const asubject = $("form[name='articleForm'] input[name='asubject']");
const aid = $("form[name='articleForm'] input[name='aid']");

$("form[name='articleForm']").on("submit", e => {
	e.preventDefault();
	if (!asubject.val()) {
		alert('제목을 입력해주세요!');
		asubject.focus();s
		return false;
	} else {
		if (aid.val()) {
			article.updateArticle();
		} else {
			// 파일 업로드 처리
			const fileInput = document.querySelector("#fileInput");
			const formData = new FormData();
			for(let file of fileInput.files) {
				formData.append("files", file);
				console.log(file);
			}
			axios.post(
				"/file/fileupload",
				formData,
				{
					headers: {"Content-Type":"multipart/formData"}
				}
			).then(response => {
				console.log(response.data.message);
			});
			//articleForm.off("submit").submit();
		}
	}
});

