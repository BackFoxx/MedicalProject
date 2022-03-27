package com.example.medicalProject.domain.interceptor;

import com.example.medicalProject.config.auth.PrincipalDetails;
import com.example.medicalProject.domain.entity.user.User;
import com.example.medicalProject.domain.entity.user.UserRepository;
import com.example.medicalProject.web.dto.UserInterceptorResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SecurityInterceptor implements HandlerInterceptor {
    private final UserRepository userRepository;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (!principal.equals("anonymousUser")) {
                PrincipalDetails principalDetails = (PrincipalDetails) principal;
                Optional<User> user = userRepository.findById(principalDetails.getId());
                if (user.isPresent()) {
                    UserInterceptorResponseDto responseDto = new UserInterceptorResponseDto(user.get());
                    modelAndView.addObject("loginUser", responseDto);
                }
            }
        }
    }
}
