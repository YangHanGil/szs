package com.job.springBoot.login;

import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.springBoot.dataSource.user.UserRepository;
import com.job.springBoot.dataSource.user.User;
import com.job.springBoot.security.JwtTokenProvider;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController("/login")
public class LoginController {
		
	private final JwtTokenProvider jwtTokenProvider;
	private final UserRepository userRepository;

	@PostMapping(value = "/login" )
	@ApiOperation(value = "로그인")
	public String  login(
			@RequestBody Map<String, String> user
		) { 
		
		BCryptPasswordEncoder scpwd = new BCryptPasswordEncoder();
		
		User userVo = userRepository.findByUserId(user.get("userId"))
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));
        if (!scpwd.matches(user.get("password"), userVo.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(userVo.getUsername(), userVo.getRoles());
		
		
	}
}
