package com.job.springBoot.login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.job.springBoot.dataSource.user.UserRepository;
import com.job.springBoot.dataSource.user.User;
import com.job.springBoot.security.JwtTokenProvider;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class LoginController {
		
	private final JwtTokenProvider jwtTokenProvider;
	private final UserRepository userRepository;
//	private static PasswordEncoder passwordEncoder;

	// 로그인
    @RequestMapping(value = "/szs/login/do", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "로그인")
	public Object  login(
			@RequestBody loginVo loginVo
		) { 
    	
    	System.out.println("loginVo.getUserId() : " + loginVo.getUserId());
    	System.out.println("loginVo.getPassword() : " + loginVo.getPassword());
    	
    	Map<String, String> user = new HashMap<String, String>();
    	user.put("userId", loginVo.getUserId());
    	user.put("password", loginVo.getPassword());

//    	passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		BCryptPasswordEncoder scpwd = new BCryptPasswordEncoder();
		
		User userVo = userRepository.findByUserId(user.get("userId"))
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 아이디 입니다."));
        if (!scpwd.matches(user.get("password"), userVo.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(userVo.getUsername(), userVo.getRoles());
		
		
	}
}
