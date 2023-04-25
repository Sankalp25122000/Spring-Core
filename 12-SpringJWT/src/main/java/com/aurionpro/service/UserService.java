package com.aurionpro.service;

import com.aurionpro.entity.User;

public interface UserService {

	User getUser(Long id);
	
	User getUser(String username);

	User saveUser(User user);

	User addRoleToUser(Long userid, Integer roleid);

}
