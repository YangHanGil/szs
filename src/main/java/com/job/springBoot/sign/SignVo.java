package com.job.springBoot.sign;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignVo {
		
	//아이디
	@NotBlank(message = "이메일을 입력하여 주십시오")
	@Size(max = 100, message = "이메일은 최대 100자까지 가능합니다.")
	@Pattern(
		regexp="^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$"
		,message = "이메일형식을 맞춰주시기 바랍니다."
	)
	private String userId;
	
	
	//이름
	@NotBlank(message = "이름을 입력하여 주십시오")
	@Size(max = 20, message = "이름은 최대 20자까지 가능합니다.")
	@Pattern(
		regexp="^[a-zA-Z가-힣]*$"
		,message = "이름은 영문 대소문자 및 한글만 가능합니다"
	)
	private String name;
	
	
		
	//비밀번호
	@NotBlank(message = "비밀번호를 입력하여 주십시오")
	@Pattern(
		regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{10,100}$"
		,message = "비밀번호는 영문대소문자 및 숫자, 특수문자만 10자이상 사용 가능합니다."
	)
	private String password;
	
	
	//주민등록 앞번호
	@NotBlank(message = "주민등록번호 앞번호를 입력하여 주십시오.")
	@Pattern(
		regexp="^[0-9]*$"
		,message = "주민등록번호 규격이 맞지 않습니다."
	)
	@Size(max = 6)
	private String fRegNo;
	

	//주민등록 뒷번호
	@NotBlank(message = "주민등록 뒷번호를 입력하여 주십시오.")
	@Pattern(
		regexp="^[0-9]*$"
		,message = "주민등록번호 규격이 맞지 않습니다."
	)
	@Size(max = 7)
	private String lRegNo;
	
}
