package com.job.springBoot.login;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class LoginVo {

		
	@NotBlank(message = "email not null")
	private String userId;
	   
	@NotBlank(message = "password not null")
	@Size(min = 10, message = "비밀번호 10자리 이상")
	private String password;
	
}
