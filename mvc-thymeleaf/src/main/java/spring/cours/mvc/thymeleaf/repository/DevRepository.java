package spring.cours.mvc.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.cours.mvc.thymeleaf.model.Developpeur;

@Repository
public interface DevRepository extends JpaRepository<Developpeur, Integer> {

}
