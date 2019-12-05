package com.zc.elasticsearch.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestChar {

    public static void main(String[] args) {
        String str = "火/因";
        Pattern pattern = Pattern.compile("[`~!@#$%^&*()_\\-+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]");
        Matcher matcher = pattern.matcher(str);
        boolean result = false;
        while (matcher.find()) {
            result = true;
            str = str.replace(matcher.group(), "");
        }
        System.out.println(result + "--->" + str);
    }
}
