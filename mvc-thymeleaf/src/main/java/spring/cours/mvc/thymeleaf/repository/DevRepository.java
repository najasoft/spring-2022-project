package spring.cours.mvc.thymeleaf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import spring.cours.mvc.thymeleaf.model.Developpeur;

@Repository
public interface DevRepository extends JpaRepository<Developpeur, Integer> {

	public Developpeur findByNom(String name);

	public Developpeur findByEmail(String email);

	@Query("Select d from Developpeur d JOIN d.taches t where t.projet.idProjet=:idP")
	List<Developpeur> getDevs(@Param("idP") long idProjet);

}
