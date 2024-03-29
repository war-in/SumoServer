package com.sumo.server.SecurityConfig;

import com.sumo.server.SecurityConfig.filter.CustomAuthenticationFilter;
import com.sumo.server.SecurityConfig.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

   private final UserDetailsService userDetailsService;
   private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/api/login");
        http.csrf().disable();
        http.cors();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        narazie mamy tutaj takie demu uprawnień, dokładnie określimy to po ustaleniu szczegółów
        http.authorizeRequests().antMatchers("/api/login/**","/api/token/refresh/**", "/competitors/**","/sex","/competitor-registration-by-national-team-coach/**","/swagger-ui/**","/category/**").permitAll();
//        działa to tak że piszemy jaki request idzie, na jaki endpoint i które uprawnienie trzeba mieć żeby się tam dobrać
        http.authorizeRequests().antMatchers(POST,"/api/user/addNew").permitAll();
        http.authorizeRequests().antMatchers(POST,"/national-teams/*").permitAll();
        http.authorizeRequests().antMatchers(GET,"/api/user/**").hasAnyAuthority("ROLE_USER");
        http.authorizeRequests().antMatchers(GET, "/competitions/**").permitAll();
        http.authorizeRequests().antMatchers(GET, "/competitor-registration-by-national-team-coach/**").permitAll();
        http.authorizeRequests().antMatchers(GET, "/competitors/**").permitAll();
        http.authorizeRequests().antMatchers(POST, "/competitions/**").permitAll();
        http.authorizeRequests().antMatchers(POST, "/competitor-registration-by-national-team-coach/**").permitAll();
        http.authorizeRequests().antMatchers(POST, "/competitors/**").permitAll();
        http.authorizeRequests().antMatchers(POST, "/api/user/save").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
}
