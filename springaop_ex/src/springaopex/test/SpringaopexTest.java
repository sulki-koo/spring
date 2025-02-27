package springaopex.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springaopex.model.Springaopex;
import springaopex.service.SpringaopexService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springaopex/conf/applicationContext.xml")
public class SpringaopexTest {

	@Autowired
	private SpringaopexService springaopexService;

//	@Test
//	public void testSelect() {
//		List<Springaopex> springaopexsList = springaopexService.selectSpringaopex();
//		assertNotNull(springaopexsList);
//		System.out.println(springaopexsList);
//	}
	
//	@Test
//	public void testInsert() {
//		Springaopex springaopex = new Springaopex(0, "5678");
//		int result = springaopexService.insertSpringaopex(springaopex);
//		if(result>0) {
//			System.out.println("등록완료");
//		}
//	}
	
//	@Test
//	public void testUpdate() {
//		Springaopex springaopex = new Springaopex(1, "new1234");
//		int result = springaopexService.updateSpringaopex(springaopex);
//		if(result>0) {
//			System.out.println("수정완료");
//		}
//	}
	
	@Test
	public void testDelete() {
		int result = springaopexService.deleteSpringaopex(21);
		if(result>0) {
			System.out.println("삭제완료");
		}
	}

}
