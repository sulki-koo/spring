package springmember.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MemberAdvice {

	@Before("execution(public * springmember.service.*Impl.*(..))")
	public void before(JoinPoint joinPoint) {
		// Ÿ��Ŭ������ �޼ҵ��
		String methodName = joinPoint.getSignature().getName();
		System.out.println("@Before ��" + methodName + "�� �޼ҵ� ���� �� ����");
		// Ÿ��Ŭ������ �޼ҵ尡 ���޹��� ���ڵ�
		for (Object obj : joinPoint.getArgs()) {
			System.out.println("�����޵� ���� : " + obj + "\t");
		}
	}

	@AfterReturning(pointcut = "execution(public * springmember.service.*Impl.*(..))", returning = "returnObj")
	public void afterReturning(JoinPoint joinPoint, Object returnObj) {
		// Ÿ��Ŭ������ �޼ҵ��
		String methodName = joinPoint.getSignature().getName();
		System.out.println("@AfterReturning ��" + methodName + "�� �޼ҵ� ���� �� ��ȯ���� ������ ����");
		// Ÿ��Ŭ������ �޼ҵ� ������ ��ü
		System.out.println("�ڸ����� ��ü : " + returnObj);
	}

	@AfterThrowing(pointcut = "execution(public * springmember.service.*Impl.*(..))", throwing = "throwalbe")
	public void afterThrowing(JoinPoint joinPoint, Throwable throwalbe) {
		// Ÿ��Ŭ������ �޼ҵ��
		String methodName = joinPoint.getSignature().getName();
		System.out.println("@AfterThrowing ��" + methodName + "�� �޼ҵ� ���� �� ���ܰ� �߻��ϸ� ����");
		// Ÿ��Ŭ������ �޼ҵ忡�� �߻��� ���� ��ü
		System.out.println("�ڿ��� : " + throwalbe);
	}

	@After("execution(public * springmember.service.*Impl.*(..))")
	public void after(JoinPoint joinPoint) {
		// Ÿ��Ŭ������ �޼ҵ��
		String methodName = joinPoint.getSignature().getName();
		System.out.println("@After ��" + methodName + "�� �޼ҵ� ���� �� ����");
		// Ÿ��Ŭ������ �޼ҵ尡 ���޹��� ���ڵ�
		for (Object obj : joinPoint.getArgs()) {
			System.out.println("�����޵� ���� : " + obj);
		}
	}

	@Around("execution(public * springmember.service.*Impl.*(..))")
	public Object around(ProceedingJoinPoint pjp) {
		// Ÿ��Ŭ������ �޼ҵ��
		String methodName = pjp.getSignature().getName();
		System.out.println("@Around ��" + methodName + "�� �޼ҵ� ���� �� ����");
		try {
			return pjp.proceed();
		} catch (Throwable th) {
			th.printStackTrace();
			return null;
		} finally {
			System.out.println("@Around ��" + methodName + "�� �޼ҵ� ���� �� ����");
		}
	}

}
