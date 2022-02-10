package leet;

public class l050 {
    public static double myPow(double x, int n) {
        if (n==0) return 1;
        if (x==1.0) return x;
        double res;
        if (n>=0){
            res = posPow(x, n);
        }else {
//            for (long i1=0; i1<-n1; i1++) res = res / x;
            res = negPow(x, n);
        }
        return res;
    }

    public static double posPow(double x, int n){
        double res = 1;
        double temp = x;
        while (n%2==0){
            temp = temp * temp;
            n = n / 2;
        }
        for (int i1=0; i1<n; i1++)res *= temp;
        return res;
    }

    public static double negPow(double x, int n){
        double res = 1;
        double temp = x;
        for (int i1=0; n%2==0; i1++){
            temp = 1 / temp;
            n = n / 2;
        }
        for (int i1=0; i1<n; i1++)res *= temp;
        return res;
    }

    public static void main(String[] arg){
        System.out.println(myPow(2.0000, -4));
        System.out.println(2.00/5.00);
    }
}
//  2 100
//  4 50
//  16 25
//  2.00000
//-2147483648