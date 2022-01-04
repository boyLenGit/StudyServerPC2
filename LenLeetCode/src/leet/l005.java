package leet;

import java.util.Arrays;

public class l005 {
    public static String longestPalindrome(String s) {
        int[] char_table = new int[256];
        Arrays.fill(char_table, -1);

        int indexHwArea = 0;
        int length = s.length();
        int[] input_list = new int[length];
        Arrays.fill(input_list, 0);
        for(int i_0=0; i_0<length; i_0++){
            int char_raw = s.charAt(i_0);
            // 偶数情况
            if(i_0+1<length || s.charAt(i_0)==s.charAt(i_0+1)){
                int pointReverse = 0;
                for(int i_1=i_0+2; i_1<length; i_1++){
                    pointReverse = i_0 - (i_1 - i_0);
                    if(pointReverse<0){
                        break;
                    }
                    // 如果想上遍历还是回文
                    if(s.charAt(pointReverse)==s.charAt(i_1))
                    return "";
                }
            }





        }
        return null;
    }
}
