package com.perscholas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(requests -> requests
                        .mvcMatchers("/login").permitAll()
                        .mvcMatchers("/signup").permitAll()
                        .mvcMatchers("/deleteCar/**").hasAnyRole("SUPERADMIN")
                        .mvcMatchers("/getCarsById/**").hasAnyRole("ADMIN", "SUPERADMIN")
                        .mvcMatchers("/getMyCars/**").hasAnyRole("ADMIN", "SUPERADMIN")
                        .mvcMatchers("/saveCar/**").hasAnyRole("ADMIN", "SUPERADMIN")
                        .mvcMatchers("/**").hasAnyRole("USER", "ADMIN", "SUPERADMIN")

                        .mvcMatchers("/deleteCustomer/**").hasAnyRole("SUPERADMIN")
                        .mvcMatchers("/getCustomersById/**").hasAnyRole("ADMIN", "SUPERADMIN")
                        .mvcMatchers("/getMyCustomers/**").hasAnyRole("ADMIN", "SUPERADMIN")
                        .mvcMatchers("/saveCustomer/**").hasAnyRole("ADMIN", "SUPERADMIN")
                        .mvcMatchers("/**").hasAnyRole("USER", "ADMIN", "SUPERADMIN")

                        .mvcMatchers("/deleteSalesInvoice/**").hasAnyRole("SUPERADMIN")
                        .mvcMatchers("/getSalesInvoicesById/**").hasAnyRole("ADMIN", "SUPERADMIN")
                        .mvcMatchers("/getMySalesInvoices/**").hasAnyRole("ADMIN", "SUPERADMIN")
                        .mvcMatchers("/saveSalesInvoice/**").hasAnyRole("ADMIN", "SUPERADMIN")
                        .mvcMatchers("/**").hasAnyRole("USER", "ADMIN", "SUPERADMIN")

                        .mvcMatchers("/deleteSalesRep/**").hasAnyRole("SUPERADMIN")
                        .mvcMatchers("/getSalesRepsById/**").hasAnyRole("ADMIN", "SUPERADMIN")
                        .mvcMatchers("/getMySalesReps/**").hasAnyRole("ADMIN", "SUPERADMIN")
                        .mvcMatchers("/saveSalesRep/**").hasAnyRole("ADMIN", "SUPERADMIN")
                        .mvcMatchers("/**").hasAnyRole("USER", "ADMIN", "SUPERADMIN")


                        .anyRequest().authenticated())
                .formLogin(login -> login
                        .loginPage("/login")
                        .permitAll())
                .logout(logout -> logout
                        .logoutSuccessUrl("/login"));

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder passwordEncoder
                = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication()

                .withUser("user")
                .password(passwordEncoder.encode("user"))
                .roles("USER")

                .and()
                .withUser("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("USER", "ADMIN")

                .and()
                .withUser("superadmin")
                .password(passwordEncoder.encode("superadmin"))
                .roles("USER", "ADMIN", "SUPERADMIN");

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);


    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/static/**")
                .antMatchers("/**/*.css")
                .antMatchers("/h2-console/**");
    }
}