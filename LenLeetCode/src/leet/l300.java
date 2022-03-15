package leet;

import java.util.ArrayList;
import java.util.Arrays;

public class l300 {
    public static int lengthOfLIS(int[] nums) {
        int res=0;
        int[] counts = new int[nums.length];
        Arrays.fill(counts, 1);
        for (int i1=0; i1<nums.length; i1++){
            for (int i2=0; i2<i1; i2++){
                if (nums[i2]<nums[i1]){
                    counts[i1] = Math.max(counts[i1], counts[i2]+1);
                }
            }
            res = Math.max(res, counts[i1]);
        }
        return res;
    }

    public static int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    public static void main(String[] arg){
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
