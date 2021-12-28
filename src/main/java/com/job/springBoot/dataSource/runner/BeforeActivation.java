package com.job.springBoot.dataSource.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.job.springBoot.dataSource.permission.PromissionRepository;
import com.job.springBoot.dataSource.permission.TablePermission;

@Component
public class BeforeActivation {

	@Autowired
	private PromissionRepository promissionRepository; 
	
	//가입할 수 있는 회원정보를 미리 DB에 삽입
	private String [][] userArr = {
			{"홍길동", "860824-1655068"}
			,{"김둘리", "921108-1582816"}
			,{"마징가", "880601-2455116"}
			,{"베지터", "910411-1656116"}
			,{"손오공", "820326-2715702"}
		};

	@Bean
	public ApplicationRunner applicationRunner() {
		
		//암호화
		BCryptPasswordEncoder scpwd = new BCryptPasswordEncoder();
		
		//리스트를 DB에 삽입한다.
		return args -> {
			for (int i = 0; i < userArr.length; i++) {

				String name = userArr[i][0];
				String regNo = userArr[i][1];
				
				regNo = scpwd.encode(regNo);

				TablePermission TablePermission = 
						new TablePermission(null, name, regNo);
				promissionRepository.save(TablePermission);
			}
		};
	}
}
