package com.aurionpro.service;

import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Role;
import com.aurionpro.entity.User;
import com.aurionpro.repository.RoleRepository;
import com.aurionpro.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User getUser(Long id) {
		Optional<User> user = userRepository.findById(id);
		return unwrapUser(user, id);
	}

	private User unwrapUser(Optional<User> entity, Long id) {
		if (entity.isPresent())
			return entity.get();
		else
			throw new EntityNotFoundException("User not found");
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User addRoleToUser(Long userid, Integer roleid) {
		User user = userRepository.findById(userid).get();
		Set<Role> roles = user.getRoles();
		Role role = roleRepository.findById(roleid).get();
		roles.add(role);
		userRepository.save(user);
		return user;
	}

	@Override
	public User getUser(String username) {
		Optional<User> user = userRepository.findByUsername(username);
		return unwrapUser(user, 101L);
	}

}
