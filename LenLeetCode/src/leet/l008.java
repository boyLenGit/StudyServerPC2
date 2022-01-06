package leet;

import util.LenLog;

public class l008 {
    public static int myAtoi(String s) {
        char[] chars_input = s.trim().toCharArray();
        int isPositive = chars_input[0]=='-' ? 0 : 1;
        int isfirstWord = 1;
        String string_result = "";
        for(int i1=0; i1<chars_input.length; i1++){
            if (chars_input[i1]==' '){
                break;
            }
            if (chars_input[i1]>='0' & chars_input[i1]<='9')
            string_result = string_result.concat(String.valueOf(chars_input[i1]));
        }

        if (string_result.length()==0){
            return 0;
        }
        Long long_result = Long.parseLong(string_result);
        if (isPositive==1 & long_result>Long.parseLong("2147483647")){
            return 2147483647;
        }
        if (isPositive==0 & long_result>Long.parseLong("2147483648")){
            return -2147483648;
        }

        return isPositive==1 ? Integer.parseInt(string_result) : Integer.parseInt(string_result) * (-1);
    }

    public static void main(String[] args) {
        int result = myAtoi("-91283472332");
        LenLog.printString(String.valueOf(result));
    }
}
