package JZoffer;

import java.util.ArrayList;

public class jz042 {
    public static int maxSubArray(int[] nums) {
        if (nums.length==0) return 0;
        int sum = 0;
        int res = nums[0];
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] arg){
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
