package com.sec.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
//similar to an adapter class for adapting the request body to the entity
public class RegisterRequest {

	
	private String fname;
	private String lname;
	private String email;
	private String password;
}
