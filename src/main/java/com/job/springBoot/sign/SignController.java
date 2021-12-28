package com.job.springBoot.sign;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.job.springBoot.sign.service.SignService;

import io.swagger.annotations.ApiOperation;

@RestController(value = "/sign")
public class SignController {
	
	@Autowired
	SignService signService;

	@PostMapping(value = "/signup" )
	@ApiOperation(value = "회원가입", response = SignVo.class)
	public Object insertUser(
			@Valid SignVo signVo,
			BindingResult BindingResult,
			Model model
		) {
		
		BCryptPasswordEncoder scpwd = new BCryptPasswordEncoder();
		
		String res;

		//오류사항 발생시 return
		if(BindingResult.hasFieldErrors()) {
			String msg = BindingResult.getFieldError().getDefaultMessage();
			res =  msg;
		} else {
			
			if(signService.selectUserSign(signVo)) {
				String signRes = signService.insertUser(signVo);
				res = (signRes == null) ?
					"회원가입에 성공하셨습니다. 로그인하시기 바랍니다." : signRes;
			} else {
				throw new IllegalArgumentException("이미 가입된 정보입니다.");
			}
			
		}
		return res;
		
	}


}
