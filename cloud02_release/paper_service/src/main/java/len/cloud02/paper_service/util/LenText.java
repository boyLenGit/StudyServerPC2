package len.cloud02.paper_service.util;

public class LenText {
    public static String makeTextUseful(String str){
        String[] dangerSign = new String[]{"/", "-"};
        for (String s : dangerSign) {
            str = str.replace(s, "");
        }
        return str;
    }
}
