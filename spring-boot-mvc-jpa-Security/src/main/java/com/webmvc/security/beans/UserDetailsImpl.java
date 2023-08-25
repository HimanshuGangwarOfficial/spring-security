package com.webmvc.security.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

	private int userId;
	private String emailAddress;
	private String password;
	private String status;
	private List<GrantedAuthority> authories;

	public UserDetailsImpl(int userId, String emailAddress, String password, String status, String roleName) {
		super();
		this.userId = userId;
		this.emailAddress = emailAddress;
		this.password = password;
		this.status = status;
		this.authories = new ArrayList<>();
		authories.add(new SimpleGrantedAuthority(roleName));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authories;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return emailAddress;
	}

	@Override
	public boolean isAccountNonExpired() {
		return !status.equals("E");
	}

	@Override
	public boolean isAccountNonLocked() {
		return !status.equals("L");
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !status.equals("C");
	}

	@Override
	public boolean isEnabled() {
		return status.equals("A");
	}

}
