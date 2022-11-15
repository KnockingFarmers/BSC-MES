package com.github.ganlong.auth.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        /**
         * Spring security 5.0中新增了多种加密方式，也改变了密码的格式。
         * spring security 官方推荐的是使用bcrypt加密方式。
         */

        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("kuangshen")
                .password(new BCryptPasswordEncoder()
                        .encode("123456"))
                .roles("vip2", "vip3")
                .and()
                .withUser("root")
                .password(new BCryptPasswordEncoder()
                        .encode("123456"))
                .roles("vip1", "vip2", "vip3")
                .and()
                .withUser("guest")
                .password(new BCryptPasswordEncoder()
                        .encode("123456"))
                .roles("vip1", "vip2");
    }
}
