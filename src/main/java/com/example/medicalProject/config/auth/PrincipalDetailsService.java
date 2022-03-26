package com.example.medicalProject.config.auth;

import com.example.medicalProject.domain.entity.user.User;
import com.example.medicalProject.domain.entity.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
1. 시큐리티 설정에서 loginProcessingUrl("/login")
2. /login 요청이 오면 자동으로 UserDetailsService 타입으로 Ioc 되어있는 loadUserByUsername 함수가 실행
 */

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    //시큐리티 Session(Authentication(내부에 UserDetails 가 쏙 들어감) 가 쏙 들어감)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return new PrincipalDetails(user);
        }
        return null;
    }
    // 로그인 폼에서 username 폼의 이름을 username으로 하지 않으면 위 함수에 매칭되지 않는다.
}
