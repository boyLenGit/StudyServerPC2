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
                    int pointReverse = 0;
                    int indexHwStart = 0;
                    int indexHwEnd = 0;
                    for(int i_1=i_0+2; i_1<length; i_1++){
                        pointReverse = i_0 - (i_1 - i_0);
                        // 如果索引越界了
                        if(pointReverse<0){
                            break;
                        }
                        // 如果向上遍历不是回文
                        if(s.charAt(pointReverse)!=s.charAt(i_1)){
                            break;
                        }
                        indexHwStart = i_0 - (i_1 - i_0);
                        indexHwEnd = i_1;
                        lengthHw_temp = 2 * (i_1 - i_0);
                    }
                    if(lengthHw_temp>lengthHw){
                        lengthHw = lengthHw_temp;
                        result = s.substring(indexHwStart, indexHwEnd);
                    }
                }
            }

        }
        return result;
    }


    public static void main(String[] args) {
        String test01 = "xnoony";
        String result = longestPalindrome(test01);
        LenLog.printString(result);
    }
}
