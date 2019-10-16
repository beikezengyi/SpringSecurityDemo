package com.siweikongjian.feibonaqi.bean.view;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Daily {

    private String dailyTime;

    private double breakfast;

    private double before;

    private double after;
}
