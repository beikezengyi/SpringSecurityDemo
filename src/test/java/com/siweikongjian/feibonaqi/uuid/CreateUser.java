package com.siweikongjian.feibonaqi.uuid;

import java.util.UUID;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CreateUser {

    @Test
    public void test001() {
        String uuid = UUID.randomUUID().toString();
        String password = "jbcc";
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode(password));
        System.out.println(uuid);
        System.out.println(uuid.length());
    }
}
