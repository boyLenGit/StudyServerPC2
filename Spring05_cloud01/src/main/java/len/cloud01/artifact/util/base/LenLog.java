package len.cloud01.artifact.util.base;

import java.util.Date;

public class LenLog {
    Date data = new Date();

    public static void staticInfo(String name, String content){
        String time = LenTime.ymdhms_v1();
        String print = time + " LenLog <" + name + "> Content:" + content;
        System.out.println(print);
    }
}
