package com.github.ganlong.auth.config;

import com.github.ganlong.commons.uitl.RedisUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/20 17:37
 * @PackageName:com.github.ganlong.admin.config
 * @ClassName: ApplicationBeanConfig
 * @Description: 把全局使用的对象注入到容器中
 * @Version 1.0
 */
@Configuration
public class ApplicationBeanConfig {

    @Bean
    public RedisUtil redisUtil(){
        return new RedisUtil();
    }
}
