package com.siweikongjian.feibonaqi.bean.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;

@Data
@Entity(name = "user_auth")
@IdClass(value = UserAuthId.class)
public class UserAuth implements Serializable {

    @Id
    @Column(name = "openid")
    private String openid;

    @Id
    @Column(name = "authid")
    private Integer authid;

    @Column(name = "create_time")
    private String createTime;

}
