package com.github.ganlong.admin.config;

import com.github.ganlong.admin.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/14 21:38
 * @PackageName:com.github.ganlong.auth.config
 * @ClassName: SecurityConfig
 * @Description: TODO
 * @Version 1.0
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userService;


    /**
     * 对请求进行鉴权的配置
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 任何角色允许访问
                .antMatchers("/", "/index").permitAll()
                // 仅admin角色可以访问
                .antMatchers("/admin/**").hasRole("admin")
                // admin和manager两个角色可以访问
                .antMatchers("/manager/**").hasAnyRole("admin", "manager")
                .and()
                // 没有权限进入内置的登录页面
                .formLogin()
                .and()
                // 暂时关闭CSRF校验，允许get请求登出
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    /**
     * 默认开启密码加密，前端传入的密码Security会在加密后和数据库中的密文进行比对，一致的话就登录成功
     * 所以必须提供一个加密对象，供security加密前端明文密码使用
     * @return
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
