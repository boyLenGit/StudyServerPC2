package len.cloud02.experiment.utils;


import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/7/20 11:36
 */
public class TimeUtils {
    public static Timestamp stringYYMMDDHHMMSS2TimestampYYMMDDHHMMSS(String time){
        return Timestamp.valueOf(time);
    }

    public static Timestamp stringYYMMDDHHMMSS2TimestampYYMMDDHHMMSS2(String time){
        return Timestamp.valueOf(time);
    }


    public static Timestamp stringYYMMDD2TimestampYYMMDD(String time){
        return Timestamp.valueOf(time);
    }

    public static String timestampToYYMMDDHHMMSS(Long timestamp){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timestamp));
    }

    public static String timestampToYYMMDD(Long timestamp){
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(timestamp));
    }

    public static Long getNowTimeStampDivide1000L(){
        return System.currentTimeMillis() / 1000L;
    }

    public static Long getNowTimeStamp(){
        return System.currentTimeMillis();
    }
}
