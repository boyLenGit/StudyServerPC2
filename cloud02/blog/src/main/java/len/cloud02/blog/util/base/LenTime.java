package len.cloud02.blog.util.base;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LenTime {

    public static String ymdhms_v1(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
}
