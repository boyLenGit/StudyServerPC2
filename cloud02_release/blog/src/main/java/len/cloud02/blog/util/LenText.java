package len.cloud02.blog.util;

public class LenText {
    private static final Integer BLOG_INFO_LEN = 150;

    public static String makeTextUseful(String str){
        String[] dangerSign = new String[]{"/", "-"};
        for (String s : dangerSign) {
            str = str.replace(s, "");
        }
        return str;
    }

    public static String makeBlogInfo(String str){
        return str.replace("#", "").replace("\\n", "").substring(0, Math.min(str.length(), BLOG_INFO_LEN)) + "...(点开查看详情)";
    }
}
