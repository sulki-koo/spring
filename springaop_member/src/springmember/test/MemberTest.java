package springmember.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
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
//	@Ignore
	public void testSelectMember() {
		List<Member> memberList = memberController.selectMember();
		assertNotNull(memberList);
	}
	
//	@Test
	@Ignore
	public void testGetMember() {
		Member member = memberController.getMember("MING");
		assertEquals("MING", member.getMid());
	}
	
//	@Test
	@Ignore
	public void testInsertMember() {
		Member member = new Member("PARK2", "�ڹ�", "F", "�λ�");
		int result = memberController.insertMember(member);
		assertNotEquals(0, result);
		if(result > 0) {
			System.out.println("��ϼ���");
		}
	}
	
//	@Test
	@Ignore
	public void testUpdateMember() {
		Member member = new Member("PARK2", "��2", "M", "����");
		int result = memberController.updateMember(member);
		assertNotEquals(0, result);
		if(result > 0) {
			System.out.println("��������");
		}
	}
	
//	@Test
	@Ignore
	public void testDeleteMember() {
		int result = memberController.deleteMember("PARK2");
		assertNotEquals(0, result);
		if(result > 0) {
			System.out.println("�����Ϸ�");
		}
	}

}
