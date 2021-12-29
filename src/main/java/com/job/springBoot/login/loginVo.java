package com.job.springBoot.login;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class loginVo {

	@NotBlank(message = "email not null")
	private String userId;
	   
	@NotBlank(message = "password not null")
	@Size(min = 10, message = "비밀번호 10자리 이상")
	private String password;
}
