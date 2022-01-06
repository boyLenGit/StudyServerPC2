package leet;

import util.LenLog;

public class l007 {
    public static int reverse(int x) {
        String string_input = String.valueOf(Math.abs(x));
        char[] chars_input = string_input.toCharArray();
        char[] chars_result = string_input.toCharArray();
        int length = chars_input.length;
        for(int i0=0; i0<length; i0++){
            chars_result[length -1 - i0] = chars_input[i0];
        }
        String string_result = String.valueOf(chars_result);
        long long_result = Long.parseLong(string_result);
        if ((x>=0 & long_result>Long.parseLong("2147483647")) | (x<0 & long_result>Long.parseLong("2147483648"))){
            return 0;
        }
        int int_result = Integer.parseInt(string_result);
        return x>=0 ? int_result : (-1 * int_result);
    }

    public static void main(String[] args) {
        int input = 1534236469;
        int result = reverse(input);
        LenLog.printString(String.valueOf(result));
    }
}
