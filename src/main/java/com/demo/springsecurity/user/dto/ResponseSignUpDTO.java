package com.demo.springsecurity.user.dto;

public class ResponseSignUpDTO {
    private Long id;

    public ResponseSignUpDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
