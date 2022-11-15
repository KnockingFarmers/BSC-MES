package com.github.ganlong.model.auth;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.ganlong.model.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ganlong
 * @since 2022-11-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("auth_user")
public class User extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 权限 5最小，0最大
     */
    private Integer auth;

    /**
     * 部门
     */
    private String dept;

    /**
     * 邮箱
     */
    private String email;


}
