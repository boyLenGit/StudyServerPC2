package len.cloud02.blog.util.base;

import java.util.Date;

public class LenLog {

    public static void staticInfo(String name, String content){
        String time = LenTime.ymdhms_v1();
        String print = time + " LenLog <" + name + "> Content:" + content;
        System.out.println(print);
    }
}
