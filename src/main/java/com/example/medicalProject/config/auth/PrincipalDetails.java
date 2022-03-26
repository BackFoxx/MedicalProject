package com.example.medicalProject.config.auth;

import com.example.medicalProject.domain.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/*
1. 시큐리티가 로그인을 진행시킨다.
2. 로그인이 완료되면 시큐리티 Session을 만들어준다. (Security ContextHolder)
3. Session에는 Authentication 객체만 들어갈 수 있다.
4. Authentication 안에 UserDetails 타입의 User 정보가 있어야 한다.
[Security Session => Authentication => UserDetails]
 */

//Authentication 안에 넣을 수 있는 UserDetails 의 구현체
@RequiredArgsConstructor
public class PrincipalDetails implements UserDetails {

    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(() -> String.valueOf(user.getRole()));
        return collect;
    } // 해당 유저의 권한을 리턴

    public Long getId() {
        return user.getId();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    } // 계정의 non 만료여부

    @Override
    public boolean isAccountNonLocked() {
        return true;
    } // 계정의 non 잠김여부

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    } // 계정이 non 너무 오래 사용되었는지 여부

    @Override
    public boolean isEnabled() {
        return true;
    } // 계정 활성화 여부
}
