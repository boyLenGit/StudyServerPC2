package leet;

public class l400 {
    public static int findNthDigit(int n) {
        int[] max_s = new int[]{9,99,999,9999,99999,999999,9999999,99999999,999999999};
        int[] min_s = new int[]{1,10,100,1000,10000,100000,1000000,10000000,100000000};
        long[] max_s_len = new long[max_s.length];
        for (int i1=0; i1<max_s.length; i1++){
            max_s_len[i1] = (long) (max_s[i1] - min_s[i1] + 1) * (i1+1);
        }
        int sum = 0;
        int index_ = 0;
        int neg_ = 0;
        for (int i1=0; i1<n; i1++){
            neg_ = n-sum;
            sum += max_s_len[i1];
            if (sum>n) {
                index_ = i1;
                break;
            }
        }
        int position = neg_/(index_+1);
        int mod = neg_%(index_+1);
        return 0;
    }

    public static void main(String[] ar){
        System.out.println(findNthDigit(11));
    }
}
