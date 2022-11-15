package com.github.ganlong.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/14 21:37
 * @PackageName:com.github.ganlong.auth
 * @ClassName: AuthApplication
 * @Description: TODO
 * @Version 1.0
 */
@SpringBootApplication
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class,args);
    }
}
