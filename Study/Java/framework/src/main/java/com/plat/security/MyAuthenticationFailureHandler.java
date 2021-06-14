package com.plat.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 权限认证失败处理
 * Created by heyugang on 2021/3/11.
 */
@Component
@Slf4j
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure( HttpServletRequest request, HttpServletResponse response, AuthenticationException auth )
            throws IOException, ServletException {
        log.info("用户认证失败");
        response.sendRedirect("http://www.baidu.com");
    }
}
