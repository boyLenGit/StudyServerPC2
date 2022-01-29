package leet;

import java.util.ArrayList;
import java.util.Arrays;

public class l165 {
    public static int compareVersion(String version1, String version2) {
        String[] in1 = version1.split("\\.");
        String[] in2 = version2.split("\\.");
        // 先比较左侧
        if (Integer.parseInt(in1[0])>Integer.parseInt(in2[0])) return 1;
        else if (Integer.parseInt(in1[0])<Integer.parseInt(in2[0])) return -1;
        // 在比较左侧
        for (int i0=1; i0<Math.min(in1.length, in2.length); i0++){
            in1[i0] = clearStrZero(in1[i0]);
            in2[i0] = clearStrZero(in2[i0]);
            if (in1[i0].length()>in2[i0].length()) return 1;
            else if (in1[i0].length()<in2[i0].length()) return -1;
            for (int i1=0; i1<Math.min(in1[1].length(), in2[1].length()); i1++){
                if ((int) in1[i0].charAt(i1) > (int) in2[i0].charAt(i1)) return 1;
                else if ((int) in1[i0].charAt(i1) < (int) in2[i0].charAt(i1)) return -1;
            }
        }
        if (calTrueLength(in1)==calTrueLength(in2)) return 0;
        return calTrueLength(in1)>calTrueLength(in2) ? 1 : -1;
    }

    public static String clearStrZero(String in){
        int cnt = 0;
        while (in.charAt(cnt)=='0' & cnt<in.length()-1) cnt++;
        return in.substring(cnt);
    }

    public static int calTrueLength(String[] in){
        int cnt = 0;
        for (String str:in) if (!clearStrZero(str).equals("0")) cnt++;
        return cnt;
    }

    public int compareVersion_leetcode(String version1, String version2) {
        // 跟我的思路一样, 只不过他转化为int对比, 不如我的方法, 他这个方法不能应对版本号很长超过Int极限的情况
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");

        for(int n = 0; n < Math.max(a1.length, a2.length); n++){
            int i = (n < a1.length ? Integer.parseInt(a1[n]) : 0);
            int j = (n < a2.length ? Integer.parseInt(a2[n]) : 0);
            if(i < j) return -1;
            else if(i > j) return 1;
        }
        return 0;
    }

    public static void main(String[] a){
        String str1 = "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000";
        String str2 = "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000";
        System.out.println(compareVersion(str1, str2));
    }
}
//"1.2"
//"1.10"
// "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000"
// "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000"