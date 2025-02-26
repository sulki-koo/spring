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
	// �׽�Ʈ�� ���� ���� �� ���� ����
	public static void beforeClass() {
		System.out.println("��BeforeClass��");
	}

	@Before
	// @Test (�׽�Ʈ�޼ҵ�) ���� �� ����
	public void before() {
		System.out.println("��Before��");
	}

	@Test
	public void test1() {
		System.out.println("��Test 1��");
		
		Person hong = context.getBean("person", Person.class);
		// value.properties���Ͽ��� hong Ű�� �ش��ϴ� ȫ�浿
		System.out.println(hong.getName());

		// hobby ��ü �����ؼ� sort������Ƽ�� '�౸' ����
		Hobby hobby = context.getBean("hobby", Hobby.class);
		hobby.setSort("�౸");

		// ���� ������ �׽�Ʈ
		assertEquals("�౸", hobby.getSort()); // Success
	}

	@Test
	public void test2() {
		System.out.println("��Test 2��");
		int[] iArr1 = { 1, 2, 3 };
		int[] iArr2 = { 1, 3, 5 };
		
		// �� �迭�� ������ �׽�Ʈ
		assertArrayEquals(iArr1, iArr2); // Failures
	}
	
	@Test
	public void test3() {
		System.out.println("��Test 3��");
		Person person1 = context.getBean("person", Person.class);
		Person person2 = context.getBean("person", Person.class);
		
		// �������� �⺻������ ��� ��ü�� �̱������� ����
		// ������ ������ �׽�Ʈ
		assertSame(person1, person2); // Success
		System.out.println(person1.hashCode());
		System.out.println(person2.hashCode());
		
		person1.setName("ȫ�浿");
		
		System.out.println(person2.getName()); // person1�� person2�� ���� ��ü
		System.out.println(person2.getAge());
	}
	
	@Test
	public void test4() {
		System.out.println("��Test 4��");
		boolean bool = true;
		// true���� �׽�Ʈ
		assertTrue(bool); // Success
		
		Object obj = null;
		// null�� �ƴ��� �׽�Ʈ
		assertNotNull(obj); // Failures
	}

	@After
	// @Test (�׽�Ʈ�޼ҵ�) ���� �� ����
	public void after() {
		System.out.println("��After��");
	}

	@AfterClass
	// �׽�Ʈ�� ������ �� ���� ����
	public static void afterClass() {
		System.out.println("��AfterClass��");
	}

}
