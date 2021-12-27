package com.job.springBoot.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.job.springBoot.login.service.LoginService;
import com.job.springBoot.security.CookieUtil;
import com.job.springBoot.security.JwtUtil;
import com.job.springBoot.security.RedisUtil;

import io.swagger.annotations.ApiOperation;

@RestController("/login")
public class LoginController {
		
	@Autowired
	LoginService loginService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	CookieUtil cookieUtil;
	
	@Autowired
	RedisUtil redisUtil;

	@PostMapping(value = "/login" )
	@ApiOperation(value = "로그인")
	public Response login(
			@Valid LoginVo loginVo,
			BindingResult BindingResult,
			HttpServletRequest req,
			HttpServletResponse res
		) { 
		
		try {
			
            final UserVo userVo = loginService.loginlUser(loginVo);
            final String token = jwtUtil.generateToken(userVo);
            final String refreshJwt = jwtUtil.generateRefreshToken(userVo);
            Cookie accessToken = cookieUtil.createCookie(JwtUtil.ACCESS_TOKEN_NAME, token);
            Cookie refreshToken = cookieUtil.createCookie(JwtUtil.REFRESH_TOKEN_NAME, refreshJwt);
            redisUtil.setDataExpire(refreshJwt, userVo.getUserId(), JwtUtil.REFRESH_TOKEN_VALIDATION_SECOND);
            res.addCookie(accessToken);
            res.addCookie(refreshToken);

            return new Response("success", "로그인에 성공했습니다.", token);
        } catch (Exception e) {
        	
            return new Response("error", "로그인에 실패했습니다.", e.getMessage());
        }
		
		
	}
}
