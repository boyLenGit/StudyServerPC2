package leet;

public class l029 {
    public static int divide(int dividend, int divisor) {
        int debug = dividend % divisor;
        int pone_d = dividend>=0 ? 1 : -1;
        int pone_or = divisor>=0 ? 1 : -1;
        String str_d = String.valueOf(dividend).replace("-", "");
        String str_or = String.valueOf(divisor).replace("-", "");
        String result = "";
        int int_d;
        int int_d_adder = 0;
        int len_or = str_or.length();
        Long long_result = 0L;
        for (int i1=0; i1<str_d.length(); i1=i1+len_or){
            int_d = Integer.parseInt(str_d.substring(i1, i1+len_or)) + int_d_adder;
            // 上端
            for (int i2=0; ; i2++){
                if (int_d<divisor * pone_or){
                    result = result.concat(String.valueOf(i2));
                    int_d_adder = int_d * 10;
                    break;
                }
                int_d = int_d - divisor * pone_or;
            }

            // 最末尾
//            if (i1+1==str_d.length()){
//                long_result = int_d_adder * 2>divisor * 10 * pone_or ? long_result+1 : long_result;
//                break;
//            }
        }
        // 数据溢出的情况
        long_result = Long.valueOf(result) * pone_d * pone_or;
        if (long_result>2147483647) return 2147483647;
        else if(long_result<-2147483648) return -2147483648;
        return long_result.intValue();
    }

    public static void main(String[] args){
        System.out.println(divide(-2147483648, -3));

    }
}
// -2147483648
//-3
