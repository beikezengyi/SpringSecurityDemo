package com.siweikongjian.feibonaqi.component;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.siweikongjian.feibonaqi.config.InMemoryUser;

@RequestScope
@Component
public class SecurityComponent {

    public InMemoryUser getInMemoryUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        if (authentication.isAuthenticated()) {
            return (InMemoryUser) authentication.getPrincipal();
        } else {
            return null;
        }
    }
}
