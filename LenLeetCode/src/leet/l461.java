package leet;

public class l461 {
    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.bitCount(1 ^ 4));
    }

    public static int hammingDistance(int x, int y) {
        String bin_long = x>y ? Integer.toBinaryString(x) : Integer.toBinaryString(y);
        String bin_short = x>y ? Integer.toBinaryString(y) : Integer.toBinaryString(x);
        int cnt = 0;
        for (int i1=bin_long.length()-1, i2 = bin_short.length()-1; i1>=0 || i2>=0; i1--, i2--){
            if (i2>=0) {
                if (bin_long.charAt(i1)!=bin_short.charAt(i2)) cnt++;
            }else {
                if (bin_long.charAt(i1)=='1') cnt++;
            }
        }
        return cnt;
    }
}
