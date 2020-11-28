package dnt.freshvote.service;


import static org.junit.Assert.assertThat;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDetailsServiceTest {

	@SuppressWarnings("deprecation")
	@Test
	public void generate_encrypted_password() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	 	String rawPassword = "123456";
	 	String encodePassword = encoder.encode(rawPassword);
	 	System.out.print(encodePassword);
	 	assertThat(rawPassword, not(encodePassword));
	}
}
