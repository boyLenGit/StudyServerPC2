package leet;

import java.util.Arrays;
import java.util.List;

public class l014 {
    public static String longestCommonPrefix(String[] strs) {
        String string_result = "";
        int min_length = strs[0].length();
        char compare = ' ';
        boolean isRepeat;
        for (int i1=0; i1<strs.length; i1++){
            min_length = Math.min(min_length, strs[i1].length());
        }
        for (int i2=0; i2<min_length; i2++){
            compare = strs[0].toCharArray()[i2];
            isRepeat = true;
            for (int i3=1; i3<strs.length; i3++){
                if (strs[i3].toCharArray()[i2]!=compare){
                    isRepeat = false;
                    break;
                }
            }
            if (!isRepeat){
                break;
            }
            string_result = string_result.concat(String.valueOf(strs[0].toCharArray()[i2]));
        }
        return string_result;
    }


    public static String longestCommonPrefix_len2(String[] strs) {
        String string_result = "";
        int min_length = strs[0].length();
        char compare = ' ';
        for (int i1=0; i1<strs.length; i1++){
            min_length = Math.min(min_length, strs[i1].length());
        }
        for (int i2=0; i2<min_length; i2++){
            compare = strs[0].toCharArray()[i2];
            for (int i3=1; i3<strs.length; i3++){
                if (strs[i3].toCharArray()[i2]!=compare){
                    return string_result;
                }
            }
            string_result = string_result.concat(String.valueOf(strs[0].toCharArray()[i2]));
        }
        return string_result;
    }


    public String longestCommonPrefix_leetcode(String[] strs) {
        if(strs.length==0)return "";
        //公共前缀比所有字符串都短，随便选一个先
        String s=strs[0];
        for (String string : strs) {
            while(!string.startsWith(s)){
                if(s.length()==0)return "";
                //公共前缀不匹配就让它变短！
                s=s.substring(0,s.length()-1);
            }
        }
        return s;
    }

    public static void main(String[] args){
        String[] input1 = {"","racecar","car"};
        System.out.println(longestCommonPrefix(input1));
    }
}
