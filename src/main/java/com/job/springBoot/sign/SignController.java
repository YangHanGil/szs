package com.job.springBoot.sign;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.job.springBoot.sign.service.SignService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/sign")
public class SignController {
	
	@Autowired
	SignService signService;

	@ResponseBody
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	@ApiOperation(value = "회원가입", response = SignVo.class)
	public Object insertUser(
			@Valid SignVo signVo,
			BindingResult BindingResult,
			Model model
		) {
		
		String res;
		String msg;
		
		ModelAndView mav;

		//오류사항 발생시 return
		if(BindingResult.hasFieldErrors()) {
			msg = BindingResult.getFieldError().getDefaultMessage();
			mav = new ModelAndView("/signin");
		} else {
			
			if(signService.selectUserSign(signVo)) {
				
				res = signService.insertUser(signVo);
				msg =(res == null) ? 
						" 회원가입에 성공하셨습니다. 로그인하시기 바랍니다." : "가입할 수 없는 정보입니다.";
				mav = (res == null) ? 
						new ModelAndView("/index"): new ModelAndView("/signin");
			} else {
				mav = new ModelAndView("/signin");
				msg ="가입할 수 없는 정보입니다.";
			}
			
		}
		
		model.addAttribute("msg", msg);
		
		return mav;
		
	}


}
