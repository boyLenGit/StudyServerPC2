package len.cloud02.front.utils;

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
        String split = str.replace("#", "").replace("\\n", "");
        return split.substring(0, Math.min(split.length()-1, BLOG_INFO_LEN)) + "...(点开查看详情)";
    }
}
