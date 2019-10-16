package com.siweikongjian.feibonaqi.bean.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "feinonaqi_user")
public class FeibonaqiUser implements Serializable {

    @Id
    @Column(name = "openid")
    private String openid;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "login_username", unique = true)
    private String loginUsername;

    @Column(name = "login_password")
    private String loginPassword;

    @Column(name = "create_time")
    private String createTime;

}
