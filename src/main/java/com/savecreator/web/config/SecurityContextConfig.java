package com.savecreator.web.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@ComponentScan("com.newlecture.web.config")
@EnableWebSecurity // 이 어노테이션으로 시큐리티 활성화
public class SecurityContextConfig extends WebSecurityConfigurerAdapter {

	// MVC Framework -> Dispatcher... 프론트 컨트롤러 -> 컨트롤러
	
	@Autowired
	private BasicDataSource dataSource;
	
	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.headers()
				.frameOptions()
				.sameOrigin()
			.and()
			.csrf().disable()
			.authorizeRequests() // 인터셉터 설정
				.antMatchers("/member/**").hasAnyRole("ADMIN, ADMIN") // 권한이 필요해
				.antMatchers("/notice/**").hasAnyRole("ADMIN, Member") // 권한이 필요해
				.antMatchers("/customer/question").authenticated() //이 요청은 인증을 해야해
				.anyRequest().permitAll() // 나머지는 권한이 필요없어
			.and()
			.formLogin() //폼을 이용해서 로그인
				.defaultSuccessUrl("/index")
				.loginPage("/member/login") // 내가 만든 login page
				.loginProcessingUrl("/member/login") //로그인 처리 url
				.successHandler(authenticationSuccessHandler)
			.and()
			.logout() //로그아웃 설정
				.logoutUrl("/member/logout")
				.logoutSuccessUrl("/index");
			
				
			 // 권한 경로 **는 모든 하위 디렉토리
/*			.antMatchers("/admin/**").hasAnyRole("ADMIN")
			.antMatchers("/academy/**").hasAnyRole("ADMIN, ACADEMY")
			.antMatchers("/teacher/**").hasAnyRole("ADMIN, TEACHER")
			.antMatchers("/student/**").hasAnyRole("ADMIN, STUDENT");*/
		//SPRING 4넘어서는 ID에서는 ROLE_ADMIN 설정에서는 ADMIN  
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 사용자 만들기 - 인메모리 방식
		// 엘뎁, 인메모리, jdbc
/*		UserBuilder user = User.builder();
		
		// 1. 인메모리 방식
		auth.inMemoryAuthentication()
		.withUser(
				 user.username("newlec")
				.password("1234")
				.roles("ADMIN"))
		.withUser(
				 user.username("hong")
				.password("1234")
				.roles("TEACHER")
		);*/
		
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select id, pwd password, 1 enabled from user where id=?") // 사용자 쿼리
		.authoritiesByUsernameQuery("select memberId id, roleName authority  from user where memberId=?") //권한 테이블 쿼리
		.passwordEncoder(new BCryptPasswordEncoder()); // 패스워드 인코딩 방식
		
		// 1. 내가 쿼리를 만들어서 제공
		// 2. 약속된 인터페이스로 구현된 사용자정보 제공 객체
		
		
	}
	
}