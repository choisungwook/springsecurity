package com.demo.springsecurity.controller;

import com.demo.springsecurity.user.AccountDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;

@RestController
@Slf4j
public class DemoController {

    @GetMapping("/session")
    public ResponseCookieDTO hello(@AuthenticationPrincipal AccountDetail user, HttpSession HttpSession) {
        log.debug("세션정보 조회 API 요청");
        String username = "empty";
        String session_id = "empty";

        if (user == null){
            System.out.println("user is null");
        } else {
            session_id = HttpSession.getId();
            username = user.getUsername();
        }
        log.debug("[세션정보조회] " + session_id);
        log.debug("[세션정보조회] " + username);
        log.debug("세션정보 조회 API 종료");

        return new ResponseCookieDTO(username, session_id);
    }
}
