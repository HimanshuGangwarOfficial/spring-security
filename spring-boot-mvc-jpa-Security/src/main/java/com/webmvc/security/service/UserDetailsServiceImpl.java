package com.webmvc.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.webmvc.entity.User;
import com.webmvc.repository.UserRepository;
import com.webmvc.security.beans.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserDetailsImpl userDetailsImpl = null;
		Optional<User> optionalUser = userRepository.findByEmailAddress(username);

		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			userDetailsImpl = new UserDetailsImpl(user.getUserId(), user.getEmailAddress(), user.getPassword(),
					user.getStatus(), user.getRole().getRoleName());
		} else {
			throw new UsernameNotFoundException("User Not Dound");
		}

		return userDetailsImpl;
	}

}
