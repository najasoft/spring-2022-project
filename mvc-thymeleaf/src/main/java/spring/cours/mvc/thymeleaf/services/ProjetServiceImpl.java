package spring.cours.mvc.thymeleaf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.cours.mvc.thymeleaf.model.Projet;
import spring.cours.mvc.thymeleaf.model.ProjetDev;
import spring.cours.mvc.thymeleaf.model.Tache;
import spring.cours.mvc.thymeleaf.repository.ProjetRepository;
import spring.cours.mvc.thymeleaf.repository.TacheRepository;

@Service
public class ProjetServiceImpl implements ProjetService {
	@Autowired
	ProjetRepository projetRepository;
	@Autowired
	TacheRepository tacheRepository;

	@Override
	public List<Projet> lesProjets() {
		return projetRepository.findAll();

	}

	@Override
	public void supprimer(long idProjet) {
		projetRepository.deleteById(idProjet);

	}

	@Override
	public void ajouter(Projet projet) {
		projetRepository.save(projet);

	}

	@Override
	public void modifier(Projet projet) {
		Projet p = getProjet(projet.getIdProjet());
		if (p != null) {
			p.setDescription(projet.getDescription());
			projetRepository.save(p);
		}
	}

	@Override
	public Projet getProjet(long idProjet) {
		if (projetRepository.existsById(idProjet))
			return projetRepository.findById(idProjet).get();
		else
			return null;

	}

	@Override
	public void ajouterTache(long idProjet, Tache tache) {
		ProjetDev p = getProjetDev(idProjet);
		if (p != null) {
			tache.setProjet(p);
			tacheRepository.save(tache);
		}
	}

	@Override
	public List<Tache> getTaches(long idProjet) {
		return projetRepository.getTaches(idProjet);
	}

	@Override
	public List<ProjetDev> lesProjetsDev() {
		return projetRepository.getProjetDev();
	}

	@Override
	public ProjetDev getProjetDev(long idProjet) {
		if (projetRepository.existsById(idProjet))
			return projetRepository.getProjetDev(idProjet);
		return null;
	}

}
