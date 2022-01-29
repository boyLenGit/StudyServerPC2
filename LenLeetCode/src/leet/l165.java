package leet;

import java.util.Arrays;

public class l165 {
    public static int compareVersion(String version1, String version2) {
        String[] in1 = version1.split("\\.");
        String[] in2 = version2.split("\\.");
        // 先比较左侧
        if (Integer.parseInt(in1[0])>Integer.parseInt(in2[0])) return 1;
        else if (Integer.parseInt(in1[0])<Integer.parseInt(in2[0])) return -1;
        // 在比较左侧
        for (int i1=0; i1<Math.min(in1[1].length(), in2[1].length()); i1++){
            if ((int) in1[1].charAt(i1) > (int) in2[1].charAt(i1)) return 1;
            else if ((int) in1[1].charAt(i1) < (int) in2[1].charAt(i1)) return -1;
        }
        if (in1[1].length()==in2[1].length()) return 0;
        return in1[1].length()>in2[1].length() ? 1 : -1;
    }

    public static void main(String[] a){
        compareVersion("1.01", "1.001");
    }
}
