package com.siweikongjian.feibonaqi.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siweikongjian.feibonaqi.bean.view.Daily;

@RestController
public class DailyController {

    @PostMapping("/api/wx/daily/create")
    public ResponseEntity<Daily> wxapi1() {
        Daily d = new Daily("2019/10/15", 12.12, 15.12, 13.12);
        return ResponseEntity.ok(d);
    }
}
