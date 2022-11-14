package com.github.ganlong.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/14 15:30
 * @PackageName:com.github.ganlong.gateway
 * @ClassName: GatewayApplication
 * @Description: TODO
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }
}
