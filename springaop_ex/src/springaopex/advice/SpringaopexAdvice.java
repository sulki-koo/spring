package springaopex.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
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

	@After("execution(public * springaopex.service.*Impl.insertSpringaopex(..))")
	public void insertAfter(JoinPoint joinpoint) throws Throwable {
		Springaopex obj = (Springaopex) joinpoint.getArgs()[0];
		String sql = " insert into log values(seq_log.nextval, seq_springaopex.currval, ?, null, 'INSERT',  sysdate) ";
		jdbcTemplate.update(sql, obj.getSpass());
	}

	@Around("execution(public * springaopex.service.*Impl.updateSpringaopex(..))")
	public Object updateAround(ProceedingJoinPoint pjp) throws Throwable {
		try {
			Springaopex obj = (Springaopex) pjp.getArgs()[0];
			Springaopex oldObj = springaopexService.getSpringaopex(obj.getSid());
			String sql = " insert into log values(seq_log.nextval, ?, ?, ?, 'UPDATE', sysdate) ";
			jdbcTemplate.update(sql, obj.getSid(), oldObj.getSpass(), obj.getSpass());
			return pjp.proceed();
		} finally {
		}
	}

	@Before("execution(public * springaopex.service.*Impl.deleteSpringaopex(..))")
	public void deleteAround(JoinPoint joinPoint) throws Throwable {
		int sid = (Integer) joinPoint.getArgs()[0];
		Springaopex oldObj = springaopexService.getSpringaopex(sid);
		String sql = " insert into log values(seq_log.nextval, ?, ?, null, 'DELETE', sysdate) ";
		jdbcTemplate.update(sql, sid, oldObj.getSpass());
	}

}
