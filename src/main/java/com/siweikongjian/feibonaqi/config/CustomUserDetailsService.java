package com.siweikongjian.feibonaqi.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;
import org.thymeleaf.util.ListUtils;

import com.siweikongjian.feibonaqi.bean.join.UserEntity;
import com.siweikongjian.feibonaqi.repository.FindUserMapper;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private FindUserMapper findUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("username is empty");
        }
        List<UserEntity> userEntityList = findUserMapper.findUserByMailOrName(username);
        if (ListUtils.isEmpty(userEntityList)) {
            throw new UsernameNotFoundException(username + " not found.");
        }
        UserEntity user = userEntityList.get(0);
        List<SimpleGrantedAuthority> roleList = userEntityList.stream().map(s -> {
            String roleName = s.getAuthorityName().trim();
            return new SimpleGrantedAuthority(roleName);
        }).collect(Collectors.toList());
        InMemoryUser inmemoryUser = new InMemoryUser(user.getLoginUsername(), user.getLoginPassword().trim(), user.getEmail(), user.getOpenid(), user.getShowingUsername(), roleList);
        return inmemoryUser;
    }

}
