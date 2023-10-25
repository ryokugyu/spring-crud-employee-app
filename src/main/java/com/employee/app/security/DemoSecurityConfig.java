package com.employee.app.security;


import org.springframework.context.annotation .Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

// adding JDBC support, no more hardcoded value
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employee/getEmployeeDetails").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employee/getEmployeeDetailsById/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employee/addEmployee").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/api/employee/updateEmployeeDetails").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employee/deleteEmployeeDetails/**").hasRole("ADMIN")
        );

        // use http basic authentication
        http.httpBasic(Customizer.withDefaults());


        //disable csrf
        http.csrf(csrf -> csrf.disable());


        return  http.build();
    }

    /*   @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john,mary,susan);
    }

*/
}
