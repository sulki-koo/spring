const board = {
	getBoardList: function(bid) {
		axios.get('/board/boardJson').then(
			response => {
				this.printBoardList(response.data, bid);
			});
	},
	printBoardList: function(data, bid) {
		if (data) {
			let selectHtml = '';
			let selected = '';
			// 게시물페이지 게시판 목록 동적 생성
			for (let i = 0; i < data.length; i++) { // 나머지 게시판들을 추가
				selected = (data[i].bid == bid) ? "selected" : ""; // 기존 선택된 게시판 상태 유지
				selectHtml += `<option value='${data[i].bid}' ${selected}>${data[i].bname}</option>`;
			}
			$("select[name='bid']").append(selectHtml);
		}
	},
	updateBoard: function() {
		const boardForm = $("form[name='boardForm']");
		if (confirm("수정하시겠습니까?")) {
			axios.put('/board/boards', {
				bid: boardForm.find("[name='bid']").val(),
				bname: boardForm.find("[name='bname']").val(),
			}, {
				headers: {
					'Content-Type': 'application/json'
				}
			}).then(response => {
				if (response.data.result > 0) {
					location.href = "/board/boards";
				}
			});
		}
	}
};

const boardForm = $("form[name='boardForm']");
const bname = $("form[name='boardForm'] input[name='bname']");
const bid = $("form[name='boardForm'] input[name='bid']");

boardForm.on("submit", e => {
	e.preventDefault();
	if (!bname.val()) {
		alert("게시판명을 입력해주세요!");
		bname.focus();
		return false;
	} else {
		if (bid.val()) {
			board.updateBoard();
		} else {
			boardForm.off("submit").submit();
		}
	}
});


