package com.github.ganlong.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.ganlong.model.auth.User;
import com.github.ganlong.model.dto.auth.LoginUserDto;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.request.AuthRequest;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ganlong
 * @since 2022-11-15
 */
public interface UserService extends IService<User> {

    /**
     * 根据用户名查找用户是否存在
     * @param userName 用户名
     * @return
     */
    User findUserByUserName(String userName);

    /**
     * 把用户进行封装
     * @param username
     * @return
     */
    UserDetails loadUser(String username);

    /**
     * 用户登录
     * @param loginUserDto
     * @return
     */
    User login(LoginUserDto loginUserDto);

    /**
     * 生成授权连接
     * @param response
     * @throws IOException
     */
     void renderAuth(HttpServletResponse response) throws IOException;

    /**
     * 授权回调
     * @param callback
     * @return
     */
     Object login(AuthCallback callback);
}
