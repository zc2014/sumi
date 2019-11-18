package com.zc.kafka.demo.entity;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Message {

    private Long id;    //id
    private String msg; //消息
    private Date sendTime;  //时间戳
}
