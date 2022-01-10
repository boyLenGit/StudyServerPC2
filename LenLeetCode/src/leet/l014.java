package leet;

import java.util.Arrays;
import java.util.List;

public class l014 {
    public static String longestCommonPrefix(String[] strs) {
        int public_index = 0;
        String string_result = "";
        int min_length = 0;
        for (int i1=0; i1<strs.length; i1++){
            min_length = Math.min(min_length, strs[i1].length());
        }
        for (int i2=0; i2<min_length; i2++){
            for (int i3=0; i3<strs.length; i3++){
                if (i3+1<strs.length){
                    if (strs[i3].toCharArray()[i2]==strs[i3+1].toCharArray()[i2]){
                        string_result = string_result.concat(String.valueOf(strs[i3].toCharArray()[i2]));
                    }
                }
            }
        }
        return string_result;
    }

    public static void main(String[] args){
        String[] input1 = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(input1));
    }
}
