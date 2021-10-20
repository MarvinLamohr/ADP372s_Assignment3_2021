package za.ac.cput.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(encoder().encode("@admin2021"))
                .roles("ADMIN")
                .and()
                .withUser("user")
                .password(encoder().encode("@user2021"))
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"**/create").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/Adp372s_Assignment3_2021/**/getall").hasRole("USER")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }


    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
