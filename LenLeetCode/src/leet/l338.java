package leet;

import java.util.Arrays;

public class l338 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
    }

    public static int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i1=0; i1<=n; i1++){
            res[i1] = Integer.bitCount(i1);
        }
        return res;
    }
}
