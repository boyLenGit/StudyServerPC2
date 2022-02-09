package JZoffer;

public class jz005 {
    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i1=0; i1<s.length(); i1++){
            if (s.charAt(i1)==' ') sb.append("%20");
            else sb.append(s.charAt(i1));
        }
        return sb.toString();
    }

    public static String replaceSpace2(String s) {
        return s.replace(" ", "%20");
    }
}
