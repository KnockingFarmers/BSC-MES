package com.github.ganlong.model.dto.auth;

import com.github.ganlong.model.auth.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/21 15:50
 * @PackageName:com.github.ganlong.model.dto.auth
 * @ClassName: LoginUserDto
 * @Description: TODO
 * @Version 1.0
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserDto extends User {

   private String token;
}
