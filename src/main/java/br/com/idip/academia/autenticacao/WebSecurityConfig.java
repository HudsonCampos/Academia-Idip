package br.com.idip.academia.autenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import br.com.idip.academia.service.UsuarioService;


@SuppressWarnings("deprecation")
@EnableWebSecurity
@EnableResourceServer
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	UsuarioService usuarioService;
	
	@Override
	public void configure(AuthenticationManagerBuilder aut) throws Exception {
		aut.userDetailsService(usuarioService)
			.passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public AuthenticationManager authenticationManager() throws Exception{
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors()
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() throws Exception{
		return NoOpPasswordEncoder.getInstance();
	}
	
	
}




