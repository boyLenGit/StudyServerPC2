package leet;

import java.math.BigInteger;
import java.util.ArrayList;

public class l043 {
    public static String multiply(String num1, String num2) {
        String num_long = num1.length()>=num2.length() ? num1: num2;
        String num_short = num1.length()>=num2.length() ? num2: num1;
        int over;
        int temp, temp1;
        String res = "0";
        for (int i0=num_short.length()-1, i0_zero=0; i0>=0; i0--, i0_zero++){
            char[] chars_long = num_long.toCharArray();
            int factor = Char2Int(num_short.charAt(i0));
            String right = "";
            over = 0;
            for (int i1=num_long.length()-1; i1>=0; i1--){
                temp1 = Char2Int(chars_long[i1]);
                temp = factor * temp1 + over;
                over = temp / 10;
                right = String.valueOf(temp%10).concat(right);
            }
            if (over!=0) right = String.valueOf(over).concat(right);
            for (int i1=0; i1<i0_zero; i1++) right = right.concat("0");
            // 与上一个相加
            res = StrAdd(res, right);
        }
        // 除开头的0
        int i_remove_zero = 0;
        while (res.charAt(i_remove_zero)=='0' & i_remove_zero<res.length()-1) i_remove_zero++;
        return res.substring(i_remove_zero, res.length());
    }

    public static int Char2Int(char in){
        return in - '0';
    }

    public static String StrAdd(String str1, String str2){
        String longer = str1.length()>=str2.length() ? str1 : str2;
        String shorter = str1.length()>=str2.length() ? str2 : str1;
        int int_longer;
        int int_shorter;
        int sum;
        int over = 0;
        String res = "";
        for (int i1=0; i1<longer.length(); i1++){
            int_longer = Char2Int(longer.charAt(longer.length()-1-i1));
            int_shorter = i1<shorter.length() ? Char2Int(shorter.charAt(shorter.length()-1-i1)) : 0;
            sum = int_longer + int_shorter + over;
            res = String.valueOf((sum%10)).concat(res);
            over = sum/10;
        }
        return over==0 ? res : String.valueOf(over).concat(res);
    }

    public static void main(String[] a){
        System.out.println(multiply("1234", "0"));
    }
}
// 123 45
// 012 01
//  "11859268849335269"
// "121932631112635269"
//  111932631112635269
// "123456789"
//"987654321"
// "6"
//"501"
