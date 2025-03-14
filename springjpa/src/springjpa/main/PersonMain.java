package springjpa.main;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springjpa.model.Person;
import springjpa.service.PersonService;

public class PersonMain {

	private static PersonService personService;
	private static ApplicationContext context = new GenericXmlApplicationContext(
			"classpath:/springjpa/conf/applicationContext.xml");

	public static void main(String[] args) {
		personService = (PersonService) context.getBean("personService", PersonService.class);
		Person person;

		// insert
		person = new Person(0, "밍밍", 32, new Timestamp(System.currentTimeMillis()));
		personService.insertPerson(person);
		person = new Person(0, "묭묭", 22, new Timestamp(System.currentTimeMillis()));
		personService.insertPerson(person);

		// getPersonList
//		List<Person> personList = personService.getPersonList();
//		for (Person p : personList) {
//			System.out.println(p);
//		}

		// getPerson
//		System.out.println(personService.getPerson(1));
		
		// updatePerson
		Person updatePerson = new Person(2, "뿅뿅", 20, new Date());
		int result = personService.updatePerson(updatePerson);
		if(result>0) {
			System.out.println("업뎃 완");
		}
		
		// deletePerson
//		result = personService.deletePerson(2);
//		if(result>0) {
//			System.out.println("삭제 완");
//		}
		
	}

}
