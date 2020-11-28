package dnt.freshvote.security;


import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

import dnt.freshvote.domain.User;

public class CustomSecurityUser extends User implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	public CustomSecurityUser() {}
	
	public CustomSecurityUser(User user) {
		super.setAuthorities(user.getAuthorities());
		super.setId(user.getId());
		super.setName(user.getName());
		super.setPassword(user.getPassword());
		super.setUsername(user.getUsername());
	}
	
	@Override
	public Set<Authority> getAuthorities() {
		return super.getAuthorities();
	}
 
	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
