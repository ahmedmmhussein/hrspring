package hr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login").and().rememberMe().tokenRepository(new InMemoryTokenRepositoryImpl())
				.tokenValiditySeconds(2419200).key("hrsystemKey").and().httpBasic().and().logout().logoutSuccessUrl("/")
				.and().authorizeRequests().antMatchers("/").authenticated().antMatchers("/employee/*")
				.hasRole("ADMIN").antMatchers(HttpMethod.POST, "/employee", "/employees").authenticated().anyRequest()
				.permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and().withUser("admin")
				.password("password").roles("USER", "ADMIN");
	}

}
