package com.github.ganlong.config;

import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/7 20:50
 * @PackageName:com.github.ganlong.config
 * @ClassName: StrategyConfiguration
 * @Description: 策略配置
 * @Version 1.0
 */
@Configuration
@ConfigurationProperties("generator.strategy")
public class StrategyConfiguration {

    /**
     * 设置实体父类
     */
    private String superEntityClass;

    /**
     * 是否使用Lombok
     */
    private boolean entityLombokModel;


    /**
     * 是否使用Rest风格
     */
    private boolean restControllerStyle;


    @Bean
    public StrategyConfig strategyConfig(){
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass(superEntityClass);
        strategy.setEntityLombokModel(entityLombokModel);
        strategy.setRestControllerStyle(restControllerStyle);

        return strategy;
    }
}
