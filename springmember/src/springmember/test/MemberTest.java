package springmember.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springmember.controller.MemberControlller;
import springmember.model.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springmember/conf/applicationContext.xml")
public class MemberTest {

	@Autowired
	private MemberControlller memberController;
	
	@Test
	public void testSelectMember() {
		List<Member> memberList = memberController.selectMember();
		assertNotNull(memberList);
	}
	
	@Test
	public void testGetMember() {
		Member member = memberController.getMember("MING");
		assertEquals("MING", member.getMid());
	}
	
//	@Test
//	public void testInsertMember() {
//		Member member = new Member("PARK2", "박박", "F", "부산");
//		int result = memberController.insertMember(member);
//		assertNotEquals(0, result);
//		if(result > 0) {
//			System.out.println(member);
//		}
//	}
	
//	@Test
//	public void testUpdateMember() {
//		Member member = new Member("PARK2", "박2", "M", "서울");
//		int result = memberController.updateMember(member);
//		assertNotEquals(0, result);
//		if(result > 0) {
//			System.out.println(member);
//		}
//	}
	
	@Test
	public void testDeleteMember() {
		Member member = new Member("PARK2", null, null, null);
		int result = memberController.deleteMember(member);
		assertNotEquals(0, result);
		if(result > 0) {
			System.out.println("삭제완료");
		}
	}

}
