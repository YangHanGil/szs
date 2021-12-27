package com.job.springBoot.sign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.job.springBoot.dataSource.user.TableUser;
import com.job.springBoot.dataSource.user.UserRepository;
import com.job.springBoot.sign.SigntVo;

@Service
public class SignService {

	@Autowired
	private UserRepository userRepository;
	
	public String insertUser(SigntVo signtVo) {
		
		String res= null;
		
		//암호화
		BCryptPasswordEncoder scpwd = new BCryptPasswordEncoder();
		
		try {
			String regNo = signtVo.getFRegNo() + "-"+ signtVo.getLRegNo();
			
			TableUser tableUser = 
					new TableUser(null, 
							signtVo.getUserId(), 
							signtVo.getName(), 
							scpwd.encode(signtVo.getPassword()), 
							scpwd.encode(regNo));
			userRepository.save(tableUser);
		} catch (Exception e) {
			// TODO: handle exception
			res = e.toString();
		}
		
		return res;
	}
	
	public boolean selectUserSign(SigntVo signtVo) {
		boolean res = false;
		
		return res;
	}
	
}
