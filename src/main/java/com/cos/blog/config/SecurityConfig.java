package com.cos.blog.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.cos.blog.config.auth.PrincipalDetailService;

@Configuration // IoC
public class SecurityConfig {

	@Autowired
	private PrincipalDetailService principalDetailService;
	
	 @Bean
	 BCryptPasswordEncoder encodePWD() {
	  return new BCryptPasswordEncoder();
	 }

 	// 시큐리티가 대신 로그인 해주는데 password를 가로채기를 하는데
 	// 해당 password가 뭘로 해쉬가 되어 회원가입이 되었는지 알아야
 	// 같은 해쉬로 암호화해서 DB에 있는 해쉬랑 비교할 수 있음.
 	@Bean
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 		System.out.println("configure");
 		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
 	}
 
 
	 @Bean
	 SecurityFilterChain configure(HttpSecurity http) throws Exception {
	  System.out.println("SecurityFilterChain");
		 http
	  	.csrf().disable() // csrf 토큰 비활성화 
	    .authorizeRequests() 
	    .antMatchers("/","/auth/**", "/js/**","/css/**","/image/**")
	    .permitAll()
	    .anyRequest()
	    .authenticated()
	    .and()
	    .formLogin()
	    .loginPage("/auth/loginForm")
	    .loginProcessingUrl("/auth/loginProc") // 스프링 시큐리티가 해당 주소로 오는 로그인을 가로채서 대신 로그인 해준다.
	  	.defaultSuccessUrl("/");
	  
	  return http.build();
	 }
	}