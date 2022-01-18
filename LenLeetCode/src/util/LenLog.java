package util;

import java.util.Arrays;
import java.util.Date;

public class LenLog {
    Date data = new Date();

    public static void staticInfo(String name, String content){
        String time = LenTime.ymdhms_v1();
        String print = time + " LenLog <" + name + "> Content:" + content;
        System.out.println(print);
    }

    public static void printInt2vArray(int[][] inputs){
        for (int[] input : inputs) {
            printString(Arrays.toString(input));
        }
    }

    public static void printString(String string){
        System.out.println(string);
    }
}
