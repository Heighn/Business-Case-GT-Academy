package nl.getthere.model;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import nl.getthere.controllers.MyUserDetailsService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/SignIn")
                .permitAll()
                .and()
            .logout()
                .permitAll();
        http.authorizeRequests().antMatchers("/signUp").permitAll();
    }
    
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {   	
    	auth.
    		userDetailsService(myUserDetailsService).
    	    		passwordEncoder(new BCryptPasswordEncoder());
    }
}