package leet;

public class l028 {
    public static int strStr(String haystack, String needle) {
        if (needle.length()==0) return 0;
        return haystack.indexOf(needle);
    }

    public static int strStr2(String haystack, String needle) {
        if (needle.length()==0 | haystack.length()==needle.length()) return 0;
        if (haystack.length()<needle.length()) return -1;
        char[] be = haystack.toCharArray();
        char[] to = needle.toCharArray();
        int isRepeat = 1;
        for (int i1=0; i1<be.length; i1++){
            if (be[i1]==to[0]){
                for (int i2=0; i2<to.length; i2++){
                    if (be[i1]!=to[i2]) {
                        isRepeat=0;
                        break;
                    }
                }
                if (isRepeat==1) return i1;
            }
        }
        return -1;
    }
}
