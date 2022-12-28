package com.github.ganlong.vo.auth;

import com.github.ganlong.model.auth.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/21 15:50
 * @PackageName:com.github.ganlong.model.dto.auth
 * @ClassName: LoginUserVo
 * @Description: TODO
 * @Version 1.0
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserVo extends User {

   private String token;
}
