package springmvc2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springmvc2.model.Person;

@Controller
@RequestMapping(value = "/person")
public class PersonController {

//	@RequestMapping(value = "/listPerson.do", method = RequestMethod.GET)
//	@GetMapping(value = "/listPerson.do")
	@GetMapping("/listPerson.do")
	public ModelAndView listPerson() {
		ModelAndView mav = new ModelAndView();
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("슈", 30));
		personList.add(new Person("호", 25));
		personList.add(new Person("몬", 20));

		mav.addObject("personList", personList);
		mav.setViewName("listPerson");
		return mav;
	}

	@RequestMapping(value = "/writeForm.do", method = RequestMethod.GET)
	public String writeForm() {
		return "writeForm";
	}

//	@RequestMapping(value = "/writePerson.do", method = RequestMethod.POST)
//	@PostMapping(value = "/writePerson.do")
	@PostMapping("/writePerson.do")
	public ModelAndView writePerson(@ModelAttribute Person person) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("person", person);
		mav.setViewName("getPerson");
		return mav;
	}

//	@RequestMapping(value = "/getPerson.do", method = RequestMethod.GET)
	@GetMapping("getPerson.do")
	public ModelAndView getPerson(@ModelAttribute Person person) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("person", new Person(person.getName(), person.getAge()));
		mav.setViewName("getPerson");
		return mav;
	}
	
}
