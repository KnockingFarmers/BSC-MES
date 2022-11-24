package com.github.ganlong.auth.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.ganlong.auth.mapper.UserMapper;
import com.github.ganlong.auth.service.OauthService;
import com.github.ganlong.commons.uitl.JwtTokenUtil;
import com.github.ganlong.commons.uitl.RedisUtil;
import com.github.ganlong.model.auth.User;
import lombok.extern.slf4j.Slf4j;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.exception.AuthException;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.model.AuthToken;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.request.AuthRequest;
import me.zhyd.oauth.request.AuthWeChatEnterpriseQrcodeRequest;
import me.zhyd.oauth.utils.AuthStateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/24 20:12
 * @PackageName:com.github.ganlong.auth.service.impl
 * @ClassName: OauthServiceImpl
 * @Description: TODO
 * @Version 1.0
 */
@Slf4j
@Service
public class OauthServiceImpl extends ServiceImpl<UserMapper, User> implements OauthService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public String renderAuth(){
        AuthRequest authRequest = getWechatAuthRequest();
        String authorizeUrl = authRequest.authorize(AuthStateUtils.createState());
        return authorizeUrl;
    }

    @Override
    public Object login(AuthCallback callback) {
        AuthRequest authRequest = getWechatAuthRequest();
        AuthResponse response = authRequest.login(callback);

        log.info(JSONObject.toJSONString(response));

        if (response.ok()) {
            //保存用户
            User user=(User) response.getData();
            save(user);
          return JwtTokenUtil.generateToken(user.getUsername());
        }

        Map<String, Object> map = new HashMap<>(1);
        map.put("errorMsg", response.getMsg());
        return map;
    }

    private AuthRequest getWechatAuthRequest() {
        return new AuthWeChatEnterpriseQrcodeRequest(AuthConfig.builder()
                .clientId("Client ID")
                .clientSecret("Client Secret")
                .redirectUri("回调地址")
                .agentId("xxxx")
                .build());
    }


    @Override
    public Object revokeAuth(String token) {
        AuthRequest authRequest = getWechatAuthRequest();

        AuthUser user =(AuthUser) redisUtil.get(token);
        if (null == user) {
            return "用户不存在";
        }
        AuthResponse<AuthToken> response = null;
        try {
            response = authRequest.revoke(user.getToken());
            if (response.ok()) {
                redisUtil.del(token);
                return "用户 [" + user.getUsername() + "] 的 授权状态 已收回！";
            }
            return "用户 [" + user.getUsername() + "] 的 授权状态 收回失败！" + response.getMsg();
        } catch (AuthException e) {
            return e.getErrorMsg();
        }
    }

}
