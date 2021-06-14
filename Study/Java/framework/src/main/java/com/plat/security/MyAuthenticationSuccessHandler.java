package com.plat.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 权限认证成功处理
 * Created by heyugang on 2021/3/11.
 */
@Component
@Slf4j
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    // 用户认证成功
    @Override
    public void onAuthenticationSuccess( HttpServletRequest req, HttpServletResponse res, Authentication auth )
            throws IOException, ServletException {
        log.info("用户登陆成功");
        res.sendRedirect("/");
    }
}
