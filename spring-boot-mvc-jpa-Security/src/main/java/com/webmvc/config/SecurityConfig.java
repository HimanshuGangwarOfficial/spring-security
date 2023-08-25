package com.webmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//		http.httpBasic().and().csrf().disable();

		http.formLogin().loginPage("/login.htm").usernameParameter("j_username").passwordParameter("j_password")

				.and().logout().logoutSuccessUrl("/logout.htm")
				.invalidateHttpSession(true).clearAuthentication(true);
		http.csrf().disable();

		http.authorizeRequests().antMatchers("/home.htm").permitAll()

				.antMatchers("/account/find.htm").hasAnyAuthority("customer", "manager", "clerk");

		return http.build();
	}

	@Bean
	DaoAuthenticationProvider authenticationProvider(PasswordEncoder passwordEncoder,
			UserDetailsService userDetailsService) {

		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setPasswordEncoder(passwordEncoder);
		authenticationProvider.setUserDetailsService(userDetailsService);

		return authenticationProvider;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	public static void main(String[] args) {
//		BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder();
//		
//		System.out.println(encoder.encode("welcome1"));
//	}
}
