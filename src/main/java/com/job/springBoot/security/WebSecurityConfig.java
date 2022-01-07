package com.job.springBoot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final JwtTokenProvider jwtTokenProvider;
//	
	@Override public void configure(WebSecurity web) throws Exception { 
		web.ignoring().antMatchers("/h2-console/**"); 
//		web.ignoring().antMatchers("/szs/signin"); 
	}
	

    // 암호화에 필요한 PasswordEncoder 를 Bean 등록합니다.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    // authenticationManager를 Bean 등록합니다.
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/szs/me").hasRole("개인정보")
//                .antMatchers("/szs/login").hasRole("기본루트")
                .antMatchers("/**").permitAll()
		        .and()
		        .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
		                UsernamePasswordAuthenticationFilter.class);
		http.formLogin()
			.loginPage("/szs/login")
			.loginPage("/szs/login/do")
			.loginProcessingUrl("/szs/login/do")
//			.failureUrl("/login-error")
			.defaultSuccessUrl("/me", true)
			.usernameParameter("userId")
			.passwordParameter("password")
			.permitAll();
    }
    
    @Bean
	public PasswordEncoder noOpPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
