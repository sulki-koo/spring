package jdbcboard.test;


import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jdbcboard.model.Member;
import jdbcboard.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:jdbcboard/conf/applicationContext.xml")
public class MemberServiceTest {
	
	@Autowired
	private	MemberService memberService;
		
//	@Test
	public void test() throws Throwable {
		List<Member> memberList = memberService.selectMember();
		for(Member member : memberList) {
			System.out.println(member);
		}
	}
	
//	@Test
	public void insert() throws Throwable{
		int result = memberService.insertMember(new Member("aaaa", "석진", "1202", "진", "jin@jin", "1992", "N"));
		assertNotEquals(0, result);
	}
	
//	@Test
	public void update() throws Throwable {
		int result = memberService.updateMember(new Member("kim2", "new석진", "1202", "진", "jin@jin", "1992", "N"));
		assertNotEquals(0, result);
	}
	
	@Test
	public void delete() throws Throwable {
		int result = memberService.deleteMember("aaaa");
		assertNotEquals(0, result);
	}
}
