package jdbcboard.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jdbcboard.model.Board;
import jdbcboard.model.Member;
import jdbcboard.service.BoardService;
import jdbcboard.service.MemberService;
import jdbcboard.service.impl.BoardServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:jdbcboard/conf/applicationContext.xml")
public class BoardServiceTest {
	
	@Autowired
	private	BoardService boardService;
		
	@Test
	public void test() throws Throwable {
		List<Board> boardList = boardService.selectBoard();
		System.out.println(boardList);
	}

}













