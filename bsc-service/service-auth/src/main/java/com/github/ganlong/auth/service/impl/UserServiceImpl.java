package com.github.ganlong.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.ganlong.auth.mapper.UserMapper;
import com.github.ganlong.auth.service.UserService;
import com.github.ganlong.commons.config.JwtInfo;
import com.github.ganlong.commons.uitl.JwtTokenUtil;
import com.github.ganlong.commons.uitl.RedisUtil;
import com.github.ganlong.model.auth.Role;
import com.github.ganlong.model.auth.User;
import com.github.ganlong.model.dto.auth.LoginUserDto;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.request.AuthRequest;
import me.zhyd.oauth.request.AuthWeChatEnterpriseQrcodeRequest;
import me.zhyd.oauth.utils.AuthStateUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ganlong
 * @since 2022-11-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService, UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        // 用户名必须是唯一的，不允许重复
        User user = userMapper.getUserByUserName(userName);

        if (ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException("根据用户名找不到该用户的信息！");
        }
        List<Role> roleList = userMapper.getUserRolesByUserId(user.getId().intValue());
        user.setRoles(roleList);


        return user;
}
    @Override
    public User findUserByUserName(String userName) {
        return userMapper.getUserByUserName(userName);
    }

    @Override
    public UserDetails loadUser(String username) {
        return this.loadUserByUsername(username);
    }

    @Override
    public Object login(LoginUserDto loginUserDto) {
        //使用security框架自带的验证token生成器  也可以自定义。
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(
                        loginUserDto.getUsername(),
                        loginUserDto.getPassword());

        Authentication authenticate = authenticationManager.authenticate(token);
        //放入Security上下文
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        //获取登陆信息
        Object userInfo = authenticate.getPrincipal();

        //生成token
        String generateToken = JwtTokenUtil.generateToken(userInfo.toString());

//        userInfo.setToken(generateToken);

        //添加到redis缓存中
        redisUtil.set(generateToken, userInfo, JwtTokenUtil.EXTIRPATION);

        return userInfo;
    }



}
