package leet;

public class l400 {
    public static int findNthDigit(int n) {
        String debug1 = "1234567891011121314151617181920212223242526";
        int[] max_s = new int[]{9,99,999,9999,99999,999999,9999999,99999999,999999999};
        int[] min_s = new int[]{1,10,100,1000,10000,100000,1000000,10000000,100000000};
        long[] max_s_len = new long[max_s.length];
        for (int i1=0; i1<max_s.length; i1++){
            max_s_len[i1] = (long) (max_s[i1] - min_s[i1] + 1) * (i1+1);
        }
        int sum = 0;
        int index_ = 0;
        int distance = 0;
        for (int i1=0; i1<n; i1++){
            distance = n-sum;
            sum += max_s_len[i1];
            if (sum>n) {
                index_ = i1;
                break;
            }
        }
        int position = distance/(index_+1);
        int mod = distance%(index_+1);
        int start_num = min_s[index_];
        int aim_num = start_num + position;
        String result_num = String.valueOf(aim_num);
        return result_num.charAt(result_num.length()-1-mod)-'0';
    }

    public static int findNthDigit2(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num / (int)(Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }


    public static void main(String[] ar){
        int input1 = 11;
        System.out.println(findNthDigit(input1));
        System.out.println(findNthDigit2(input1));
    }
}
