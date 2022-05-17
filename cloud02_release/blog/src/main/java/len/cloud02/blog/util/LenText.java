package len.cloud02.blog.util;

public class LenText {
    public static String makeTextUseful(String str){
        String[] dangerSign = new String[]{"/", "-"};
        for (String s : dangerSign) {
            str = str.replace(s, "");
        }
        return str;
    }

    public static String makeBlogInfo(String str){
        return str.replace("#", "").substring(0, Math.min(str.length(), 150));
    }
}
