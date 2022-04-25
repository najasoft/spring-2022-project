package spring.cours.mvc.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.cours.mvc.thymeleaf.model.Tache;

@Repository
public interface TacheRepository extends JpaRepository<Tache, Integer> {

}
