package leet;

import java.util.Arrays;
import java.util.List;

public class l014 {
    public static String longestCommonPrefix(String[] strs) {
        String string_result = "";
        int min_length = 0;
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
            if (isRepeat){
                string_result = string_result.concat(String.valueOf(strs[0].toCharArray()[i2]));
            }
        }
        return string_result;
    }

    public static void main(String[] args){
        String[] input1 = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(input1));
    }
}
