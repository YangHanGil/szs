package com.job.springBoot;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/szs")
public class MainController {
	static String root = "";

	@GetMapping(value = "/login" )
	@ApiOperation(value = "로그인페이지")
	public ModelAndView login(
			Model model,
			HttpSession session
		) { 
		ModelAndView mav = new ModelAndView(root +"login");
		return mav;
	}

	@GetMapping(value = "/signin" )
	@ApiOperation(value = "로그인페이지")
	public ModelAndView signin(
			Model model,
			HttpSession session
		) { 
		ModelAndView mav = new ModelAndView(root +"signin");
		return mav;
	}

	@GetMapping(value = "/me" )
	@ApiOperation(value = "로그인페이지")
	public ModelAndView me(
			Model model,
			HttpSession session
		) { 
		ModelAndView mav = new ModelAndView(root +"me");
		return mav;
	}
}
