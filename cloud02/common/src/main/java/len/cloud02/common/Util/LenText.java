package len.cloud02.common.Util;

public class LenText {
    public static String makeTextUseful(String str){
        str = str.replace(" ", "").replace("/", "");
        return str;
    }
}
