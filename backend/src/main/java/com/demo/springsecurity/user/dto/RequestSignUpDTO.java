package com.demo.springsecurity.user.dto;

import lombok.Getter;
import lombok.Setter;

/***
 * 회원가입 요청 dto
 */
@Getter
@Setter
public class RequestSignUpDTO {
    private String username;
    private String password;
}
