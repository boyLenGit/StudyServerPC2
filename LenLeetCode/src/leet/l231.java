package leet;

public class l231 {
    public boolean isPowerOfTwo(int n) {
        int[] factors = new int[]{2, 4, 8, 16, 32, 64, 128};
        for (int factor : factors) {
            if (n%2!=0 && n!=1) return false;
            while (n >= factor && n % factor == 0) n /= factor;
        }
        return n==1;
    }
}
// 10 - 5 - (2, 4 - 2)
// 2 2 2 2 2 2
// 4 4 4
// 8 4