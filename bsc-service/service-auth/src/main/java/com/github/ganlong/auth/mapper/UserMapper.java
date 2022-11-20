package com.github.ganlong.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.ganlong.model.auth.Role;
import com.github.ganlong.model.auth.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ganlong
 * @since 2022-11-15
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 通过用户名获取用户对象
     * @param userName 用户名
     * @return
     */
    User getUserByUserName(String userName);

    /**
     * 获取用户的所有角色信息
     * @param userId 用户id
     * @return
     */
    List<Role> getUserRolesByUserId(Integer userId);
}
