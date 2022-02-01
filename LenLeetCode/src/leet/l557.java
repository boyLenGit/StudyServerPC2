package leet;

import java.util.ArrayList;

public class l557 {
    public static String reverseWords(String s) {
        // 除去最前面的空格
        int cnt_right_null = 0, cnt_left_null = s.length();
        for (int i1=0; i1<s.length() & s.charAt(i1)==' '; i1++) cnt_right_null++;
        for (int i1=s.length()-1; i1>=0 & s.charAt(i1)==' '; i1--) cnt_left_null--;
        s = s.substring(cnt_right_null, cnt_left_null);
        // 翻转
        int cnt = 0;
        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i1=0; i1<s.length(); i1++){
            if (s.charAt(i1)==' ' | i1==s.length()-1){  // 启动遍历
                if (i1==s.length()-1) temp.append(s.charAt(i1));
                temp.reverse();
                res.append(" ").append(temp);
                temp = new StringBuilder();
                continue;
            }
            temp.append(s.charAt(i1));
        }
        return res.toString();
    }

    public static void main(String[] adr){
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
