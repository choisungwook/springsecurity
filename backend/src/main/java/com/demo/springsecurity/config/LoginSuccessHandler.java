package com.demo.springsecurity.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/***
 * 로그인 성공 핸들러
 */
@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        log.debug("[로그인 성공] -> " + authentication.getName());

        // add cookie
        Cookie cookie = new Cookie("sample", "A");
        httpServletResponse.addCookie(cookie);

        // add response body
        HttpSession session = httpServletRequest.getSession();
        httpServletResponse.getWriter().write(session.getId());
        httpServletResponse.getWriter().flush();
    }
}
