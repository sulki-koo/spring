const article = {
	updateArticle: function() {
		const articleForm = $("form[name='articleForm']");
		let aid = articleForm.find("[name='aid']").val();
		if (confirm("수정하시겠습니까?")) {
			axios.put('/article/articles', {
				aid: aid,
				asubject: articleForm.find("[name='asubject']").val(),
				acontent: articleForm.find("[name='acontent']").val(),
				bid: articleForm.find("[name='bid']").val()
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
	},
	selectAttachFile: function(aid, pageType) {
		axios.get('/file/selectAttachFile/' + aid)
			.then(response => {
				this.printAttachFile(response.data, pageType);
			});
	},
	printAttachFile: function(data, pageType) {
		if (data.length>0) {
			let fileListHtml = '';
			for (eachAttachFile of data) {
				let actionLink = '';
				if(pageType=='getArticle'){
					actionLink = `<a href='/file/filedownload/${eachAttachFile.afid}'>[다운로드]</a>`;
				} else if (pageType=='updateArticleForm'){
					actionLink = `<a href='javascript:if(confirm("삭제하시겠습니까?")) article.deleteAttachFile("${eachAttachFile.aid}", "${eachAttachFile.afid}")'>[삭제]</a>`;
				}
				fileListHtml += `<li>${eachAttachFile.afcname} ${actionLink}</li>`;
			}
			$("#attachFiles").html(fileListHtml);
		}else{
			$("#attachFiles").html('<li>첨부파일이 없습니다.</li>');
		}
	},
	deleteAttachFile: function(aid, afid) {
		axios.delete('/file/deleteAttachFile/'+afid)
		.then(response => {
			this.selectAttachFile(aid, 'updateArticleForm');
		});
	}

}

const articleForm = $("form[name='articleForm']");
const asubject = $("form[name='articleForm'] input[name='asubject']");
const aid = $("form[name='articleForm'] input[name='aid']");

$("form[name='articleForm']").on("submit", e => {
	e.preventDefault();
	if (!asubject.val()) {
		alert('제목을 입력해주세요!');
		asubject.focus(); s
		return false;
	} else {
		// 파일 업로드 처리
			const fileInput = document.querySelector("#fileInput");
			const formData = new FormData();
			for (let file of fileInput.files) {
				formData.append("files", file);
				console.log(file);
			}
			axios.post(
				"/file/fileupload",
				formData,
				{
					headers: { "Content-Type": "multipart/formData" }
				}
			).then(response => {
				console.log(response.data.message);
			});
		if (aid.val()) {
			article.updateArticle();
		} else {
			//articleForm.off("submit").submit();
		}
	}
});

