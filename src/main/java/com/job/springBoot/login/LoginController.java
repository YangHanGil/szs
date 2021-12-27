package com.job.springBoot.login;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.ApiOperation;

@RestController("/login")
public class LoginController {

	@PostMapping(value = "/login" )
	@ApiOperation(value = "로그인")
	public ModelAndView login(
			Model model,
			HttpSession session
		) { 
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
}
