/**
 * 
 */
package com.shopme.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author ultimate
 *
 */

//@DataJpaTest
public class PasswordEncoderTest {

	/***
	 * Tes to see if bcrypt encrypts the password
	 */
	@Test
	public void testEncodePassword() {
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String rawPwd="test1234";
		String encodedPwd=bCryptPasswordEncoder.encode(rawPwd);
		
		System.out.println(rawPwd);
		System.out.println(encodedPwd);	
		
		assertThat(bCryptPasswordEncoder.matches(rawPwd, encodedPwd)).isTrue();
	}
}
