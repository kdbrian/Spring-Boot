package com.sec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sec.repo.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

	
	private final UserRepository userRepository;
	
	@Bean
	public UserDetailsService userDetailsService() {
		return  username -> {
			return userRepository.findByEmail(username)
			.orElseThrow(()-> new UsernameNotFoundException("User not found"));
		};
	}

}
