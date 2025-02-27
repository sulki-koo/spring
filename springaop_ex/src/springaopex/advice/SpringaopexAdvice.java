package springaopex.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import springaopex.model.Springaopex;
import springaopex.service.SpringaopexService;

@Aspect
@Component
public class SpringaopexAdvice {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private SpringaopexService springaopexService;

	@Before("execution(public * springaopex.service.*Impl.insertSpringaopex(..))")
	public void before(JoinPoint joinpoint) throws Throwable {
		String sql = " insert into log values(seq_log.nextval, seq_springaopex.currval, ?, ?, ?,  sysdate) ";
		Springaopex obj = (Springaopex) joinpoint.getArgs()[0];
		jdbcTemplate.update(sql, obj.getSpass(), null, "INSERT");
	}

	@Around("execution(public * springaopex.service.*Impl.updateSpringaopex(..)) || execution(public * springaopex.service.*Impl.deleteSpringaopex(..))")
	public Object around(ProceedingJoinPoint pjp) {
		String methodName = pjp.getSignature().getName();
		try {
			Springaopex obj = (Springaopex) pjp.getArgs()[0];
			Springaopex oldObj = springaopexService.getSpringaopex(obj.getSid());
			
			switch (methodName) {
			case "updateSpringaopex": {
				String sql = " insert into log values(seq_log.nextval, ?, ?, ?, ?, sysdate) ";
				jdbcTemplate.update(sql, obj.getSid(), oldObj.getSpass(), obj.getSpass(), "UPDATE");
				break;
			}
			case "deleteSpringaopex": {
				String sql = " insert into log values(seq_log.nextval, ?, ?, ?, ?, sysdate) ";
				int sid =  obj.getSid();
				jdbcTemplate.update(sql, sid, oldObj.getSpass(), null, "DELETE");
				break;
			}
			}
			return pjp.proceed();
		} catch (Throwable th) {
			th.printStackTrace();
			return null;
		} finally {
			System.out.println(methodName + " 실행시 log 기록");
		}

	}

}
