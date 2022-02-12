package leet;

public class l062 {
    private int cnt = 0;
    public int uniquePaths(int m, int n) {
        return cnt;
    }

    public  void dg(int m, int n, int init_m, int init_n){
        if (init_m>=m | init_n>=n) return;
        dg(m,n,init_m-1,init_n);
        dg(m,n,init_m,init_n-1);
        cnt++;
    }

    public static void main(String[] arg){
        l062 a = new l062();
        a.uniquePaths(3,7);
    }
}
