package com.example.PizzaApp.security;

import com.example.PizzaApp.model.Customer;
import com.example.PizzaApp.repository.CustomerRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;


import static org.springframework.security.core.userdetails.User.withUsername;

@Service
public class PizzaCustomerDetailsService implements UserDetailsService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public PizzaCustomerDetailsService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Customer> user = customerRepository.findCustomerByUsername(s);

        //ADMIN == 1 , USER == 0
        ApplicationUserRole roles =(user.get().getUser_role()==0) ? ApplicationUserRole.valueOf("USER") :
                ApplicationUserRole.valueOf("ADMIN");

        if(user.isEmpty()){
            throw new UsernameNotFoundException(s);
        }else{
            System.out.println(roles);
            return withUsername(user.get().getUsername())
                    .password(passwordEncoder.encode(user.get().getPassword()))
                    //.roles(roles.getAuthority())
                    .authorities(roles.getGrantedAuthorities())
                    .accountExpired(false)
                    .accountLocked(false)
                    .credentialsExpired(false)
                    .disabled(false)
                    .build();
        }
    }
}
