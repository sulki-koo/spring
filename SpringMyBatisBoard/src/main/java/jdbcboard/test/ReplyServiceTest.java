package jdbcboard.test;

import jdbcboard.service.ReplyService;
import jdbcboard.service.impl.ReplyServiceImpl;

public class ReplyServiceTest {
	
	public static void main(String[] args) {
		
		ReplyService replyService = ReplyServiceImpl.getReplyServiceImpl();
		
		// insert
//		Reply reply = new Reply(0, "댓글내용", null, "N", "hong", 1);
//		int result = replyService.insertReply(reply);
//		if (result>0) {
//			System.out.println("등록 성공!");
//		}
		
		// update
//		Reply reply = new Reply(1, "(수정)댓글내용", null, "N", "hong", 1);
//		int result = replyService.updateReply(reply);
//		if (result>0) {
//			System.out.println("수정 성공!");
//		}
		
		// delete
//		int result = replyService.deleteReply(3);
//		if (result>0) {
//			System.out.println("삭제 성공!");
//		}
		
		// select
//		List<Reply> replyList = replyService.selectReply();
//		for (Reply reply : replyList) {
//			System.out.println(reply);
//		}
		
		// get
//		Reply reply = replyService.getReply(1);
//		System.out.println(reply);
		
	}

}













