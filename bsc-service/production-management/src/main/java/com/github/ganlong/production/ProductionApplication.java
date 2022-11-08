package com.github.ganlong.production;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/8 21:35
 * @PackageName:com.github.ganlong.production
 * @ClassName: ProductionApplication
 * @Description: 主启动
 * @Version 1.0
 */
@SpringBootApplication
public class ProductionApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductionApplication.class,args);
    }
}
