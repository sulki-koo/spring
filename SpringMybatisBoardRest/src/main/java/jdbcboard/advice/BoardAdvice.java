package jdbcboard.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import jdbcboard.model.Article;
import jdbcboard.model.Member;
import jdbcboard.model.Reply;
import jdbcboard.service.ArticleService;
import jdbcboard.service.BoardService;
import jdbcboard.service.MemberService;
import jdbcboard.service.ReplyService;

@Aspect
@Component
public class BoardAdvice {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private MemberService memberService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private BoardService boardService;
	@Autowired
	private ReplyService replyService;

	@After("execution(* jdbcboard.service.impl.*.insert*(..)) || execution(* jdbcboard.service.impl.*.update*(..))")
	public void querylog(JoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().getName();
		String mid = "";

		String sql = " insert into querylog values(seq_querylog.nextval, ?, ?, ?, sysdate) ";
		if (methodName.startsWith("insert") || methodName.startsWith("update")) {
			String action = methodName.replaceAll("^(insert|update).*", "$1").toUpperCase();
			String typeName = methodName.substring(action.length()).toUpperCase();
			
			switch (typeName) {
			case "MEMBER":
				Member member = (Member) joinPoint.getArgs()[0];
				mid = member.getMid();
				break;
			case "ARTICLE":
				Article article = (Article) joinPoint.getArgs()[0];
				mid = article.getMid();
				break;
			case "REPLY":
				Reply reply = (Reply) joinPoint.getArgs()[0];
				mid = reply.getMid();
				break;
			}
			
			System.out.println("액션: " + action); // 예: insert, update
			System.out.println("타입 이름: " + typeName); // 예: Article
			System.out.println("작성자 : " + mid);
			int result = jdbcTemplate.update(sql, typeName, action, mid);
			if (result > 0) {
				System.out.println("로그기록함");
			} else {
				System.out.println("로그 기록 실패");
			}
		}
	}

	@Before("execution(* jdbcboard.service.impl.*.delete*(..))")
	public void deltequerylog(JoinPoint joinPoint) throws Throwable {
		String sql = " insert into querylog values(seq_querylog.nextval, ?, 'DELETE', ?, sysdate) ";

		String typeName = joinPoint.getSignature().getName().substring(6).toUpperCase();
		String id = (String)joinPoint.getArgs()[0];
		String mid = "";

		switch (typeName) {
		case "MEMBER":
			mid = id;
			break;
		case "ARTICLE":
			Article article = articleService.getArticle(Integer.parseInt(id));
			mid = article.getMid();
			break;
		case "REPLY":
			Reply reply = replyService.getReply(Integer.parseInt(id));
			mid = reply.getMid();
			break;
		}
		System.out.println("액션: delete"); // 예: insert, update
		System.out.println("타입 이름: " + typeName); // 예: Article
		System.out.println("작성자 : " + mid);
		
		int result = jdbcTemplate.update(sql, typeName, mid);
		if (result > 0) {
			System.out.println("로그기록함");
		} else {
			System.out.println("로그 기록 실패");
		}
	}

}
