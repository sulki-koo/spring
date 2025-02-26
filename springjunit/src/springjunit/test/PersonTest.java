package springjunit.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springjunit.model.Hobby;
import springjunit.model.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springjunit/conf/applicationContext.xml")
public class PersonTest {

	@Autowired
	private ApplicationContext context;

	@BeforeClass
	// 테스트시 제일 먼저 한 번만 수행
	public static void beforeClass() {
		System.out.println("★BeforeClass★");
	}

	@Before
	// @Test (테스트메소드) 실행 전 실행
	public void before() {
		System.out.println("♠Before♠");
	}

	@Test
	public void test1() {
		System.out.println("★Test 1★");
		
		Person hong = context.getBean("person", Person.class);
		// value.properties파일에서 hong 키에 해당하는 홍길동
		System.out.println(hong.getName());

		// hobby 객체 생성해서 sort프라퍼티에 '축구' 저장
		Hobby hobby = context.getBean("hobby", Hobby.class);
		hobby.setSort("축구");

		// 값이 같은지 테스트
		assertEquals("축구", hobby.getSort()); // Success
	}

	@Test
	public void test2() {
		System.out.println("★Test 2★");
		int[] iArr1 = { 1, 2, 3 };
		int[] iArr2 = { 1, 3, 5 };
		
		// 두 배열이 같은지 테스트
		assertArrayEquals(iArr1, iArr2); // Failures
	}
	
	@Test
	public void test3() {
		System.out.println("★Test 3★");
		Person person1 = context.getBean("person", Person.class);
		Person person2 = context.getBean("person", Person.class);
		
		// 스프링은 기본적으로 모든 객체를 싱글턴으로 만듦
		// 참조가 같은지 테스트
		assertSame(person1, person2); // Success
		System.out.println(person1.hashCode());
		System.out.println(person2.hashCode());
		
		person1.setName("홍길동");
		
		System.out.println(person2.getName()); // person1과 person2는 같은 객체
		System.out.println(person2.getAge());
	}
	
	@Test
	public void test4() {
		System.out.println("★Test 4★");
		boolean bool = true;
		// true인지 테스트
		assertTrue(bool); // Success
		
		Object obj = null;
		// null이 아닌지 테스트
		assertNotNull(obj); // Failures
	}

	@After
	// @Test (테스트메소드) 실행 후 실행
	public void after() {
		System.out.println("♠After♠");
	}

	@AfterClass
	// 테스트시 마지막 한 번만 수행
	public static void afterClass() {
		System.out.println("★AfterClass★");
	}

}
