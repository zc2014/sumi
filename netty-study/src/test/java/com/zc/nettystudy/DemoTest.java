package com.zc.nettystudy;

import static io.netty.util.internal.ObjectUtil.checkNotNull;

/**
 * @author by zc21
 * @Description TODO
 * @Date 2019-11-13 07:39
 */
public class DemoTest {

    public static <T> T checkNotNull(T arg, String text) {
        if (arg == null) {
            throw new NullPointerException(text);
        }
        return arg;
    }

     Class<?> getClazz() {
        return getClass();
    }

    public static void main(String[] args) {
//        Class<?> clazz = null;
        Class<?> clazz = new DemoTest().getClazz();
        String className = checkNotNull(clazz, "clazz").getName();
        System.out.println(className);
        int lastIndexOf = className.lastIndexOf(".");
        if (lastIndexOf > 0) {
            String substring = className.substring(lastIndexOf + 1);
            System.out.println(substring);
        }
  /**
        final int lastDotIdx = className.lastIndexOf(PACKAGE_SEPARATOR_CHAR);
        if (lastDotIdx > -1) {
            return className.substring(lastDotIdx + 1);
        }
        return className;
   */
    }
}
