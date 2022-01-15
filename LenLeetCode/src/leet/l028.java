package leet;

public class l028 {
    public static int strStr(String haystack, String needle) {
        if (needle.length()==0) return 0;
        return haystack.indexOf(needle);
    }

    // 按照原理来写比较麻烦，最近一次错："aabaaabaaac" + "aabaaac"
    public static int strStr2(String haystack, String needle) {
        if (needle.length()==0 | (haystack.length()==needle.length() & haystack.equals(needle))) return 0;
        if (haystack.length()<=needle.length()) return -1;
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

            if (i1+1<be.length & to_cnt<to.length & to_cnt!=0){
                if (be[i1+1]!=to[to_cnt] & to_cnt!=1) {
                    to_cnt=0;
                    i1--;
                }else if (be[i1+1]!=to[to_cnt]){
                    to_cnt=0;
                }
            }
        }
        return to_cnt==needle.length() ? position : -1;
    }

    public static void main(String[] args){
        System.out.println(strStr2("mississippi", "pi"));
    }
    //"mississippi"
    //"issi"
    // "mississippi"
    //"issip"
    // "mississippi"
    //"pi"
}
