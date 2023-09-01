package com.app.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.app.filters.JWTRequestFilter;

@EnableWebSecurity // mandatory
@Configuration // mandatory
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

	@Autowired
	private JWTRequestFilter filter;

	// configure BCryptPassword encode bean
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint((request, response, ex) -> {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
		}).and().authorizeRequests()

				// for sign in , sign up , swagger : permit all
				.antMatchers("/auth/**", "/swagger*/**", "/v*/api-docs/**").permitAll()

				// only required for JS clnts (react / angular) : for the pre flight requests
				.antMatchers(HttpMethod.OPTIONS).permitAll().antMatchers(HttpMethod.GET, "/products/**", "/image/**")
				.permitAll().antMatchers(HttpMethod.GET, "/category/**").permitAll().antMatchers("/category/**")
				.hasAuthority("ADMIN").antMatchers(HttpMethod.PUT, "/user/**").hasAuthority("CUSTOMER")
				.antMatchers("/user/admin/**", "/products/**").hasAuthority("ADMIN").antMatchers("/order/admin")
				.hasAuthority("ADMIN").antMatchers("/order/user/cancel/**").hasAuthority("CUSTOMER")
				.antMatchers("/cartitem/**").hasAuthority("CUSTOMER").antMatchers("/cart/**").hasAuthority("CUSTOMER")

				.anyRequest().authenticated().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

		return http.build();

	}

	// configure auth mgr bean : to be used in SignInSignUp REST controller
	@Bean
	public AuthenticationManager authenticatonMgr(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	//for global CORS enabling
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:3000").allowedMethods("*");
			}
		};
	}
}
