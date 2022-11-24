package com.github.ganlong.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.ganlong.model.auth.User;
import me.zhyd.oauth.model.AuthCallback;

import java.io.IOException;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/24 20:09
 * @PackageName:com.github.ganlong.auth.service
 * @ClassName: OauthService
 * @Description: TODO
 * @Version 1.0
 */
public interface OauthService extends IService<User> {

    /**
     * 生成授权连接
     * @return 授权连接
     * @throws IOException
     */
    String renderAuth() throws IOException;

    /**
     * 授权回调
     * @param callback
     * @return
     */
    Object login(AuthCallback callback);

    /**
     * 取消第三方授权
     * @param token token
     * @return
     */
     Object revokeAuth(String token);
}
