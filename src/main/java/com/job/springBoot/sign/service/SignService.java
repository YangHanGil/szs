package com.job.springBoot.sign.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.job.springBoot.dataSource.permission.PromissionRepository;
import com.job.springBoot.dataSource.permission.TablePermission;
import com.job.springBoot.dataSource.user.TableUser;
import com.job.springBoot.dataSource.user.User;
import com.job.springBoot.dataSource.user.UserRepository;
import com.job.springBoot.sign.SignVo;

@Service
public class SignService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PromissionRepository promissionRepository;
	
	public String insertUser(SignVo signtVo) {
		
		String res= null;
		
		//암호화
		BCryptPasswordEncoder scpwd = new BCryptPasswordEncoder();
		
		try {
			String regNo = signtVo.getFRegNo() + "-"+ signtVo.getLRegNo();
			
			User user = 
					new User(null,
							signtVo.getUserId(), 
							signtVo.getName(), 
							scpwd.encode(signtVo.getPassword()), 
							scpwd.encode(regNo),
							null
						);
			userRepository.save(user);
		} catch (Exception e) {
			// TODO: handle exception
			res = e.toString();
		}
		
		return res;
	}
	
	public boolean selectUserSign(SignVo signVo) {
		boolean res = false;
		
		BCryptPasswordEncoder scpwd = new BCryptPasswordEncoder();
		
		String name = signVo.getName();
		List<TablePermission> list = promissionRepository.findByName(name);
		
		// 암호화된 주민번호 비교
		int cnt=0;
		for (TablePermission TablePermission : list) {
			String regNo = signVo.getFRegNo()+"-"+signVo.getLRegNo();
			if (scpwd.matches(
					regNo, 
					TablePermission.getRegNo())) {
				cnt++;
	        }
		}
		
		res = cnt>0 ? false:true;
		
		return res;
	}
	
}
