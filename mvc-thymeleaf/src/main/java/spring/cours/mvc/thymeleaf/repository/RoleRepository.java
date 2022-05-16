package spring.cours.mvc.thymeleaf.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.cours.mvc.thymeleaf.model.Role;
@Repository
public interface  RoleRepository  extends JpaRepository<Role,Integer>{
	public Role findByNom(String nom);

}
