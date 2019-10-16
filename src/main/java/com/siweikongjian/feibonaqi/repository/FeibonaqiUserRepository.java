package com.siweikongjian.feibonaqi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.siweikongjian.feibonaqi.bean.entity.FeibonaqiUser;

@Repository
public interface FeibonaqiUserRepository extends CrudRepository<FeibonaqiUser, String> {

    public FeibonaqiUser findByEmail(String email);

    public FeibonaqiUser findByLoginUsername(String loginUsername);

}
