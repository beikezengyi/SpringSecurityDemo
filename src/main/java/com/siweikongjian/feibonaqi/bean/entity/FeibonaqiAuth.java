package com.siweikongjian.feibonaqi.bean.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "feibonaqi_auth")
public class FeibonaqiAuth implements Serializable {

    @Id
    @Column(name = "authid")
    private Integer authid;

    @Column(name = "auth_name")
    private String authName;

    @Column(name = "authority_name", unique = true)
    private String authorityName;
}
