const member = {
	updateMember: function() {
		const memberForm = $("form[name='memberForm']");
		axios.put('/member/members', {
			mid: memberForm.find("[name='mid']").val(),
			mname: memberForm.find("[name='mname']").val(),
			malias: memberForm.find("[name='malias']").val(),
			memail: memberForm.find("[name='memail']").val(),
			mcp: memberForm.find("[name='mcp']").val()
		}, {
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(response => {
			if (response.data.result > 0) {
				location.href = "/member/members";
			}
		});
	},
	deleteMember: function(mid) {
		axios.delete('/member/members/' + mid)
			.then(response => {
				if (response.data.result > 0) {
					location.href = "/member/members";
				}
			});
	}
}

const memberForm = $("form[name='memberForm']"); 
const mid = memberForm.find("input[name='mid']");
const mpass = memberForm.find("input[name='mpass']");
const mname = memberForm.find("input[name='mname']");

memberForm.on("submit", e => {
   e.preventDefault();
   if (!mid.val()) {
      alert("아이디를 입력해주세요!");
      mid.focus();
      return false;
   }
   if (mpass.length>0 && !mpass.val()) {
      alert("비밀번호를 입력해주세요!");
      mpass.focus();
      return false;
   }
   if (!mname.val()) {
      alert("이름을 입력해주세요!");
      mname.focus();
      return false;
   }
   if (mpass.length>0) {
      memberForm.off("submit").submit();
   } else {
      member.updateMember();
   }
});