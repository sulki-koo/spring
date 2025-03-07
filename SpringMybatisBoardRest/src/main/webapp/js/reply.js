const reply = {
	getReplyList: function(aid, ss_mid) {
		axios.get('/reply/replies/' + aid)
			.then(response => {
				this.printReplyList(response.data, aid, ss_mid);
			})
	},
	deleteReply: function(rid, aid, ss_mid) {
		axios.delete('/reply/replies/' + rid).then(() => this.getReplyList(aid, ss_mid));
	},
	printReplyList: function(data, aid, ss_mid) {
		if (data) {
			let ulHtml = '';
			// 게시글에 맞는 댓글 목록 동적 생성
			for (eachReply of data) {
				const dateStr = `${eachReply.rregdate}`;
				let datePrintStr = dayjs(dateStr).format('YY.MM.DD HH:mm');
				ulHtml += `<li>[${eachReply.mid}]<br>${eachReply.rcontent}<br> ${datePrintStr}&nbsp;`;
				if (eachReply.mid == ss_mid) {
					ulHtml += `<a href="javascript:if(confirm('삭제하시겠습니까?')) reply.deleteReply('${eachReply.rid}', '${aid}', '${ss_mid}')">[삭제]</a></li>`;
				} else {
					ulHtml += `</li>`;
				}
			}
			$('#replyList').html(ulHtml);
		}
	},
	insertReply: function() {
		const insertReplyBtn = document.querySelector("#insertReplyBtn");
		// 댓글 등록시 json 전송
		axios.post('/reply/replies', {
			rcontent: $('input[name="rcontent"]').val(),
			mid: insertReplyBtn.dataset.mid,
			aid: insertReplyBtn.dataset.aid
		}, {
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(response => {
			this.getReplyList(insertReplyBtn.dataset.aid, insertReplyBtn.dataset.mid);
		});
	}
};

$('#insertReplyBtn').click(e => {
	if(!$("input[name='rcontent']").val()) {
		alert('내용을 입력해주세요!');
		$("input[name='rcontent']").focus();
		return false;
	}
	reply.insertReply();
});
