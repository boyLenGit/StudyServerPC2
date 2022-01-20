package JZoffer;

import java.util.Arrays;

public class jz003 {
    public static int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i1=1; i1<nums.length; i1++){
            if (nums[i1]==nums[i1-1]) return nums[i1];
        }
        return 0;
    }
}
