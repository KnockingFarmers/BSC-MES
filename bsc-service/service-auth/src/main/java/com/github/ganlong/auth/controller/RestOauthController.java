package com.github.ganlong.auth.controller;

import com.github.ganlong.auth.service.OauthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/24 20:08
 * @PackageName:com.github.ganlong.auth.controller
 * @ClassName: RestOauthController
 * @Description: OAuth 单点登录权限认证
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/oauth/user")
public class RestOauthController {


    @Autowired
    private OauthService oauthService;



}
