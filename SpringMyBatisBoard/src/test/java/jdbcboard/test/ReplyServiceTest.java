package jdbcboard.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jdbcboard.model.Member;
import jdbcboard.model.Reply;
import jdbcboard.service.MemberService;
import jdbcboard.service.ReplyService;
import jdbcboard.service.impl.ReplyServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:jdbcboard/conf/applicationContext.xml")
public class ReplyServiceTest {
	
	@Autowired
	private	ReplyService replyService;
		
	@Test
	public void test() throws Throwable {
		List<Reply> replyList = replyService.selectReply();
		System.out.println(replyList);
	}
}













