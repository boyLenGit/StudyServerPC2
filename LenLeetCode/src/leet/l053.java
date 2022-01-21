package leet;

import java.util.Arrays;

public class l053 {
    public static int maxSubArray(int[] nums) {
        // 超时
        int res = nums[0];
        for (int i1=0; i1<nums.length; i1++){
            res = Math.max(res, nums[i1]);
            for (int i2=i1+1; i2<nums.length; i2++){
                res = Math.max(res, sum(Arrays.copyOfRange(nums, i1, i2+1)));
            }
        }
        return res;
    }

    public static int sum(int[] array){
        int sum = 0;
        for (int num: array){
            sum = sum +num;
        }
        return sum;
    }

    public static int maxSubArray2(int[] nums) {
        // 看了评论区大佬的解法,重新更改思路
        int res_temp = 0;
        int res = nums[0];
        for (int i1=0; i1<nums.length; i1++){
            if (res_temp>0) res_temp += nums[i1];
            else res_temp = nums[i1];
            res = Math.max(res, res_temp);
        }
        return res;
    }

    public static void main(String[] a){
        maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}
