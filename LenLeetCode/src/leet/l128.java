package leet;

import java.util.Arrays;

public class l128 {
    public static int longestConsecutive(int[] nums) {
        if (nums.length==0) return 0;
        else if (nums.length==1) return 1;
        Arrays.sort(nums);
        int len = 0;
        int res = 0;
        for (int i1=1; i1<nums.length; i1++){
            if (nums[i1]==nums[i1-1]) len++;
            else len = 0;
            res = Math.max(res, len);
        }
        return len;
    }

    public static void main(String[] a){
        int[] inputs = new int[]{100,4,200,1,3,2};
        longestConsecutive(inputs);
    }
}
