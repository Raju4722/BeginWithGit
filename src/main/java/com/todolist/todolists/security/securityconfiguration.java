package com.todolist.todolists.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.dialect.InsertWithDefaultValues;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;
@Configuration
public class securityconfiguration {
	
	@Bean
	public InMemoryUserDetailsManager creating() {
		UserDetails extracted1 = extracted("raju1", "47222");
		UserDetails extracted2 = extracted("raju2", "472222");
		return new InMemoryUserDetailsManager(extracted1,extracted2);
	}
	private UserDetails extracted(String username,String password) {
		Function<String, String> passwordencode=input ->passwordencoder().encode(input);
		
		UserDetails uede = User.builder().
				passwordEncoder(passwordencode)
				.username(username).password(password).roles("USER").build();
		return uede;
		
	}
	@Bean
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(auth ->auth.anyRequest().authenticated());
		http.formLogin(withDefaults());
		http.csrf().disable();
		http.headers().frameOptions().disable();
		return http.build();
		}
	
}

