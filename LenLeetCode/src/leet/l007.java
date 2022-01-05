package leet;

public class l007 {
    public static int reverse(int x) {
        int isPositive = x>=0 ? 1 : 0;
        String string_input = String.valueOf(Math.abs(x));
        char[] chars_input = string_input.toCharArray();
        char[] chars_result = string_input.toCharArray();
        int length = chars_input.length;
        for(int i0=0; i0<length; i0++){
            chars_result[length -1 - i0] = chars_input[i0];
        }
        String string_result = String.valueOf(chars_result);
        int int_result = Integer.parseInt(string_result);
        return int_result;
    }
}
