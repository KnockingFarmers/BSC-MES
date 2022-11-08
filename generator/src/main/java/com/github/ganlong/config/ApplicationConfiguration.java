package com.github.ganlong.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.extension.incrementer.H2KeyGenerator;
import com.baomidou.mybatisplus.extension.incrementer.OracleKeyGenerator;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/6 21:20
 * @PackageName:com.github.ganlong.generator.config
 * @ClassName: ApplicationConfiguration
 * @Description: 全局配置
 * @Version 1.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "generator.application")
public class ApplicationConfiguration {

    /**
     * 输出文件路径
     */
    private String outputDir;

    /**
     * 作者姓名
     */
    private String author;

    /**
     * 是否打开资源管理器
     */
    private boolean open;

    /**
     * 是否覆盖文件
     */
    private boolean fileOverride;

    /**
     * 自定义业务类名称规则
     */
    private String serviceName;

    /**
     * 主键策略
     */
    private String idType;

    /**
     * 日期类型格式
     */
    private DateType dateType=DateType.ONLY_DATE;

    /**
     * 是否开启swagger2
     */
    private boolean swagger2;

    @Bean
    public GlobalConfig globalConfig(){
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(outputDir);
        gc.setAuthor(author);
        //生成后是否打开资源管理器
        gc.setOpen(open);
        //重新生成时文件是否覆盖
        gc.setFileOverride(fileOverride);
        //去掉Service接口的首字母I
        gc.setServiceName(serviceName);
        //主键策略
        gc.setIdType(userSetIdType(idType));
        //定义生成的实体类中日期类型
        gc.setDateType(dateType);
        //开启Swagger2模式
        gc.setSwagger2(swagger2);

        return gc;
    }

    public IdType userSetIdType(String value){
        switch (value){
            case "NONE":return IdType.NONE;
            case "ID_WORKER":return IdType.ID_WORKER;
            case "ASSIGN_ID":return IdType.ASSIGN_ID;
            case "ASSIGN_UUID":return IdType.ASSIGN_UUID;
            case "UUID":return IdType.UUID;
            case "ID_WORKER_STR":return IdType.ID_WORKER_STR;
            default:return IdType.AUTO;
        }
    }

    @Bean
    public IKeyGenerator keyGenerator() {
        return new OracleKeyGenerator();
    }
}
