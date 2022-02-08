package JZoffer_;

public class jz010_001 {
    public static int fib(int n) {
        if (n==0) return 0;
        else if (n==1) return 1;
        long f_n=0, f_n_1=1, f_n_2=0;
        for (int i1=2; i1<=n; i1++){
            f_n = f_n_1 + f_n_2;
            f_n_2 = f_n_1;
            f_n_1 = f_n;
        }
        return (int) (f_n%1000000007);
    }

    public static void main(String[] ar){
        System.out.println(fib(95));
    }
}
