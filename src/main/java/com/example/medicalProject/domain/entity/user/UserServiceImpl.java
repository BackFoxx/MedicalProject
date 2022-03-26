package com.example.medicalProject.domain.entity.user;

import com.example.medicalProject.web.dto.UserRegistrationRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder pwdEncoder;

    @Override
    public void registration(UserRegistrationRequestDto user) {
        String encodedPwd = pwdEncoder.encode(user.getPassword());
        user.setPassword(encodedPwd);
        userRepository.save(user.toEntity());
    }
}
