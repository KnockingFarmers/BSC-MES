package com.github.ganlong.production;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/8 21:35
 * @PackageName:com.github.ganlong.production
 * @ClassName: ProductionApplication
 * @Description: 主启动
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableTransactionManagement
public class ProductionApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductionApplication.class,args);
    }
}
