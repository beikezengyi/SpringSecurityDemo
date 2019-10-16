package com.siweikongjian.feibonaqi.bean.join;

import lombok.Data;

@Data
public class UserEntity {

    private String openid;

    private String email;

    private String showingUsername;

    private String loginUsername;

    private String loginPassword;

    private String authid;

    private String authName;

    private String authorityName;
}
