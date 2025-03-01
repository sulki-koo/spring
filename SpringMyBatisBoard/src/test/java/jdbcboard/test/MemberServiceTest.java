package jdbcboard.test;


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
		
	@Test
	public void test() throws Throwable {
		List<Member> memberList = memberService.selectMember();
		System.out.println(memberList);
		Member member = memberService.getMember("suga");
		System.out.println(member);
	}
	

}
