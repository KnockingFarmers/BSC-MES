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
@TableName("auth_user_role")
public class UserRole extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 用户外键
     */
    private Integer userId;

    /**
     * 角色编号
     */
    private String roleCode;


}
