package in.nk.tech.auth.inmemory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Bean
	public InMemoryUserDetailsManager configInMemoryUsers() {
		UserDetails adminUser = User.withDefaultPasswordEncoder().username("honnur@gmail.com").password("6268")
				.roles("ADMIN").build();
		UserDetails normalUser = User.withDefaultPasswordEncoder().username("abc@gmail.com").password("abc@123")
				.roles("USER").build();
		return new InMemoryUserDetailsManager(adminUser, normalUser);
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((req) -> req.requestMatchers("/login/admin").hasRole("ADMIN").requestMatchers("/login/user")
				.hasAnyRole("ADMIN", "USER").requestMatchers("/").permitAll().anyRequest().authenticated()).formLogin();

		return http.build();

	}
}
