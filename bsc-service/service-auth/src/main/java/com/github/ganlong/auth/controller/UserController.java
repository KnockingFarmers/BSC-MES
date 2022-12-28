package com.github.ganlong.auth.controller;


import com.github.ganlong.auth.service.UserService;
import com.github.ganlong.vo.auth.LoginUserVo;
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
@RequestMapping("/oauth/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Object login(LoginUserVo loginUserDto){
        return userService.login(loginUserDto);
    }




//    @PostMapping("/render")
//    public void renderAuth(HttpServletResponse response) throws IOException {
//         userService.renderAuth(response);
//    }
//
//
//    @PostMapping("/callback")
//    public Object login(AuthCallback callback){
//        return userService.login(callback);
//    }


    
}

