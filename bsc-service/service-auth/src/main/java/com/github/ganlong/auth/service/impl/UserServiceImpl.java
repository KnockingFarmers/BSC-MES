package com.github.ganlong.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.ganlong.auth.mapper.UserMapper;
import com.github.ganlong.auth.service.UserService;
import com.github.ganlong.commons.config.JwtInfo;
import com.github.ganlong.commons.uitl.JwtTokenUtil;
import com.github.ganlong.commons.uitl.RedisUtil;
import com.github.ganlong.model.auth.Role;
import com.github.ganlong.model.auth.User;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
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

    @Override
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
        User user =null;

        user=(User) redisUtil.get(token);

        //缓存中没有
        if (user.equals(null)) {
            Map<String, Object> map = new JwtTokenUtil().analyzeTokenData(token, "user");
            // 用户名必须是唯一的，不允许重复
            user = userMapper.getUserByUserName((String) map.get("userName"));

            if(ObjectUtils.isEmpty(user)){
                throw new UsernameNotFoundException("根据用户名找不到该用户的信息！");
            }
            List<Role> roleList = userMapper.getUserRolesByUserId(user.getId().intValue());
            user.setRoles(roleList);

            //生成token并添加到缓存中
            JwtTokenUtil tokenUtil=new JwtTokenUtil();
            JwtInfo jwtInfo = new JwtInfo();
            jwtInfo.setTokenData(user);
            jwtInfo.setTokenDataKey("user");
            String generateToken = tokenUtil.generateToken(jwtInfo);

            //添加到redis缓存中
            redisUtil.set(generateToken,user,JwtTokenUtil.EXTIRPATION);
        }

        return user;
    }
}