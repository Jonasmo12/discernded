package com.discernd.discernded.security;


import com.discernd.discernded.patient.PatientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final PatientService patientService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public SecurityConfig(
            PatientService patientService,
            BCryptPasswordEncoder bCryptPasswordEncoder
    ) {
        this.patientService = patientService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(patientService);
        return provider;
    }
}
