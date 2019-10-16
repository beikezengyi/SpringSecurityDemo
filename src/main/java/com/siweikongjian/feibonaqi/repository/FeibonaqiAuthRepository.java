package com.siweikongjian.feibonaqi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.siweikongjian.feibonaqi.bean.entity.FeibonaqiAuth;

@Repository
public interface FeibonaqiAuthRepository extends CrudRepository<FeibonaqiAuth, Integer> {

    public List<FeibonaqiAuth> findByAuthid(String authid);
}
