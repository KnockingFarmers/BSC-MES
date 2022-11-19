package com.github.ganlong.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.ganlong.admin.mapper.RoleMapper;
import com.github.ganlong.admin.service.RoleService;
import com.github.ganlong.model.auth.Role;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ganlong
 * @since 2022-11-15
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
