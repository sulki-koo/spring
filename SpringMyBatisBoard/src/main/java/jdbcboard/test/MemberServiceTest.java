package jdbcboard.test;


import java.util.List;

import jdbcboard.model.Member;
import jdbcboard.service.MemberService;
import jdbcboard.service.impl.MemberServiceImpl;

public class MemberServiceTest {
	
	public static void main(String[] args) {
		
		MemberService memberService = MemberServiceImpl.getMemberServiceImpl();
		
		// insert test		
//		Member member = new Member("hong3", "홍길동", "홍장군", "1234", "hong@hong.com", "010-1234-5678", "N");
//		int result = memberService.insertMember(member);
//		if (result>0) {
//			System.out.println("입력 성공!");
//		}

		// select test
//		System.out.println(memberService.selectMember()); 
		
		// get test
//		System.out.println(memberService.getMember("hong"));
		
		// update test
//		Member member = new Member("hong", "홍길순", "홍공주", "1234", "hong@hong.com", "010-1234-5678", "N");
//		int result = memberService.updateMember(member);
//		if (result>0) {
//			System.out.println("수정 성공!");
//		}
		
		// delete test
//		int result = memberService.deleteMember("hong2");
//		if (result>0) {
//			System.out.println("삭제 성공!");
//		}
		
	}

}









