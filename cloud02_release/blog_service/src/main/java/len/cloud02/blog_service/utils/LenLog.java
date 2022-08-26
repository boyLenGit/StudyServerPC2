package len.cloud02.blog_service.utils;

public class LenLog {

    public static void staticInfo(String name, String content){
        String time = LenTime.ymdhms_v1();
        String print = time + " LenLog <" + name + "> Content:" + content;
        System.out.println(print);
    }

    public static void info2(Class<?> classSource, String name, String content){
        String time = LenTime.ymdhms_v1();
        String print = time + " LenLog <" + classSource.getName() + "-" + name + "> Content:" + content;
        System.out.println(print);
    }
}
