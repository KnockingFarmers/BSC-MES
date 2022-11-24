package com.github.ganlong.auth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/24 20:14
 * @PackageName:com.github.ganlong.auth.config
 * @ClassName: OauthConfig
 * @Description: 授权配置类
 * @Version 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "oauth")
public class OauthConfig {

    @Value("client-id")
    private String clientId;

    @Value("client-secret")
    private String clientSecret;

    @Value("redirect-uri")
    private String redirectUri;

    @Value("agent-id")
    private String agentId;



}
