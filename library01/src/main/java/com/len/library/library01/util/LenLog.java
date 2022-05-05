package com.len.library.library01.util;

public class LenLog {
    public static void info(String funcName, String content){
        String time = LenTime.ymdhms_v1();
        String print = time + " LenLog <" + funcName + "> Content:" + content;
        System.out.println(print);
    }
}
