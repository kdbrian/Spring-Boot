package com.sec.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@NoArgsConstructor
public class AuthenticationController {
	
	private final AuthenticationService authService;
	
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(
			@RequestBody RegisterRequest registerreq
			){
		return ResponseEntity.ok(authService.register(registerreq));
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> register(
			@RequestBody AuthenticationRequest authrequest
			){
		return ResponseEntity.ok(authService.authenticate(authrequest));
	}

}
