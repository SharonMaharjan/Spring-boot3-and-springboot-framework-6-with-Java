package com.in28minutes.springboot.myfirstwebapp.security;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
public class SpringSecurityConfiguration {
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		//String username = "in28minutes";
		String password = "dummy";
		UserDetails userDetails1 = createNewUser("in28minutes","dummy");
		UserDetails userDetails2 = createNewUser("sharon","dummydummy");


		return new InMemoryUserDetailsManager(userDetails1,userDetails2);	}

	private UserDetails createNewUser() {
		Function<String,String> passwordEncoder = input->passwordEncoder().encode(input);
		UserDetails userDetails = User.builder()
				.passwordEncoder(passwordEncoder)
				.username("in28minutes")
				.password("dummy")
				.roles("USER","ADMIN")
				.build();
		return userDetails;
	}

	private UserDetails extracted(Function<String, String> passwordEncoder) {
		UserDetails userDetails = User.builder()
										.passwordEncoder(passwordEncoder)
										.username("in28minutes")
										.password("dummy")
										.roles("USER","ADMIN")
										.build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
		http.formLogin(withDefaults());
		http.csrf().disable();
		http.header().frameOptions().disable();
		return http.build();
		
	}
}
