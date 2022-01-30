package JZoffer;

import java.util.ArrayList;
import java.util.Arrays;

public class jz038 {
    public static String[] permutation(String s) {
        char[] chars = s.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        for (int i1=0; i1<s.length(); i1++){
            res.add(String.valueOf(s.charAt(i1)));
        }
        res = dg(res, s, 0);
        String[] ret = new String[res.size()];
        for (int i1=0; i1<res.size(); i1++){
            ret[i1] = res.get(i1);
        }
        return ret;
    }

    public static ArrayList<String> dg(ArrayList<String> res, String s, int cnt){
        cnt++;
        if (cnt==s.length()) return res;
        ArrayList<String> temp = new ArrayList<>();
        for (int i1=0; i1<res.size(); i1++){
            for (int i2=0; i2<s.length(); i2++){
                if (res.get(i1).indexOf(String.valueOf(s.charAt(i2)))!=-1) temp.add(res.get(i1).concat(String.valueOf(s.charAt(i2))));
            }
        }
        res = temp;
        dg(res, s, cnt);
        return res;
    }

    public static void main(String[] ast){
        String in1 = "abc";
        System.out.println(Arrays.toString(permutation(in1)));
    }
}
