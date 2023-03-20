package com.discernd.discernded.security;


import com.discernd.discernded.patient.PatientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final PatientService patientService;

    public SecurityConfig(PatientService patientService) {
        this.patientService = patientService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeHttpRequests((requests) -> requests
                        .regexMatchers("/")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .csrf().disable()
                .authorizeRequests()
                        .regexMatchers("/register")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                        .and()
                        .formLogin();
        return httpSecurity.build();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder();
        provider.setUserDetailsService(patientService);
        return provider;
    }
}
