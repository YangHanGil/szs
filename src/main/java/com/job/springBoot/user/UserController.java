package com.job.springBoot.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/szs")
public class UserController {

	@ResponseBody
	@RequestMapping(value = "/me", method = RequestMethod.POST)
	@ApiOperation(value = "유저정보")
	public Object  login(
			
		) { 

		ModelAndView mav;
		mav = new ModelAndView("redirect:/szs/me");
		
		return mav;
	}
}
