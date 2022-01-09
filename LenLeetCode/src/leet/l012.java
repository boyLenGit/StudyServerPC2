package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l012 {
    public static String intToRoman(int num) {
        ArrayList<Integer> divisors = new ArrayList<Integer>(Arrays.asList(1, 5, 10, 50, 100, 500, 1000));
        ArrayList<Integer> devide_result = new ArrayList<Integer>();
        int be_divisor = num;
        for (int divisor : divisors) {
            if (divisor > be_divisor) { // 如果输入值＞被除数，则跳过
                devide_result.add(0);
                continue;
            } else {
                devide_result.add(be_divisor / divisor);
            }
            be_divisor = be_divisor % divisor;
        }
        return "";
    }

    public static void main(String[] args) {
        String result = intToRoman(3);
    }
}
