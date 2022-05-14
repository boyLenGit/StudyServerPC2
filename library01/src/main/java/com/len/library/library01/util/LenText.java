package com.len.library.library01.util;

public class LenText {
    public static String makeTextUseful(String str){
        String[] dangerSign = new String[]{"/", "-"};
        for (String s : dangerSign) {
            str = str.replace(s, "");
        }
        return str;
    }

    public static String makeImageNameSafe(String name){
        String[] strings = name.split("\\.");
        String result = name.hashCode()+strings[strings.length-1];
        return result;
    }
}
