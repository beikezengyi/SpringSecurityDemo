package com.siweikongjian.feibonaqi.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.siweikongjian.feibonaqi.bean.join.UserEntity;

@Repository
@Mapper
public interface FindUserMapper {

    @Select(value = "select  " + //
            "    t1.openid, " + //
            "    t1.email, " + //
            "    t1.showing_username, " + //
            "    t1.login_username, " + //
            "    t1.login_password, " + //
            "    t2.authid, " + //
            "    t3.auth_name, " + //
            "    t3.authority_name " + //
            "from feibonaqi_user t1 " + //
            "left outer join user_auth t2 " + //
            "on(t1.openid = t2.openid) " + //
            "left outer join feibonaqi_auth t3 " + //
            "on(t2.authid = t3.authid) " + //
            "where t1.email=#{mailOrName} or login_username=#{mailOrName}")
    public List<UserEntity> findUserByMailOrName(@Param(value = "mailOrName") String mailOrName);
}
