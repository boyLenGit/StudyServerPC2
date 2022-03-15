package leet;

import util.LenLog;

import java.util.Arrays;

public class l006 {
    public static String convert(String s, int numRows) {
        char[][] chars_2v = new char[numRows][];
        int length = s.length();
        int length_s_2v = s.length();
        // 生成全是0的二维矩阵
        for(int i1=0; i1<numRows; i1++){
            char[] chars_temp = new char[length_s_2v];
            Arrays.fill(chars_temp, '0');
            chars_2v[i1] = chars_temp;
        }
        // 竖向生成内容
        int index_1v = 0;
        int index_2v = 0;
        for(int i0=0; i0<length; i0++){
            // index_1v与index_2v更新
            if(index_1v>=numRows){
                index_1v=0;
                index_2v++;

                // 如果是要保存单列的char
                for (int i2=numRows-1-1; i2>0; i2--){
                    chars_2v[i2][index_2v] = s.charAt(i0);
                    index_2v++;
                    i0++;
                    if(i0>=length){
                        break;
                    }
                }
            }
            // 保存列的内容
            if(i0>=length){  // 检查防止溢出
                break;
            }
            chars_2v[index_1v][index_2v] = s.charAt(i0);
            index_1v++;
        }

        // 将生成的竖向数组进行横向读取，变为Z字形字符串
        String result_temp = "";
        for (char[] chars : chars_2v) {
            result_temp = result_temp.concat(String.valueOf(chars));
        }
        // 剔除包含0的char
        char[] chars_result_temp = result_temp.toCharArray();
        String result = "";
        for (char c : chars_result_temp) {
            if (c == '0') {
                continue;
            }
            result = result.concat(String.valueOf(c));
        }
        return result;
    }
    /*
    执行用时：473 ms, 在所有 Java 提交中击败了5.17% 的用户
    内存消耗：46.8 MB, 在所有 Java 提交中击败了5.00% 的用户
    通过测试用例：1157 / 1157
    */


    public static void main(String[] args) {
        String test01 = "ABCD";
        String result = convert(test01, 3);
        LenLog.printString(result);
    }
}
