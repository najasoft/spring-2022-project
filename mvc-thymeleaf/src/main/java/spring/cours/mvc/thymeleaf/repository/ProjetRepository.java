package spring.cours.mvc.thymeleaf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.cours.mvc.thymeleaf.model.Projet;
import spring.cours.mvc.thymeleaf.model.ProjetDev;
import spring.cours.mvc.thymeleaf.model.Tache;


public interface ProjetRepository extends JpaRepository<Projet, Long> {
	@Query(value="Select t from Tache t where t.projet.idProjet=:idProjet") 
	List<Tache> getTaches(@Param("idProjet")long idProjet); 
	@Query("Select p from ProjetDev p") 
	List<ProjetDev> getProjetDev(); 
	@Query(" Select p from ProjetDev p where idProjet=:idP") 
	ProjetDev getProjetDev(@Param("idP")long id);


	

}
