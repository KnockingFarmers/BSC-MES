package com.github.ganlong.auth.filter;

import com.github.ganlong.auth.service.UserService;
import com.github.ganlong.commons.uitl.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Token过滤器
 * desc:验证请求Token合法性
 *
 * @author GL
 */
@Component
public class TokenPerRequestFilter extends OncePerRequestFilter {

    @Autowired
    private UserService userService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token属性
        String token = request.getHeader("token");
        if (StringUtils.isNotEmpty(token)) {
            //解析Token获取载荷
            Claims claims = JwtTokenUtil.analyzeTokenData(token);

            /**
             * 获取用户信息 在创建Token Subject是传入json
             * 这里可以获取你json值 Subject是可以任何，怎么set 就怎么get
             */
            String userName = claims.getSubject();
            UserDetails userDetails = userService.loadUser(userName);
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities());

            //放入上下文
            SecurityContextHolder.getContext()
                    .setAuthentication(authenticationToken);

        }

        //放行
        filterChain.doFilter(request, response);
    }
}
