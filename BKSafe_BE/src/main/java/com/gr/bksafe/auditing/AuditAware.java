package com.gr.bksafe.auditing;

import com.gr.bksafe.entity.User;
import lombok.NonNull;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 30/10/2023
 * @Time: 02:23
 */
@Component
public class AuditAware implements AuditorAware<Integer> {
    @NonNull
    @Override
    public Optional<Integer> getCurrentAuditor() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        return Optional.ofNullable(authentication)
                .filter(Authentication::isAuthenticated)
                .filter(auth -> !(auth instanceof AnonymousAuthenticationToken))
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .map(User::getId);
    }
}
