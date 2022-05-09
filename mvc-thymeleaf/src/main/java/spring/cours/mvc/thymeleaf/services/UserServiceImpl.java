package spring.cours.mvc.thymeleaf.services;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import spring.cours.mvc.thymeleaf.model.Role;
import spring.cours.mvc.thymeleaf.model.User;
import spring.cours.mvc.thymeleaf.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

//	@Autowired
//	BCryptPasswordEncoder passwordEncoder;

	@Override
	public void save(User user) {
	//	User u = new User(user.getUserName(), passwordEncoder.encode(user.getPassword()), "user");
		
		
		
		user.setRoles(Arrays.asList(new Role("USER")));
		userRepository.save(user);
	}

	@Override
	public void saveAdmin(User user) {
	//	User u = new User(user.getUserName(), passwordEncoder.encode(user.getPassword()), "user", "admin");
		User u = new User(user.getUserName(), user.getPassword(),Arrays.asList(new Role("USER"),new Role("ADMIN")) );
		u.setId(user.getId());
		userRepository.save(u);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		if (user==null)
			throw new UsernameNotFoundException("Nom d'utilisateur ou mot de passe erroné");
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				user.getRoles().stream().map(r->new SimpleGrantedAuthority(r.getNom())).collect(Collectors.toList()));

	}

}
