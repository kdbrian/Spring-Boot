package com.sec.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sec.config.JwtService;
import com.sec.repo.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.var;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationService {

	
	private final UserRepository userRepository;
	private final JwtService jwtService;
	private final PasswordEncoder encoder;
	private final AuthenticationManager authenticationManager;
	
	public AuthenticationResponse register(RegisterRequest registerreq) {
		
		var user = User.builder()
				.first_name(registerreq.getFirstName())
				.last_name(registerreq.getLastName())
				.email(registerreq.getEmail())
				.password(encoder.encode(registerreq.getPassword()));//hashing the password
				.build();
		
		var jwttoken = jwtService.generateToken((UserDetails) user);
		
		userRepository.save(user);
		
		return new AuthenticationResponse.builder()
				.token(jwttoken)
				.build();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest authrequest) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						authrequest.getEmail(), 
						authrequest.getPassword()
						)
		);
		var user = userRepository.findByEmail(authrequest.getEmail()).orElseThrow();

		return new AuthenticationResponse.builder()
				.token(jwttoken)
				.build();
	}
	
	
}
