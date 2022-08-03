package lenTest;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/2 21:43
 */
public class lt017_TimeUtils {
    public static void main(String[] args) {
        System.out.println(timestampToHH(YYMMDDToTimestamp("2022-12-12")));;
    }

    /**
     * 字符串"年-月-日  时:分:秒"转换为1670818332000
     *
     * @param time 时间
     * @return {@link Timestamp}
     */
    public static Long YYMMDDHHMMSSToTimestamp(String time){
        return Timestamp.valueOf(time).getTime();
    }

    /**
     * 字符串"年-月-日"转换为1670818332000
     *
     * @param time 时间
     * @return {@link Timestamp}
     */
    public static Long YYMMDDToTimestamp(String time){
        return Timestamp.valueOf(time+" 00:00:00").getTime();
    }

    /**
     * 时间戳转换为年-月-日 时:分:秒
     *
     * @param timestamp 时间戳
     * @return {@link String}
     */
    public static String timestampToYYMMDDHHMMSS(Long timestamp){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timestamp));
    }

    /**
     * 时间戳转换为年-月-日 时:分:秒
     *
     * @param timestamp 时间戳
     * @return {@link String}
     */
    public static String timestampToHH(Long timestamp){
        return new SimpleDateFormat("HH").format(new Date(timestamp));
    }

    /**
     * 时间戳转换为年-月-日
     *
     * @param timestamp 时间戳
     * @return {@link String}
     */
    public static String timestampToYYMMDD(Long timestamp){
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(timestamp));
    }

    /**
     * 现在时间戳/1000后的结果
     *
     * @return {@link Long}
     */
    public static Long getNowTimeStampDivide1000L(){
        return System.currentTimeMillis() / 1000L;
    }

    /**
     * 获取当前时间，格式时间戳
     *
     * @return {@link Long}
     */
    public static Long getNowTimeStamp(){
        return System.currentTimeMillis();
    }

    /**
     * 时间戳转换为秒
     *
     * @return {@link Long}
     */
    public static Long TimeStampToSecond(Long timeStamp){
        return timeStamp / 1000L;
    }

    /**
     * 时间戳转换为分钟
     *
     * @return {@link Long}
     */
    public static Long TimeStampToMinute(Long timeStamp){
        return timeStamp / 1000L / 60L;
    }

    /**
     * 时间戳转换为小时
     *
     * @return {@link Long}
     */
    public static Long TimeStampToHour(Long timeStamp){
        return timeStamp / 1000L / 60L / 60L;
    }

    /**
     * 时间戳转换为天
     *
     * @return {@link Long}
     */
    public static Long TimeStampToDay(Long timeStamp){
        return timeStamp / 1000L / 60L / 60L / 24L;
    }
}
