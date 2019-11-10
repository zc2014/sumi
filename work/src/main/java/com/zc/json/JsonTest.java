package com.zc.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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
//        String message = "[{\"name\":\"wm_product_name\",\"setName\":true,\"setType\":true,\"setValue\":true,\"type\":\"1\",\"value\":\"雀巢金牌咖啡(瓶装) 100g\"},{\"name\":\"wm_product_description\",\"setName\":true,\"setType\":true,\"setValue\":true,\"type\":\"1\",\"value\":\"咖啡的醇香和牛奶的甘甜美妙交融\"},{\"name\":\"wm_product_unit\",\"setName\":true,\"setType\":true,\"setValue\":true,\"type\":\"1\",\"value\":\"份\"},{\"name\":\"wm_product_spec\",\"setName\":true,\"setType\":true,\"setValue\":true,\"type\":\"1\",\"value\":\"100g\"}]";
        String message = "\t[{\"name\":\"wm_product_name\",\"setName\":true,\"setType\":true,\"setValue\":true,\"type\":\"1\",\"value\":\"顺鑫鑫源烧烤牛板筋袋装85g\"},{\"name\":\"wm_product_unit\",\"setName\":true,\"setType\":true,\"setValue\":true,\"type\":\"1\",\"value\":\"份\"}]";
//        String message = "[{\"name\":\"wm_product_name\",\"type\":\"1\",\"value\":\"情趣内衣三点猫女透视兔女郎制服极诱惑39号\"}]\t";

        for (int i = 0; i < 1; i++) {
            String data = JSON.toJSONString(message);
            System.out.println(data);
        }


        JSONArray jsonArray = JSON.parseArray(message);
        JSONArray array = new JSONArray();
        jsonArray.forEach(data -> {
            LinkedHashMap<String, Object> json = JSON.parseObject(((JSONObject)data).toJSONString(), LinkedHashMap.class, Feature.OrderedField);
            JSONObject jsonObject = new JSONObject(true);
            jsonObject.putAll(json);
            array.add(jsonObject);
        });
        System.out.println(array.toJSONString());
        JSONArray array1 = new JSONArray();

        array.forEach(data -> {
            LinkedHashMap<String, Object> json = JSON.parseObject(((JSONObject)data).toJSONString(), LinkedHashMap.class, Feature.OrderedField);
            JSONObject jsonObject = new JSONObject(true);
            jsonObject.putAll(json);
            array1.add(jsonObject);
        });
        System.out.println(array1.toJSONString());

//        LinkedHashMap<String, Object> json = JSON.parseObject(((JSONObject) JSON.parseArray(message).get(0)).toJSONString(), LinkedHashMap.class, Feature.OrderedField);
//        JSONObject jsonObject = new JSONObject(true);
//        jsonObject.putAll(json);
//        JSONArray array = new JSONArray();
//        array.add(jsonObject);
//        for (int i = 0; i < 50; i++) {
//            System.out.println(array.toJSONString());
//        }

        new Thread(() ->{

        });

    }
}
