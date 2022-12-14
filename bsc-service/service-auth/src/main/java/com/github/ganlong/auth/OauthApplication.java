package com.github.ganlong.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/19 18:06
 * @PackageName:com.github.ganlong.admin
 * @ClassName: AdminApplication
 * @Description: TODO
 * @Version 1.0
 */
@MapperScan("com.github.ganlong.auth.mapper")
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableConfigurationProperties
public class OauthApplication {
    public static void main(String[] args) {
        SpringApplication.run(OauthApplication.class,args);
    }
}
