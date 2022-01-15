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
        int position = 0;
        int to_cnt = 0;
        for (int i1=0; i1<be.length; i1++){
            if (be[i1]==to[to_cnt]){
                if (to_cnt==0) position = i1;
                to_cnt++;
                if (to_cnt>=needle.length()) break;
            }else to_cnt = 0;

            if (i1+1<be.length & to_cnt<to.length) if (be[i1+1]!=to[to_cnt]) to_cnt=0;
        }
        return to_cnt==needle.length() ? position : -1;
    }

    public static void main(String[] args){
        System.out.println(strStr2("mississippi", "issip"));
    }
    //"mississippi"
    //"issi"
    // "mississippi"
    //"issip"
}
