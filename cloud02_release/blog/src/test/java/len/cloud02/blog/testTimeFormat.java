package len.cloud02.blog;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/7/7 12:36
 */
public class testTimeFormat {
    public static void main(String[] args) {
        String time1 = "1685005097000";
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time1));
    }
}
