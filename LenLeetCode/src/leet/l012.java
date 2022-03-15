package leet;

import util.LenLog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l012 {
    public static String intToRoman(int num) {
        ArrayList<Integer> divisors = new ArrayList<Integer>(Arrays.asList(1000,900,500,400,100,90,50,40,10,9,5,4,1));
        ArrayList<String> romas = new ArrayList<String>(Arrays.asList("M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"));
        ArrayList<Integer> devide_result = new ArrayList<Integer>();
        // 计算每个罗马数字出现的次数
        int be_divisor = num;
        for (int divisor : divisors) {
            if (divisor > be_divisor) { // 如果输入值＞被除数，则跳过
                devide_result.add(0);
                continue;
            } else {
                devide_result.add(be_divisor / divisor);
                be_divisor = be_divisor % divisor;
            }
        }
        // 生成罗马数字的结果
        String result = "";
        for (int i1=0; i1<devide_result.size(); i1++){
            if (devide_result.get(i1)!=0){
                for (int i2=0; i2<devide_result.get(i1); i2++){
                    result = result.concat(romas.get(i1));
                }
            }
        }
        return result;
    }


    public static String intToRoman_len2(int num) {
        ArrayList<Integer> divisors = new ArrayList<Integer>(Arrays.asList(1000,900,500,400,100,90,50,40,10,9,5,4,1));
        ArrayList<String> romas = new ArrayList<String>(Arrays.asList("M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"));
        String result = "";
        int be_divisor = num;
        for (int i1=0; i1<divisors.size(); i1++){
            if (divisors.get(i1)<=be_divisor){
                // 生成罗马数字的结果
                for (int i2=0; i2<be_divisor / divisors.get(i1); i2++){
                    result = result.concat(romas.get(i1));
                }
                be_divisor = be_divisor % divisors.get(i1);
            }
        }
        return result;
    }
    // 耗时和内存消耗没什么提升


    public static void main(String[] args) {
        String result = intToRoman_len2(1);
        LenLog.printString(result);
    }
}
