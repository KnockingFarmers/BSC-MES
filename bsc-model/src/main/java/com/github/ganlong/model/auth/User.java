package com.github.ganlong.model.auth;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.ganlong.model.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
public class User extends BaseEntity implements UserDetails {

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

    /**
     * 死否过期
     */
    private Boolean expired;

    /**
     * 是否锁定
     */
    private Boolean locked;

    private List<Role> roles;

    /**
     * 获取用户的所有角色信息
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(Role role : roles){
            // 也可以在数据中添加角色时，就以 ROLE_ 开始，这样就不用二次添加了
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleCode()));
        }
        return authorities;
    }

    /**
     * 指定哪一个是用户的密码字段
     * @return
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * 指定哪一个是用户的账户字段
     * @return
     */
    @Override
    public String getUsername() {
        return userName;
    }


    /**
     * 判断账户是否过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return expired;
    }

    /**
     * 判断账户是否锁定
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return locked;
    }

    /**
     * 判断密码是否过期
     * 可以根据业务逻辑或者数据库字段来决定
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 判断账户是否可用
     * 可以根据业务逻辑或者数据库字段来决定
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

}
