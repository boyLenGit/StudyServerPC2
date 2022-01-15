package leet;

public class l029 {
    public static int divide(int dividend, int divisor) {
        String str_d = String.valueOf(dividend);
        String str_or = String.valueOf(divisor);
        String result = "";
        int int_d;
        int len_or = str_or.length();
        for (int i1=0; i1<str_d.length(); i1=i1+len_or-1){
            int_d = Integer.parseInt(str_d.substring(i1, i1+len_or-1));
            for (int i2=0; ; i2++){
                if (int_d>divisor){
                    result = result.concat(String.valueOf(i2));
                    break;
                }
                int_d = int_d - divisor;
            }
        }
        return Integer.parseInt(result);
    }

    public static void main(String[] args){
        System.out.println(divide(10, 3));
    }
}
//     _____
// 321|42342
