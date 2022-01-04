package leet;

import util.LenLog;

import java.util.Arrays;

public class l005 {
    public static String longestPalindrome(String s) {
        if (s.length()==0){
            return "";
        }

        int lengthHw = -1;
        int lengthHw_temp = 0;
        int length = s.length();
        String result = "";
        for(int i_0=0; i_0<length; i_0++){
            // 偶数情况
            if(i_0+1<length){
                if(s.charAt(i_0)==s.charAt(i_0+1)){
                    int indexHwStart = i_0;
                    int indexHwStart_temp;
                    int indexHwEnd = i_0 + 1;
                    int indexHwEnd_temp;
                    lengthHw_temp = 2;
                    for(int i_1=i_0+2; i_1<length; i_1++){
                        indexHwStart_temp = i_0 - (i_1 - i_0) + 1;
                        indexHwEnd_temp = i_1;
                        // 如果索引越界了
                        if(indexHwStart_temp<0){
                            break;
                        }
                        // 如果向上遍历不是回文
                        if(s.charAt(indexHwStart_temp)!=s.charAt(indexHwEnd_temp)){
                            break;
                        }
                        indexHwStart = indexHwStart_temp;
                        indexHwEnd = indexHwEnd_temp;
                        lengthHw_temp = 2 * (i_1 - i_0);
                    }
                    if(lengthHw_temp>lengthHw){
                        lengthHw = lengthHw_temp;
                        result = s.substring(indexHwStart, indexHwEnd+1);
                    }
                }
            }

            // 奇数情况
            if(i_0+1<length & i_0-1>=0){
                if(s.charAt(i_0-1)==s.charAt(i_0+1)){
                    int indexHwStart = i_0 - 1;
                    int indexHwStart_temp;
                    int indexHwEnd = i_0 + 1;
                    int indexHwEnd_temp;
                    lengthHw_temp = 3;
                    for(int i_1=i_0+2; i_1<length; i_1++){
                        indexHwStart_temp = i_0 - (i_1 - i_0);
                        indexHwEnd_temp = i_1;
                        // 如果索引越界了
                        if(indexHwStart_temp<0){
                            break;
                        }
                        // 如果向上遍历不是回文
                        if(s.charAt(indexHwStart_temp)!=s.charAt(indexHwEnd_temp)){
                            break;
                        }
                        indexHwStart = indexHwStart_temp;
                        indexHwEnd = indexHwEnd_temp;
                        lengthHw_temp = 2 * (i_1 - i_0) + 1;
                    }
                    if(lengthHw_temp>lengthHw){
                        lengthHw = lengthHw_temp;
                        result = s.substring(indexHwStart, indexHwEnd+1);
                    }
                }
            }

        }
        //LenLog.staticInfo("longestPalindrome", String.valueOf(lengthHw));
        if (lengthHw<=0){
            result = s.substring(0,1);
        }
        return result;
    }
    /*执行结果： 通过
    执行用时：27 ms, 在所有 Java 提交中击败了72.76% 的用户
    内存消耗：38.3 MB, 在所有 Java 提交中击败了87.92% 的用户
    通过测试用例：180 / 180
    */


    public static void main(String[] args) {
        String test01 = "babad";
        String result = longestPalindrome(test01);
        LenLog.printString(result);
    }
}
