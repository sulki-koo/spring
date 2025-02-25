package springdi.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.model.TV;

public class TVMain {

	public static void main(String[] args) {

		// BeanFactory 인터페이스를 상속받은 ApplicationContext인터페이스 (bean컨테이너)
		ApplicationContext context = new GenericXmlApplicationContext("/springdi/conf/applicationContext.xml");
		
		TV tv = (TV)context.getBean("tv");
		
		System.out.println(tv);

	} // main

} // class
