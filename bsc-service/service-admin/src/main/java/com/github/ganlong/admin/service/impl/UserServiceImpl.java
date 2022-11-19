package com.github.ganlong.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.ganlong.admin.mapper.UserMapper;
import com.github.ganlong.admin.service.UserService;
import com.github.ganlong.model.auth.Role;
import com.github.ganlong.model.auth.User;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 用户名必须是唯一的，不允许重复
        User user = userMapper.getUserByUserName(s);
        if(ObjectUtils.isEmpty(user)){
            throw new UsernameNotFoundException("根据用户名找不到该用户的信息！");
        }
        List<Role> roleList = userMapper.getUserRolesByUserId(user.getId().intValue());
        user.setRoles(roleList);
        return user;
    }
}
