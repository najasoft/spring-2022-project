package spring.cours.mvc.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.cours.mvc.thymeleaf.model.Projet;


public interface ProjetRepository extends JpaRepository<Projet, Long> {

}
