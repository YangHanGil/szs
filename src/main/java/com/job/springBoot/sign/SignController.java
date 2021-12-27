package com.job.springBoot.sign;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

	@PostMapping(value = "/signin" )
	@ApiOperation(value = "회원가입", response = SigntVo.class)
	public Object insertUser(
			@Valid SigntVo Signin,
			BindingResult BindingResult,
			Model model
		) {

		String res;
		
		if(BindingResult.hasFieldErrors()) {
			String msg = BindingResult.getFieldError().getDefaultMessage();
			res =  msg;
		} else {
			String signRes = signService.insertUser(Signin);
			res = (signRes == null) ?
				"회원가입에 성공하셨습니다. 로그인하시기 바랍니다." : signRes;
		}
		return res;
		
	}


}
