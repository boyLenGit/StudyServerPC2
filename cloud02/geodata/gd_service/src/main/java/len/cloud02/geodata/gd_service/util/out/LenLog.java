package len.cloud02.geodata.gd_service.util.out;


import len.cloud02.geodata.gd_service.util.time.LenTime;

import java.util.Date;

public class LenLog {
    Date data = new Date();

    public static void staticInfo(String name, String content){
        String time = LenTime.ymdhms_v1();
        String print = time + " LenLog <" + name + "> Content:" + content;
        System.out.println(print);
    }
}
