package com.zc.example.base;

/**
 * @author by zc21
 * @Description TODO
 * @Date 2019-11-02 21:36
 */
public class ReturnDemo {
    public static void main(String[] args) {
        System.out.println("start");
        returnMethod();
        System.out.println("end");
        System.out.println(Runtime.getRuntime().availableProcessors());//8
    }

    private static void returnMethod() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            if (i == 3) {
                return;
            }
        }
    }
}
