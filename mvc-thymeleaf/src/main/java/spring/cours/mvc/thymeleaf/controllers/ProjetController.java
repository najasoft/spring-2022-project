package spring.cours.mvc.thymeleaf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
	public ResponseEntity<EntityModel<Projet>> ajouter(@RequestBody ProjetRes p, BindingResult result) {
		if (!result.hasErrors()) {

			Projet projet = projetService.ajouter(p);
			EntityModel<Projet> ress = EntityModel.of(projet);

			if (p != null) {
				return new ResponseEntity<>(ress, HttpStatus.CREATED);

			}
			System.out.println("ERREUR");
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.badRequest().build();
	}

	@GetMapping
	public ResponseEntity<List<Projet>> obtenirProjets() {
		return ResponseEntity.ok(projetService.lesProjets());
	}

	@GetMapping("{id}")
	public ResponseEntity<EntityModel<Projet>> obtenirProjets(@PathVariable long id) {
		Projet projet = projetService.getProjet(id);

		if (projet != null) {
			EntityModel<Projet> ressourceProjet = EntityModel.of(projet);
			Link lien = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).obtenirProjets())
					.withRel("les projets");
			Link selfLink = WebMvcLinkBuilder.linkTo((this.getClass())).slash(id).withSelfRel();
			ressourceProjet.add(lien);
			ressourceProjet.add(selfLink);
			return new ResponseEntity<>(ressourceProjet, HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/{idProjet}/tache")
	public void ajouter(@PathVariable long idProjet, @RequestBody Tache t) {
		projetService.ajouterTache(idProjet, t);
	}

}
