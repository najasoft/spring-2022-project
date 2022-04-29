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

import spring.cours.mvc.thymeleaf.model.Projet;
import spring.cours.mvc.thymeleaf.model.Tache;
import spring.cours.mvc.thymeleaf.services.ProjetService;

@Controller("mvcProjet")
@RequestMapping("/mvcprojets")
public class ProjetController {

	@Autowired
	private ProjetService projetService;

	/*
	 * @GetMapping public String liste(Model m) { m.addAttribute("projets",
	 * projetService.lesProjets()); return "projets"; }
	 * 
	 */
	@GetMapping
	public ModelAndView liste() {
		ModelAndView m = new ModelAndView("projets/projets");
		m.addObject("projets", projetService.lesProjets());
		return m;
	}

	@GetMapping("/test/{nom}")
	public String action(Model m, @PathVariable String nom) {
		Projet p = new Projet();
		p.setIdProjet(55);
		p.setDescription("Projet 55");
		m.addAttribute("projet", p);
		m.addAttribute("nom", nom);
		m.addAttribute("tache", new Tache());
		return "test";
	}

	@GetMapping("/add")
	public String ajout(Model model) {
		Projet p = new Projet();
		model.addAttribute("projet", p);
		return "projets/ajout";

	}

	@PostMapping("/add")
	public String enregistrer(@ModelAttribute("projet") Projet projet) {
		Projet p = projetService.getProjet(projet.getIdProjet());
		if (p != null)
			projetService.modifier(projet);
		else
			projetService.ajouter(projet);
		return "redirect:/mvcprojets";
	}

	@GetMapping("/edit/{id}")
	public String modifier(@PathVariable long id, Model model) {
		Projet p = projetService.getProjet(id);
		if (p != null) {
			model.addAttribute("projet", p);
			return "projets/ajout";
		}

		return "redirect:/mvcprojets";
	}

	@GetMapping("/delete/{id}")
	public String suppr(@PathVariable int id) {
		projetService.supprimer(id);
		return "redirect:/mvcprojets";
	}

}
