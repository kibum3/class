package com.project.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.project.common.security.CustomAccessDeniedHandler;
import com.project.common.security.CustomLoginSuccessHandler;
import com.project.common.security.CustomUserDetailsService;

@EnableWebSecurity
// 시큐리티 애너테이션 활성화를 위한 설정
@EnableGlobalMethodSecurity(prePostEnabled=true, securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// 데이터 소스
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// CustomLoginSuccessHandler를 로그인 성공 처리자로 지정한다.
		http.formLogin()
		.loginPage("/auth/login")
		.loginProcessingUrl("/login")
		.successHandler(createAuthenticationSuccessHandler());
		
		// 로그아웃을 하면 자동 로그인에 사용하는 쿠키도 삭제한다.
		http.logout()
		.logoutUrl("/auth/logout")
		.invalidateHttpSession(true)
		.deleteCookies("remember-me","JSESSION_ID");		
		
		// CustomLoginSuccessHandler를 접근 거부자로 지정한다.
		http.exceptionHandling()
		.accessDeniedHandler(createAccessDeniedHandler());
		
		// 데이터 소스를 지정하고 테이블을 이용해서 기존 로그인 정보를 기록
		// 쿠키의 유효시간(24시간)을 지정한다.
		http.rememberMe()
		.key("zeus")
		.tokenRepository(createJDBCRepository())
		.tokenValiditySeconds(60*60*24);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(createUserDetailsService())
		.passwordEncoder(createPasswordEncoder());
	}
		
	@Bean
	public PasswordEncoder createPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	// CustomLoginSuccessHandler를 스프링 빈으로 정의한다.
	@Bean
	public AuthenticationSuccessHandler createAuthenticationSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	// CustomAccessDeniedHandler를 스프링 빈으로 정의한다.
	@Bean
	public AccessDeniedHandler createAccessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	// CustomUserDetailsService를 스프링 빈으로 정의한다.
	@Bean
	public UserDetailsService createUserDetailsService() {
		return new CustomUserDetailsService();
	}
	
	private PersistentTokenRepository createJDBCRepository() {
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource);
		
		return repo;
	}
}
