package spring.cours.mvc.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import spring.cours.mvc.thymeleaf.services.UserService;

@Configuration
@EnableWebSecurity
public class securiteConfig extends WebSecurityConfigurerAdapter {

@Autowired
	public void configureInMemoryUsers(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("u1").password("{noop}p1").roles("ADMIN", "USER").and().withUser("u2")
				.password("{noop}p2").roles("USER").and().withUser("u3").password("{noop}p3").roles("USER");
			
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().antMatchers("/", "/register**", "/js/**,/img/**").permitAll()
				.antMatchers("/projets**").hasRole("ADMIN").antMatchers("/mvcprojets**").hasRole("USER").anyRequest()
				.authenticated().and().formLogin();
	}
}
