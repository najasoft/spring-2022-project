package spring.cours.mvc.thymeleaf.mvccontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	@GetMapping
	public String index() {
		System.out.println("INDEX");
		return "index";
	}

	
}
