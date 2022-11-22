package com.github.ganlong.auth.config;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author ganlong
 * @Date 2022/11/14 21:38
 * @ClassName: MyAccessDeniedHandler
 * @Description: 访问资源无权异常
 * @Version 1.0
 */
@Component
public class AccessDeniedHandlerConfig implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setStatus(403);
        response.getWriter().write("Forbidden:" + accessDeniedException.getMessage());
    }
}
