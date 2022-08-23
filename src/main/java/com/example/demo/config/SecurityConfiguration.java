package com.example.demo.config;


import com.example.demo.config.filter.AuntificationFilter;
import com.example.demo.config.filter.AuthorizeFilter;
import com.example.demo.servise.AuthServise;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private AuthServise authServise;


    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        AuntificationFilter filter = new AuntificationFilter(authenticationManagerBean());
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests().antMatchers("/login/**","/api/link/**").permitAll();
//        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/company/**").hasAnyAuthority("Admin");
//        http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/company/**").hasAnyAuthority("Admin");
        //http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/user/**").hasAnyAuthority("Admin");
        //http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/user/**").hasAnyAuthority("Admin");
        http.authorizeRequests().anyRequest().authenticated();
        http.formLogin().permitAll();
        http.addFilter(filter);
        http.addFilterBefore(new AuthorizeFilter(), UsernamePasswordAuthenticationFilter.class);
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

}
