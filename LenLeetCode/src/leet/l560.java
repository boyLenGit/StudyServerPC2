package leet;

import java.util.Arrays;

public class l560 {
    public static int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum;
        for (int i1=0; i1<nums.length; i1++){
            sum = nums[i1];
            for (int i2=i1+1; i2<nums.length; i2++){
                sum += nums[i2];
                if (sum>k) break;
                else if (sum==k) {
                    res++;
                }
            }
            if (nums[i1]==k) res++;
        }
        return res;
    }

    public static void main(String[] arg){
        int[] in1 = new int[]{28,54,7,-70,22,65,-6};
        System.out.println(subarraySum(in1, 100));
    }
}
//[1,-1,0]
//0
// [28,54,7,-70,22,65,-6]
//100