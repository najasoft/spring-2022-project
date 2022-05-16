package spring.cours.mvc.thymeleaf.mvccontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.cours.mvc.thymeleaf.model.User;
import spring.cours.mvc.thymeleaf.repository.RoleRepository;
import spring.cours.mvc.thymeleaf.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;
	@Autowired
	RoleRepository roleRepository;
	

	@GetMapping
	public ModelAndView liste() {
		ModelAndView m = new ModelAndView("admin/users");
		m.addObject("users", userService.liste());
		return m;
	}

	@GetMapping("/add")
	public String ajout(Model model) {
		User u = new User();
		model.addAttribute("user", u);
		model.addAttribute("roles", roleRepository.findAll());
		return "admin/ajout";

	}

	@PostMapping("/add")
	public String enregistrer(@ModelAttribute("user") User user) {
		User u = userService.getUser(user.getId());
		if (u != null)
			userService.modifier(user);
		else
			userService.ajouter(user);
		return "redirect:admin";
	}

	@GetMapping("/edit/{id}")
	public String modifier(@PathVariable int id, Model model) {
		User u = userService.getUser(id);
		if (u != null) {
			model.addAttribute("user", u);
			model.addAttribute("roles", roleRepository.findAll());
			return "admin/ajout";
		}

		return "redirect:admin";
	}

	@GetMapping("/delete/{id}")
	public String suppr(@PathVariable int id) {
		userService.supprimer(id);
		return "redirect:admin";
	}

}
