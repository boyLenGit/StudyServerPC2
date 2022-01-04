package leet;

import util.LenLog;

import java.util.Arrays;

public class l005 {
    public static String longestPalindrome(String s) {
        int lengthHw = -1;
        int lengthHw_temp = 0;
        int length = s.length();
        String result = "";
        for(int i_0=0; i_0<length; i_0++){
            // 偶数情况
            if(i_0+1<length){
                if(s.charAt(i_0)==s.charAt(i_0+1)){
                    int indexHwStart = i_0;
                    int indexHwEnd = i_0 + 1;
                    lengthHw_temp = 2;
                    for(int i_1=i_0+2; i_1<length; i_1++){
                        indexHwStart = i_0 - (i_1 - i_0) + 1;
                        // 如果索引越界了
                        if(indexHwStart<0){
                            break;
                        }
                        // 如果向上遍历不是回文
                        if(s.charAt(indexHwStart)!=s.charAt(i_1)){
                            break;
                        }
                        indexHwEnd = i_1;
                        lengthHw_temp = 2 * (i_1 - i_0);
                    }
                    if(lengthHw_temp>lengthHw){
                        lengthHw = lengthHw_temp;
                        result = s.substring(indexHwStart, indexHwEnd+1);
                    }
                }
            }

            // 奇数情况
            if(i_0+1<length||i_0-1>=0){
                if(s.charAt(i_0-1)==s.charAt(i_0+1)){
                    int indexHwStart = i_0 - 1;
                    int indexHwEnd = i_0 + 1;
                    lengthHw_temp = 3;
                    for(int i_1=i_0+2; i_1<length; i_1++){
                        indexHwStart = i_0 - (i_1 - i_0);
                        indexHwEnd = i_1;
                        // 如果索引越界了
                        if(indexHwStart<0){
                            break;
                        }
                        // 如果向上遍历不是回文
                        if(s.charAt(indexHwStart)!=s.charAt(indexHwEnd)){
                            break;
                        }

                        lengthHw_temp = 2 * (i_1 - i_0);
                    }
                    if(lengthHw_temp>lengthHw){
                        lengthHw = lengthHw_temp;
                        result = s.substring(indexHwStart, indexHwEnd+1);
                    }
                }
            }

        }
        LenLog.staticInfo("longestPalindrome", String.valueOf(lengthHw));

        if (lengthHw<=0){
            result = s.substring(0,1);
        }
        return result;
    }


    public static void main(String[] args) {
        String test01 = "22e11";
        String result = longestPalindrome(test01);
        LenLog.printString(result);
    }
}
