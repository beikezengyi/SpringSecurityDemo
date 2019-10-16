package com.siweikongjian.feibonaqi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.siweikongjian.feibonaqi.bean.entity.UserAuth;
import com.siweikongjian.feibonaqi.bean.entity.UserAuthId;

@Repository
public interface UserAuthRepository extends CrudRepository<UserAuth, UserAuthId> {

    public List<UserAuth> findByOpenid(String openid);
}
