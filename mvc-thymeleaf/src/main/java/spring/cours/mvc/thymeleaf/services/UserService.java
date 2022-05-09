package spring.cours.mvc.thymeleaf.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import spring.cours.mvc.thymeleaf.model.User;

public interface UserService extends UserDetailsService {

	void save(User user);

	void saveAdmin(User user);

}