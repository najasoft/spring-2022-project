package spring.cours.mvc.thymeleaf.services;

import java.util.List;

import spring.cours.mvc.thymeleaf.model.Developpeur;

public interface DevService {

	List<Developpeur> getDevs();

	void ajouter(Developpeur dev);


	void supprimer(int idDev);

	void modifier(Developpeur dev);

	Developpeur getDeveloppeur(int idDev);
	
	
}
