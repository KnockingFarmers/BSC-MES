package com.github.ganlong.material;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/9 20:47
 * @PackageName:com.github.ganlong.material
 * @ClassName: MaterialApplication
 * @Description: TODO
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MaterialApplication {
    public static void main(String[] args) {
        SpringApplication.run(MaterialApplication.class,args);
    }
}
