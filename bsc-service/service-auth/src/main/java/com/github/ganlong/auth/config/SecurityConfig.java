package com.github.ganlong.auth.config;

import com.github.ganlong.auth.filter.TokenPerRequestFilter;
import com.github.ganlong.auth.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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

    @Autowired
    private CustomerAuthenticationProvider customerAuthenticationProvider;

    @Autowired
    private TokenPerRequestFilter tokenPerRequestFilter;


    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;
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
                .antMatchers("/", "/index", "/login").permitAll()

                // 仅admin角色可以访问
                .antMatchers("/admin/**").hasRole("admin")

                // admin和manager两个角色可以访问
                .antMatchers("/manager/**").hasAnyRole("admin", "manager")

                //用户所有用户登出
                .and().logout().permitAll()
                .and().httpBasic()

                //关闭Session
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //在UsernamePasswordAuthenticationFilter之前验证
                .and()
                .addFilterBefore(tokenPerRequestFilter, UsernamePasswordAuthenticationFilter.class)

                //异常处理的代理对象
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(authenticationEntryPoint)

                // 暂时关闭CSRF校验，允许get请求登出
                .and()
                .csrf().disable();
    }

    /**
     * 默认开启密码加密，前端传入的密码Security会在加密后和数据库中的密文进行比对，一致的话就登录成功
     * 所以必须提供一个加密对象，供security加密前端明文密码使用
     *
     * @return
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 自定义登陆认证器
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customerAuthenticationProvider);
        //自定义获取用户信息
        auth.userDetailsService(userService);
    }

    @Autowired
    public void setCustomerAuthenticationProvider(CustomerAuthenticationProvider customerAuthenticationProvider) {
        this.customerAuthenticationProvider = customerAuthenticationProvider;
    }

    /**
     * 注入AuthenticationManager管理器
     **/
    @Override
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }


}
