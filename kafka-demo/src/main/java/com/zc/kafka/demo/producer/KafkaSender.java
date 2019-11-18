package com.zc.kafka.demo.producer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zc.kafka.demo.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Component
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    /**
     * send msg
     */
    public void send() {
        Message message = Message.builder().id(System.currentTimeMillis())
                .msg(UUID.randomUUID().toString()).sendTime(new Date()).build();
        log.info("+++++++++++++++++++++  message = {}", gson.toJson(message));
//        kafkaTemplate.send("", gson.toJson(message));


        ListenableFuture<SendResult<String, String>> future =  kafkaTemplate.send("test",gson.toJson(message));
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("发送消息失败:" + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> sendResult) {
                System.out.println("发送结果:" + sendResult.toString());
            }
        });


    }
}
