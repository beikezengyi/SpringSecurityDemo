package com.siweikongjian.feibonaqi.bean.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Data;

@Data
public class UserAuthId implements Serializable {

    @Id
    @Column(name = "openid")
    private String openid;

    @Id
    @Column(name = "authid")
    private Integer authid;

}
