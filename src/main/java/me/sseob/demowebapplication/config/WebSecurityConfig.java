package me.sseob.demowebapplication.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// conditionalxxx annotation으로 자동설정되던 부분들이 WebSecurityConfigurerAdapter class를 상속받음에 따라 자동설정 되지 않는다 !
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/", "/security/hello").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.and()
				.httpBasic()
		;
	}
}
