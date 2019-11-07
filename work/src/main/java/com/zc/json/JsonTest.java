package com.zc.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

import java.util.LinkedHashMap;

/**
 * @author by zc21
 * @Description TODO
 * @Date 2019-11-07 10:33
 */
public class JsonTest {
    public static void main(String[] args) {
        String message = "{\"a\":\"zhoucong\",\"c\":\"man\",\"d\":\"beijing\",\"b\":\"abandon\"}";
        for (int i = 0; i < 1; i++) {
            String data = JSON.toJSONString(message);
            System.out.println(data);
        }


        LinkedHashMap<String, Object> json = JSON.parseObject(message,LinkedHashMap.class, Feature.OrderedField);
        JSONObject jsonObject=new JSONObject(true);
        jsonObject.putAll(json);
        for (int i = 0; i < 50; i++) {
            System.out.println(jsonObject.toJSONString());
        }
    }
}
