package com.aurionpro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.entity.Role;
import com.aurionpro.entity.User;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Optional<Role> findById(Integer roleid);

}
