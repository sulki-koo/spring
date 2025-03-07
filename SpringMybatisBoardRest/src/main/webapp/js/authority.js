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