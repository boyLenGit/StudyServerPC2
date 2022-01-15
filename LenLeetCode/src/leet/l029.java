package leet;

public class l029 {
    public static int divide(int dividend, int divisor) {
        int debug = dividend % divisor;
        int pone_d = dividend>=0 ? 1 : -1;
        int pone_or = divisor>=0 ? 1 : -1;
        if ((Long.parseLong(String.valueOf(dividend))*pone_d)<(Long.parseLong(String.valueOf(divisor))*pone_or)) return 0;
        String str_d = String.valueOf(dividend).replace("-", "");
        String str_or = String.valueOf(divisor).replace("-", "");
        String result = "";
        long long_d;
        long long_d_adder = 0L;
        int len_or = str_or.length();
        long long_result = 0L;
        for (int i1=0; i1<str_d.length()-str_or.length(); i1++){
            long_d = i1==0 ? Long.parseLong(String.valueOf(long_d_adder).concat(str_d.substring(i1, i1+len_or))) : Long.parseLong(String.valueOf(long_d_adder).concat(str_d.substring(i1, i1+1)));
            // 上端
            for (int i2=0; ; i2++){
                if (long_d<divisor * pone_or){
                    result = result.concat(String.valueOf(i2));
                    long_d_adder = long_d;
                    break;
                }
                long_d = long_d - divisor * pone_or;
            }
        }
        // 数据溢出的情况
        long_result = Long.parseLong(result) * pone_d * pone_or;
        if (long_result>2147483647) return 2147483647;
        else if(long_result<-2147483648) return -2147483648;
        return (int) long_result;
    }

    public static void main(String[] args){
        System.out.println(divide(-1021989372, -82778243));

    }
}
// -2147483648
//-1
// -1021989372
//-82778243
