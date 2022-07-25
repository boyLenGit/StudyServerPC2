package lenTest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/7/7 12:42
 */
public class lt015_DateFormat {
    public static void main(String[] args) {
        String time1 = "1685005097000";
        String time2 = "0";
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(Long.parseLong(time1))));

        String sql = "SELECT * FROM VIP_QRTZ_TRIGGERS V LEFT JOIN user_status U \n" +
                "ON SUBSTRING(V.TRIGGER_NAME, LOCATE(':', V.TRIGGER_NAME)+1, CHAR_LENGTH(V.TRIGGER_NAME)-LOCATE(':', V.TRIGGER_NAME)) = U.orderId \n" +
                "WHERE U.orderId IS NOT NULL";
        System.out.println(sql);
    }
}
