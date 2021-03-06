package spring.cours.mvc.thymeleaf.services;

import java.util.List;

import spring.cours.mvc.thymeleaf.model.Projet;
import spring.cours.mvc.thymeleaf.model.ProjetDev;
import spring.cours.mvc.thymeleaf.model.Tache;


public interface ProjetService {
	public Projet ajouter(Projet projet);

	public List<Projet> lesProjets();

	public void supprimer(long idProjet);

	public void modifier(Projet projet);

	public Projet getProjet(long idProjet);
	
	public void ajouterTache(long idProjet, Tache tache);

	ProjetDev getProjetDev(long idProjet);

	List<ProjetDev> lesProjetsDev();

	List<Tache> getTaches(long idProjet);

}
