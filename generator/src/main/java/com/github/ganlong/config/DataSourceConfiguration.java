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
     * 数据库类型
     */
    private String dbType;

    @Bean
    public DataSourceConfig dataSourceConfig() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        dsc.setDbType(userSetDbType(dbType));
        dsc.setDriverName(driverName);
        dsc.setUsername(userName);
        dsc.setPassword(password);

        return dsc;
    }

    public DbType userSetDbType(String value) {
        switch (value) {
            case "MARIADB":return  DbType.MARIADB;
            case "ORACLE":return  DbType.ORACLE;
            case "ORACLE_12C":return  DbType.ORACLE_12C;
            case "DB2":return  DbType.DB2;
            case "H2":return  DbType.H2;
            case "HSQL":return  DbType.HSQL;
            case "SQLITE":return  DbType.SQLITE;
            case "POSTGRE_SQL":return  DbType.POSTGRE_SQL;
            case "SQL_SERVER2005":return  DbType.SQL_SERVER2005;
            case "SQL_SERVER":return  DbType.SQL_SERVER;
            case "DM":return  DbType.DM;
            case "XU_GU":return  DbType.XU_GU;
            case "KINGBASE_ES":return  DbType.KINGBASE_ES;
            case "PHOENIX":return  DbType.PHOENIX;
            case "OTHER":return  DbType.OTHER;
            default:return DbType.MYSQL;
        }
    }
}
