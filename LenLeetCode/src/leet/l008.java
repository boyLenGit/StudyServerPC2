package leet;

public class l008 {
    public static int myAtoi(String s) {
        char[] chars_input = s.toCharArray();
        int isPositive = 1;
        int isFront = 1;
        String string_result = "";
        for(int i1=0; i1<chars_input.length; i1++){
            if (chars_input[i1]==' '){
                continue;
            }
            if (chars_input[i1] == '-') {
                isPositive = 0;
                continue;
            }
            string_result = string_result.concat(String.valueOf(chars_input[i1]));
        }
        Long long_result = Long.parseLong(string_result);
        if ((isPositive==1 & long_result>Long.parseLong("2147483647")) | (isPositive==0 & long_result>Long.parseLong("2147483648"))){
            return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        myAtoi("   -42");
    }
}
