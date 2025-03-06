const board = {
	getReplyList: function(aid, ss_mid) {
		axios.get('/listReply/' + aid)
			.then(response => {
				this.printReplyList(response.data, aid, ss_mid);
			})
	},
	deleteReply: function(rid, aid, ss_mid) {
		axios.get('/deleteReply/' + rid).then(() => this.getReplyList(aid, ss_mid));
	},
	printReplyList: function(data, aid, ss_mid) {
		if (data) {
			let ulHtml = '';
			for (reply of data) {
				if (aid == reply.aid) {
					const dateStr = `${reply.rregdate}`;
					let datePrintStr = dayjs(dateStr).format('YY.MM.DD HH:mm');
					ulHtml += `<li>[${reply.mid}]<br>${reply.rcontent}<br> ${datePrintStr}&nbsp;`;
					if (reply.mid == ss_mid) {
						ulHtml += `<a href="javascript:board.deleteReply('${reply.rid}', '${aid}', '${ss_mid}')">[삭제]</a></li>`;
					} else {
						ulHtml += `</li>`;
					}
				}
			}
			$('#replyList').html(ulHtml);
		}
	},
	insertReply : function() {
		const insertReplyBtn = document.querySelector("#insertReplyBtn");
		axios.post('/insertReply', {
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
	},
	getBoardList: function(searchBoard) {
		axios.get('/board/boardJson').then(
			response => {
				this.printBoardList(response.data, searchBoard);
			});
	},
	printBoardList : function(data, searchBoard){
		if(data) {
			let selectHtml ='';
			let selected = '';
					// 가장 첫 번째 게시판을 selected 상태로 설정
			        if (data.length > 0) {
			            // 첫 번째 게시판을 selected로 설정
			            selected = "selected"; 
			            selectHtml += `<option value='${data[0].bid}' ${selected}>${data[0].bname}</option>`;
			        }

			        // 나머지 게시판들을 추가
			        for (let i = 1; i < data.length; i++) {
			            selected = (data[i].bid == searchBoard) ? "selected" : ""; // 기존 선택된 게시판 상태 유지
			            selectHtml += `<option value='${data[i].bid}' ${selected}>${data[i].bname}</option>`;
			        }
			$("select[name='searchBoard']").append(selectHtml);
		}
	}, 
	updateBoard: function(){
		const updateBoardForm = $("form[name='updateBoardForm']");
		axios.put('/board/boards', {
			bid: updateBoardForm.find("[name='bid']").val(),
			bname: updateBoardForm.find("[name='bname']").val(),
		}, {
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(response => {
			if(response.data.result>0){
				location.href="/board/boards";
			}
		});
	}
};

const check = {
	checkLogin: function(mid) {
		if (mid) return true;
		else {
			alert('회원 전용 서비스입니다.\n로그인 후 이용 부탁드립니다.');
			return false;
		}
	}
};

$('#insertBtn').click(e => {
	if (check.checkLogin(e.target.dataset.mid)) {
		location.href = e.target.dataset.location;
	}
});

$('#insertReplyBtn').click(e => {
	board.insertReply();
});

$('#updateBtn').click(e => {
	if (e.target.dataset.mid === e.target.dataset.ssmid) {
		location.href = e.target.dataset.location;
	} else {
		alert('권한이 없습니다.');
	}
});
$('#deleteBtn').click(e => {
	if (e.target.dataset.mid === e.target.dataset.ssmid) {
		article.deleteArticle(e.target.dataset.aid);
	} else {
		alert('권한이 없습니다.');
	}
});

const member = {
	updateMember: function(){
		const updateMemberForm = $("form[name='updateMemberForm']");
		axios.put('/member/members', {
			mid: updateMemberForm.find("[name='mid']").val(),
			mname: updateMemberForm.find("[name='mname']").val(),
			malias: updateMemberForm.find("[name='malias']").val(),
			memail: updateMemberForm.find("[name='memail']").val(),
			mcp: updateMemberForm.find("[name='mcp']").val()
		}, {
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(response => {
			if(response.data.result>0){
				location.href="/member/members";
			}
		});
	},
	deleteMember: function(mid){
		axios.delete('/member/members/'+mid)
		.then(response => {
			if(response.data.result>0){
				location.href="/member/members";
			}
		});
	}
}

$("form[name='updateMemberForm']").on("submit", e => {
	e.preventDefault();
	member.updateMember();
});

$("form[name='updateBoardForm']").on("submit", e => {
	e.preventDefault();
	board.updateBoard();
});


const article = {
	updateArticle: function(){
		const updateArticleForm = $("form[name='updateArticleForm']");
		let aid = updateArticleForm.find("[name='aid']").val();
		axios.put('/article/articles', {
			aid: aid,
			asubject: updateArticleForm.find("[name='asubject']").val(),
			acontent: updateArticleForm.find("[name='acontent']").val(),
		}, {
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(response => {
			if(response.data.result>0){
				location.href="/article/articles/"+aid;
			}
		});
	},
	deleteArticle: function(aid){
		axios.delete('/article/articles/'+aid)
		.then(response => {
			if(response.data.result>0){
				location.href="/article/articles";
			}
		});
	}
}

$("form[name='updateArticleForm']").on("submit", e => {
	e.preventDefault();
	article.updateArticle();
});