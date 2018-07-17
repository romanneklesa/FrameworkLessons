package com.frameworks.lessons.config;



import com.frameworks.lessons.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder;

//by Roman Neklesa
//Config class for the distribution of roles (regular user, admin)

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Autowired
    @Qualifier("userDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
   /* protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/admin/**")
                .access("hasRole('ROLE_ADMIN')").and().formLogin()
                .loginPage("/login").failureUrl("/login?error")
                .usernameParameter("name")
                .passwordParameter("password")
                .and().logout().logoutSuccessUrl("/login?logout")
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/403");
    }*/


    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/admin/**")
                .access("hasRole('ROLE_ADMIN')").and().formLogin()
                .loginPage("/login").failureUrl("/login?error")
                .usernameParameter("name")
                .passwordParameter("password")
                .and().logout().logoutSuccessUrl("/login?logout")
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/403");
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // Временный пользователя который находятся в памяти. Позже будет привязка к БД

        auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("user")).roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Говорим что все запросы должны пройти аунтификацию (не путать с авторизацией)
        http.authorizeRequests()
                .antMatchers("/", "/login", "/resources/**").permitAll() // Все страницы и ресурсы доступны всем
                .antMatchers("/panel/**", "/api/**").access("hasRole('ADMIN')"); // Страницы и api запросы доступны только админу

        // Говорим что страница авторизации всем доступна
        http.formLogin()
                .loginPage("/login")
                .permitAll(true);

        // Задаём параметры для выхода и что при этом нужно сделать
        http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout").deleteCookies("JSESSIONID")
                .invalidateHttpSession(true);


    }*/


}
