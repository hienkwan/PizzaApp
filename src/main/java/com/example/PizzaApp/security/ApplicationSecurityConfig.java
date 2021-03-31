package com.example.PizzaApp.security;

import com.example.PizzaApp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.PizzaApp.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    private final PizzaCustomerDetailsService pizzaCustomerDetailsService;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder, PizzaCustomerDetailsService pizzaCustomerDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.pizzaCustomerDetailsService = pizzaCustomerDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                //.antMatchers("/api/**").hasRole(USER.name())
                //.antMatchers("/admin/api/**").hasRole(ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
}
