package com.github.ganlong.config;

import com.baomidou.mybatisplus.generator.config.PackageConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/6 21:01
 * @PackageName:com.github.ganlong.generator.config
 * @ClassName: PackageConfiguration
 * @Description: 包生成配置
 * @Version 1.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "generator.package.name")
public class PackageConfiguration {

    /**
     * 模块名称
     */
    private String modelName;

    /**
     * 父包配置
     */
    private String parent="parent";

    /**
     * 控制层名称
     */
    private String controller="controller";

    /**
     * 业务层名称
     */
    private String service="service";

    /**
     * 业务实现类名称
     */
    private String serviceImpl="impl";

    /**
     * mapper层名称（dao)
     */
    private String mapper="mapper";

    /**
     * mybatis的 xml 文件夹名称
     */
    private String xml="xml";

    /**
     * 实体类名称
     */
    private String entity="entity";

    @Bean
    public PackageConfig packageConfig(){
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(modelName);
        pc.setParent(parent);
        pc.setController(controller);
        pc.setEntity(entity);
        pc.setService(service);
        pc.setServiceImpl(serviceImpl);
        pc.setMapper(mapper);
        pc.setXml(xml);

        return pc;
    }

}
