package leet;

import java.util.Arrays;

public class l053 {
    public static int maxSubArray(int[] nums) {
        if (nums.length==1) return nums[0];
        int res = 0;
        for (int i1=0; i1<nums.length-1; i1++){
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

    public static void main(String[] a){
        maxSubArray(new int[]{-2, 1});
    }
}
