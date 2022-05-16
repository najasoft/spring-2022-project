package spring.cours.mvc.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.cours.mvc.thymeleaf.model.User;


public interface UserRepository extends JpaRepository<User,Integer>{
	
	User findByUserName(String name);

}