package com.zc.nettystudy;

import lombok.Builder;
import lombok.Data;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author by zc21
 * @Description TODO
 * @Date 2019-11-14 14:54
 */
public class UrlTest {

    @Test
    public void testHttpReplace() {
        String urlStr = "http://p1.meituan.net/waimaipoi/c38521a0b50c99e0a99d63284d243401284058.jpg";
        String https = urlStr.replaceFirst("^http", "https");
        System.out.println(https);
        List<A> aList = Lists.newArrayList(
                A.builder().id(1).name("aa").url("http://aa.http.jpg").build(),
                A.builder().id(2).name("bb").url("http://bb.http.jpg").build(),
                A.builder().id(3).name("cc").url("http://cc.http.jpg").build(),
                A.builder().id(4).name("dd").url("http://dd.http.jpg").build()
                );
        aList.forEach(a -> {
            a.setUrl(UrlTest.http2https(a.getUrl()));
        });
        System.out.println(aList);
    }

    @Data
    @Builder
    public static class A {
        private int id;
        private String name;
        private String url;
    }

    static String http2https(String url) {
        return url.replaceFirst("^http", "https");
    }
}
