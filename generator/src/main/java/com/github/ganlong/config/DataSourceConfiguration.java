package com.github.ganlong.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/6 21:35
 * @PackageName:com.github.ganlong.generator.config
 * @ClassName: DataSourceConfiguration
 * @Description: 数据源配置
 * @Version 1.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "generator.data-source")
public class DataSourceConfiguration {

    /**
     * URL
     */
    private String url;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 驱动
     */
    private String driverName;

    /**
     *数据库类型
     */
    private DbType dbType;

    @Bean
    public DataSourceConfig dataSourceConfig(){
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        dsc.setDbType(dbType);
        dsc.setDriverName(driverName);
        dsc.setUsername(userName);
        dsc.setPassword(password);

        return dsc;
    }
}
