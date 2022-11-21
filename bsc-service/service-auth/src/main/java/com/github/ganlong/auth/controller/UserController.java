package com.github.ganlong.auth.controller;


import com.github.ganlong.auth.service.UserService;
import com.github.ganlong.model.auth.User;
import com.github.ganlong.model.dto.auth.LoginUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ganlong
 * @since 2022-11-15
 */
@RestController
@RequestMapping("/auth/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(LoginUserDto loginUserDto){
        return userService.login(loginUserDto);
    }
    
}

