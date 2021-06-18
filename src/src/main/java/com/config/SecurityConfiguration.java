package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserService userService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(
				"/registration**",
					"/js/**",
					"/css/**",
					"/img/**").permitAll()
		.antMatchers("/list").hasAnyAuthority("admin")
		.antMatchers("/delete").hasAnyAuthority("admin")
		.antMatchers("/save").hasAnyAuthority("admin")
		.antMatchers("/edit").hasAnyAuthority("admin")
		.antMatchers("/list-trainingplan").hasAnyAuthority("admin","cliente","dietista","entrenador")
		.antMatchers("/new-trainingplan").hasAnyAuthority("admin")
		.antMatchers("/save-trainingplan").hasAnyAuthority("admin")
		.antMatchers("/delete-trainingplan/?").hasAnyAuthority("admin")
		.antMatchers("/list-routines").hasAnyAuthority("admin","entrenador")
		.antMatchers("/new-routine").hasAnyAuthority("admin","entrenador")
		.antMatchers("/save-routine").hasAnyAuthority("admin","entrenador")
		.antMatchers("/delete-routine").hasAnyAuthority("admin","entrenador")
		.antMatchers("/edit-routine").hasAnyAuthority("admin","entrenador")
		.antMatchers("/list-diets").hasAnyAuthority("admin","dietista")
		.antMatchers("/new-diet").hasAnyAuthority("admin","dietista")
		.antMatchers("/save-diet").hasAnyAuthority("admin","dietista")
		.antMatchers("/delete-diet").hasAnyAuthority("admin","dietista")
		.antMatchers("/edit-diet").hasAnyAuthority("admin","dietista")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout")
		.permitAll();
	}
}
