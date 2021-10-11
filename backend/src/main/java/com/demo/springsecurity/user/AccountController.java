package com.demo.springsecurity.user;

import com.demo.springsecurity.exceptions.DataExistException;
import com.demo.springsecurity.exceptions.ErrorResponse;
import com.demo.springsecurity.user.dto.RequestSignUpDTO;
import com.demo.springsecurity.user.dto.ResponseSignUpDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/users")
    public ResponseSignUpDTO SignUp(@RequestBody RequestSignUpDTO requestSignUpDTO) {
        log.debug("회원가입 요청");
        Long save_id = accountService.save(requestSignUpDTO);

        return new ResponseSignUpDTO(save_id);
    }

    /***
     * 데이터가 이미 데이터베이스에 존재하는 경우 에러처리
     * @param e
     * @return
     */
    @ExceptionHandler(DataExistException.class)
    public ResponseEntity<ErrorResponse> DataExistExceptionHandler(DataExistException e){
        String message = "이미 데이터가 존재합니다";
        List<String> errors = new ArrayList<>();
        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Type",  "application/json;charset=UTF-8");
        errors.add(e.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT, message, errors);

        log.error(String.format("%s %s", message, e.getMessage()));

        return new ResponseEntity<>(
            errorResponse,
            headers,
            errorResponse.getStatus()
        );
    }
}
