package io.github.andersonleite1.configs;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableAutoConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .passwordEncoder(passwordEncoder())
        .withUser("client")
        .password(passwordEncoder().encode("123"))
        .roles("USER");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .authorizeRequests()
          .antMatchers("/api/clients/**")
            .hasAnyRole("USER", "ADMIN")
          .antMatchers("/api/orders/**")
            .hasAnyRole("USER", "ADMIN")
          .antMatchers("/api/products/**")
            .hasRole("ADMIN")
        .and()
          .formLogin();
    ;
  }

}
