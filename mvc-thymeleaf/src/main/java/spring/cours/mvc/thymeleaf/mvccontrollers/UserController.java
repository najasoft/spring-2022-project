package spring.cours.mvc.thymeleaf.mvccontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.cours.mvc.thymeleaf.model.User;
import spring.cours.mvc.thymeleaf.services.UserService;

@Controller
@RequestMapping("/register")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public String ajouter(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "/register";
	}
	@PostMapping
	public String ajouter(@ModelAttribute("user") User user) {
		//System.out.println(user.getUserName()+user.getPassword());
		userService.save(user);
		return "redirect:/";
	}
	




}
