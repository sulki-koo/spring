package springdi.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.model.TV;

public class TVMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("/springdi/conf/applicationContext.xml");

		TV tv = (TV) context.getBean("tv");
		System.out.println(tv);

		tv.getSpeaker().printName();

	}

}
