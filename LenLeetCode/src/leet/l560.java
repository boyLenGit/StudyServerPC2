package leet;

import java.util.Arrays;

public class l560 {
    public static int subarraySum(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        int res = 0;
        for (int i1=0, i2=nums.length-1;i1<i2; ){
            if (nums[i2]>k){
                i2--;
                continue;
            }
            if (nums[i1]+nums[i2]>k) i2--;
            else if (nums[i1]+nums[i2]<k) i1++;
            else if (nums[i1]+nums[i2]==k) {
                res++;
                i1++;
            }

        }
        return res;
    }

    public static void main(String[] arg){
        int[] in1 = new int[]{1,1,1};
        System.out.println(subarraySum(in1, 2));
    }
}
