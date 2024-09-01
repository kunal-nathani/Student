package com.Tata.StudentSecurity;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .csrf(csrf -> csrf.disable())  // Disable CSRF for simplicity (use in production with caution)
	            .headers(headers -> headers
	                .frameOptions().disable()  // Allow content to be displayed in iframes
	            )
	            .authorizeHttpRequests(auth -> 
	                auth
	                    .requestMatchers(new AntPathRequestMatcher("/api/employees/**")).authenticated()  // Secure these endpoints
	                    .anyRequest().permitAll()
	            )
	            .httpBasic(withDefaults());  // Use defaults for basic authentication

	        return http.build();
	    }

	    @Bean
	    public UserDetailsService userDetailsService() {
	        UserDetails user = User.withUsername("user")
	            .password("{noop}password")  // "{noop}" means plain text password (avoid in production)
	            .roles("USER")
	            .build();

	        return new InMemoryUserDetailsManager(user);
	    }

}
