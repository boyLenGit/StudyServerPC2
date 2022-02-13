package leet;

import java.util.Arrays;

public class l062 {
    private int cnt = 0;
    public int uniquePaths(int m, int n) {
        dg(m,n,0,0);
        return cnt;
    }

    public  void dg(int m, int n, int init_m, int init_n){
        if (init_m>=m | init_n>=n) {
            System.out.println(Arrays.toString(new int[]{init_m, init_n}));
            cnt++;
            return;
        }
        dg(m,n,init_m+1,init_n);
        dg(m,n,init_m,init_n+1);
    }

    public static void main(String[] arg){
        l062 a = new l062();
        System.out.println(a.uniquePaths(3,2));
    }
}
