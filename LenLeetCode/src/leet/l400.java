package leet;

public class l400 {
    public static int findNthDigit(int n) {
        int[] max_s = new int[]{9,99,999,9999,99999,999999,9999999,99999999,999999999};
        int[] min_s = new int[]{1,10,100,1000,10000,100000,1000000,10000000,100000000};
        int[] max_s_len = new int[max_s.length];
        for (int i1=0; i1<max_s.length; i1++){
            max_s_len[i1] = (max_s[i1]-min_s[i1]+1) * (i1+1);
        }
        for (int i1=0; i1<n; ){

        }
        return 0;
    }

    public static void main(String[] ar){
        System.out.println(findNthDigit(11));
    }
}
