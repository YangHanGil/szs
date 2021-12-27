package com.job.springBoot.login.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.job.springBoot.dataSource.user.UserRepository;
import com.job.springBoot.login.LoginVo;
import com.job.springBoot.login.UserVo;

@Service
public class LoginService {

	@Autowired
	UserRepository userRepository;
	
	public UserVo loginlUser (LoginVo loginVo) {
		return userRepository.findByUserId(loginVo);
	}
	
	public UserDetails loadUserByUsername (String name) {
		return userRepository.loadUserByUsername(name);
	}
}
