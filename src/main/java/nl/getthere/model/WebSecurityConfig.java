package nl.getthere.model;

import nl.getthere.controllers.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/styles.css", "/signUp", "/images/logo.png", "/images/bg.jpg", "/student/registreren", "/index", "/recruiter/signUp").permitAll()
                .antMatchers("/student/*").hasAuthority("student")
                .antMatchers("/recruiter/*").hasAuthority("student")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/student/inloggen")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }
    
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(myUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {   	
//    	auth.
//    		userDetailsService(myUserDetailsService).
//    	    		passwordEncoder(new BCryptPasswordEncoder());
        auth.authenticationProvider(authProvider());
    }
}