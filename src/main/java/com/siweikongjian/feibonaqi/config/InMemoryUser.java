package com.siweikongjian.feibonaqi.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InMemoryUser extends User {

    private String email;

    private String openid;

    private String showingUsername;

    public InMemoryUser(String username, String password, String email, String openid, String showingUsername, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.email = email;
        this.openid = openid;
        this.showingUsername = showingUsername;
    }

    @Override
    public String toString() {
        String format = "openid=%s,email=%s,showingUsername=%s,username=%s,password=[protected],authorities=%s";
        return String.format(format, openid, email, showingUsername, getUsername(), getAuthorities());
    }

}
