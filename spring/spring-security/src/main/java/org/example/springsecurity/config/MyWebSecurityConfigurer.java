package org.example.springsecurity.config;

import org.example.springsecurity.service.MyUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author qiqiang
 * @date 2020-12-20 20:34
 */
@Configuration
public class MyWebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailsServiceImpl myUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //表单登陆
        http.formLogin()
                .usernameParameter("user")
                .passwordParameter("pass")
                .loginProcessingUrl("/edu/login")
                // 重定向到成功页面
                .defaultSuccessUrl("/main.html")
                .and()
                // 鉴权
                .authorizeRequests()
                .mvcMatchers("/edu/login").permitAll()
                .mvcMatchers("/hello").hasAnyAuthority("r1")
                .anyRequest().authenticated()
                .and()
                .sessionManagement().maximumSessions(1)
//                .maxSessionsPreventsLogin(true)
                .and()
                .and()
//                // 跨站请求伪造处理
                .csrf().disable();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}