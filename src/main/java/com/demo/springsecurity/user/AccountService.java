package com.demo.springsecurity.user;

import com.demo.springsecurity.exceptions.DataExistException;
import com.demo.springsecurity.user.dto.RequestSignUpDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    @Transactional
    public Long save(RequestSignUpDTO requestSignUpDTO) {
        Optional<Account> find_user = accountRepository.findByUsername(requestSignUpDTO.getUsername());
        if (find_user.isPresent()) {
            throw new DataExistException("[회원가입 오류] 이미 회원이 존재합니다");
        }

        return accountRepository.save(
            Account.builder()
                .username(requestSignUpDTO.getUsername())
                .password(requestSignUpDTO.getPassword())
                .build()
        ).getId();
    }

}
