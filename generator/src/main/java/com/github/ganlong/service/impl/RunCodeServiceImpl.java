package com.github.ganlong.service.impl;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.github.ganlong.service.RunCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/7 22:11
 * @PackageName:com.github.ganlong.service.impl
 * @ClassName: RunCodeServiceImpl
 * @Description: TODO
 * @Version 1.0
 */
@Service
public class RunCodeServiceImpl implements RunCodeService {

    @Autowired
    private PackageConfig packageConfig;

    @Autowired
    private GlobalConfig globalConfig;

    @Autowired
    private StrategyConfig strategyConfig;

    @Autowired
    private DataSourceConfig dataSourceConfig;


    @Override
    public void runCode() {
        // 代码生成器执行
        AutoGenerator mpg = new AutoGenerator();
        mpg.setPackageInfo(packageConfig);
        mpg.setGlobalConfig(globalConfig);
        mpg.setDataSource(dataSourceConfig);
        mpg.setStrategy(strategyConfig);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
