package jdbcboard.advice;

import javax.servlet.http.HttpServletRequest;

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
	private HttpServletRequest request;

	@After("execution(* jdbcboard.service.impl.*.insert*(..)) || execution(* jdbcboard.service.impl.*.update*(..))")
	public void querylog(JoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().getName();
		int result = 0;

		String sql = " insert into querylog values(seq_querylog.nextval, ?, ?, ?, sysdate) ";
		if (methodName.startsWith("insert") || methodName.startsWith("update")) {
			String action = methodName.replaceAll("^(insert|update).*", "$1").toUpperCase();
			String typeName = methodName.substring(action.length()).toUpperCase();

			if (typeName.equals("MEMBER")) {
				Member member = (Member) joinPoint.getArgs()[0];
				result = jdbcTemplate.update(sql, typeName, action, member.getMid());
			} else {
				String ss_mid = (String) request.getSession().getAttribute("ss_mid");
				result = jdbcTemplate.update(sql, typeName, action, ss_mid);
			}

			if (result > 0) {
				System.out.println("로깅 [액션: " + action + ", 타입 이름: " + typeName + "]");
			} else {
				System.out.println("로깅 실패");
			}
		}
	}

	@Before("execution(* jdbcboard.service.impl.*.delete*(..))")
	public void deltequerylog(JoinPoint joinPoint) throws Throwable {
		String sql = " insert into querylog values(seq_querylog.nextval, ?, 'DELETE', ?, sysdate) ";
		String typeName = joinPoint.getSignature().getName().substring(6).toUpperCase();
		String ss_mid = (String) request.getSession().getAttribute("ss_mid");
		int result = 0;

		result = jdbcTemplate.update(sql, typeName, ss_mid);

		if (result > 0) {
			System.out.println("로깅 [" + ss_mid + " 액션: delete, 타입 이름: " + typeName + "]");
		} else {
			System.out.println("로깅 실패");
		}
	}

}
