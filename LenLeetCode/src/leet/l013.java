package leet;

import util.LenLog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class l013 {
    public static int romanToInt(String s) {
        ArrayList<Integer> divisors = new ArrayList<Integer>(Arrays.asList(1000,900,500,400,100,90,50,40,10,9,5,4,1));
        ArrayList<String> romas = new ArrayList<String>(Arrays.asList("M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"));
        ArrayList<Integer> romas_dual_index = new ArrayList<Integer>(Arrays.asList(1,3,5,7,9,11));
        char[] list_chars = s.toCharArray();
        char char_dul = ' ';
        int result = 0;
        int isDul = 0;
        for (int i1=0; i1<list_chars.length; i1++){
            // 针对"CM","CD","XC","XL","IX","IV"情况
            if ((list_chars[i1]=='C' | list_chars[i1]=='X' | list_chars[i1]=='I') & i1+1<list_chars.length){
                char_dul = list_chars[i1+1];
                for (int i2=0; i2<romas_dual_index.size(); i2++){
                    char compare = romas.get(romas_dual_index.get(i2)).toCharArray()[1];
                    if (compare==char_dul){
                        result = result + divisors.get(romas_dual_index.get(i2));
                        i1++;
                        isDul = 1;
                        break;
                    }
                }
                if (isDul==1){
                    isDul = 0;
                    continue;
                }

            }
            if (i1>=list_chars.length){
                break;
            }
            for (int i2=0; i2<romas.size(); i2++){
                if (romas.get(i2).toCharArray()[0]==list_chars[i1]){
                    result = result + divisors.get(i1);
                    break;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        LenLog.printString(String.valueOf(romanToInt("MCMXCIV")));
    }
}
