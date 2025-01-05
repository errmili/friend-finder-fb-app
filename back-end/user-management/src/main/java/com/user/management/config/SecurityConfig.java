package com.user.management.config;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    private static final Set<String> PUBLIC_APIS = new HashSet();
//
//    static {
//        PUBLIC_APIS.add("/swagger-ui/**");
//        PUBLIC_APIS.add("/student/**");
//        PUBLIC_APIS.add("/auth/**");
//        PUBLIC_APIS.add("/test/**");
//    }

    @Autowired
    private AuthenticationFilter authenticationFilter;

    public static final String [] PUBLIC_APIS = {
            "/swagger-ui/**",
            "/auth/**",
            "/organization/**",
            "/user/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().cors().and().authorizeRequests().and().formLogin().and()
//                .httpBasic();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().csrf().disable().cors().and().authorizeRequests()
//                .antMatchers(String.valueOf(PUBLIC_APIS)).permitAll()
//                .antMatchers("/test/**").authenticated()
                .antMatchers(PUBLIC_APIS).permitAll()
                .anyRequest().authenticated()
                .and().addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic();
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(Collections.singletonList("*"));
        corsConfiguration.setAllowedMethods(Collections.singletonList("*"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
        final UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}