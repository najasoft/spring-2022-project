package spring.cours.mvc.thymeleaf.mvccontrollers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.cours.mvc.thymeleaf.model.Developpeur;
import spring.cours.mvc.thymeleaf.services.DevService;

@Controller("mvcDev")
@RequestMapping("/mvcdevs")
public class DevController {
	@Autowired
	DevService devService;

	@GetMapping("/add")
	public String ajout(Model model) {
		Developpeur d = new Developpeur();
		model.addAttribute("dev", d);
		return "devs/ajout";
	}

	@PostMapping("/add")
	public String enregistrer(@ModelAttribute("dev") @Valid Developpeur dev, BindingResult result) {
		// System.out.println(dev.getDateEmbauche().toString());
		if (result.hasErrors()) {
			return "devs/ajout";
		}
		try {
			devService.ajouter(dev);
		} catch (Exception e) {
			result.addError(new ObjectError(result.getObjectName(), e.getLocalizedMessage()));
			return "devs/ajout";
		}

		return "redirect:/mvcdevs";
	}

}
