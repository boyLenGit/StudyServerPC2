package leet;

public class l050 {
    public static double myPow(double x, int n) {
        if (n==0) return 1;
        if (x==1.0) return x;
        double res;
        if (n>=0){
            res = dg(x, n);
        }else {
            if (n!=-2147483648) res = 1/dg(x, -n);
            else res = 1/( dg(x, -(n+1))*x );
        }
        return res;
    }

    public static double dg(double x, int n){
        double temp = x;
        while (n>1){
            if (n%2!=0) {
                n--;
                temp = temp * dg(temp, n);
                break;
            }
            temp = temp * temp;
            n = n / 2;
        }
        return temp;
    }

    public static void main(String[] arg){
        System.out.println(myPow(2.0000, -2147483648));
        System.out.println(2.00/5.00);
    }
}
//  2 100
//  4 50
//  16 25
//  2.00000
//-2147483648

// 2 2 2 2 2 2 2 2 2 2 *10
// 4 4 4 4 4 *5
//(4 4 4 4) 4
//(16 16 *2) 4
// 2.00000
//-2147483648