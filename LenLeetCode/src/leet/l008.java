package leet;

import util.LenLog;

public class l008 {
    public static int myAtoi(String s) {
        char[] chars_input = s.trim().toCharArray();
        // 针对空串输入的情况""
        if (chars_input.length==0){
            return 0;
        }
        int isPositive = chars_input[0]=='-' ? 0 : 1;
        int isfirstWord = 1;
        String string_result = "";
        if (chars_input[0]=='.'){
            return 0;
        }
        for(int i1=0; i1<chars_input.length; i1++){
            if ((chars_input[i1]<'0' | chars_input[i1]>'9') & chars_input[i1]!='+' & chars_input[i1]!='-'){
                break;
            }
            // 预防+-123的情况
            if (i1+1<chars_input.length & (chars_input[i1]=='-' | chars_input[i1]=='+')){
                if ((chars_input[i1]=='-' & chars_input[i1+1]=='+') | (chars_input[i1]=='+' & chars_input[i1+1]=='-')){
                    return 0;
                }
                if (i1>0){
                    break;
                }
            }
            if ((chars_input[i1]>='0' & chars_input[i1]<='9')){
                string_result = string_result.concat(String.valueOf(chars_input[i1]));
            }
        }

        if (string_result.length()==0){
            return 0;
        }
        Long long_result;
        try {
            long_result = Long.parseLong(string_result);
        }catch (NumberFormatException a){
            return isPositive==1 ? 2147483647 : -2147483648;
        }
        if (isPositive==1 & long_result>=Long.parseLong("2147483647")){
            return 2147483647;
        }
        if (isPositive==0 & long_result>=Long.parseLong("2147483648")){
            return -2147483648;
        }

        return isPositive==1 ? Integer.parseInt(string_result) : Integer.parseInt(string_result) * (-1);
    }

    public static void main(String[] args) {
        int result = myAtoi("20000000000000000000");
        LenLog.printString(String.valueOf(result));
        /*
        * 0000042a1234
        *"00000-42a1234"
        * + 0 123
        *  -0012a42
        * + 413
        * 0-1
        * - 234
        * -2147483648
        * +1
        * +-2
        *    +12
        *  2  -12
        *  ##2  -12
        * -
        * -91283472332
        * " "
        * */
    }
}
