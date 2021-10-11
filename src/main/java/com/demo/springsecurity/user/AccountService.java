package com.demo.springsecurity.user;

import com.demo.springsecurity.exceptions.DataExistException;
import com.demo.springsecurity.user.dto.RequestSignUpDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService implements UserDetailsService {
    private final AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public Long save(RequestSignUpDTO requestSignUpDTO) {
        Optional<Account> find_user = accountRepository.findByUsername(requestSignUpDTO.getUsername());
        if (find_user.isPresent()) {
            throw new DataExistException("[회원가입 오류] 이미 회원이 존재합니다");
        }

        return accountRepository.save(
            Account.builder()
                .username(requestSignUpDTO.getUsername())
                .password(passwordEncoder.encode(requestSignUpDTO.getPassword()))
                .build()
        ).getId();
    }

    /***
     * 로그인 시도시 회원조회
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account find_user = accountRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("회원이 존재하지 않습니다"));
        log.debug(find_user.getUsername());
        return new AccountDetail(find_user);
    }
}
