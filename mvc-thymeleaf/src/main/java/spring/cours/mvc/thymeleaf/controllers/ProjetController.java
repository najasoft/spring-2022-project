package spring.cours.mvc.thymeleaf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.cours.mvc.thymeleaf.model.Projet;
import spring.cours.mvc.thymeleaf.model.ProjetDev;
import spring.cours.mvc.thymeleaf.model.ProjetRes;
import spring.cours.mvc.thymeleaf.model.Tache;
import spring.cours.mvc.thymeleaf.repository.UserRepository;
import spring.cours.mvc.thymeleaf.services.ProjetService;

@RestController
@RequestMapping("/projets")
public class ProjetController {

	@Autowired
	private ProjetService projetService;
	private UserRepository userRepository;
	
	

	@PostMapping
	public void ajouter(@RequestBody Projet p) {
		projetService.ajouter(p);
	}

	@PostMapping("/dev")
	public void ajouter(@RequestBody ProjetDev p) {
		projetService.ajouter(p);
	}

	@PostMapping("/res")
	public void ajouter(@RequestBody ProjetRes p) {
		projetService.ajouter(p);
	}
	


	@GetMapping
	public List<Projet> obtenirProjets() {
		return projetService.lesProjets();

	}

	@PostMapping("/{idProjet}/tache")
	public void ajouter(@PathVariable long idProjet, @RequestBody Tache t) {
		projetService.ajouterTache(idProjet, t);
	}

}
