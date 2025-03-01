package jdbcboard.advice;

import org.apache.logging.log4j.core.tools.picocli.CommandLine.Command;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Aspect
@Command
public class BoardAdvice {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Around("execution(public * jdbcboard.service.impl.*.*(..))")
	public Object querylog(ProceedingJoinPoint pjp) throws Throwable {
		
		try {
			String methodName = pjp.getSignature().getName();
			String sql = "INSERT INTO QUERYLOG VALUES(SEQ_QUERYLOG.NEXTVAL, ?, ?, ?, SYSDATE)";
			String mid = (String) pjp.getArgs()[0];
			
			 // 메소드 이름에서 'insert' 또는 'update'와 같은 동사를 분리하고 나머지 타입명 추출
	        if (methodName.startsWith("insert") || methodName.startsWith("update") || methodName.startsWith("delete")) {
	            String action = methodName.substring(0, methodName.indexOf(methodName.replaceFirst("^.*?([A-Za-z]+).*", "$1"))); // 'insert' 또는 'update' 부분 추출
	            String typeName = methodName.substring(action.length());  // 'insert' 또는 'update' 이후의 부분 추출
	            System.out.println("액션: " + action);  // 예: insert, update
	            System.out.println("타입 이름: " + typeName);  // 예: Article
	            jdbcTemplate.update(sql, typeName, action, mid);
	        }
	        System.out.println(methodName);
	        return pjp.proceed();
		}finally {
		}
	}
	
}
