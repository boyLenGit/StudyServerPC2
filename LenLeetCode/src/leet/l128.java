package leet;

import java.util.Arrays;

public class l128 {
    public static int longestConsecutive(int[] nums) {
        if (nums.length==0) return 0;
        else if (nums.length==1) return 1;
        Arrays.sort(nums);
        int len = 1;
        int res = 1;
        for (int i1=1; i1<nums.length; i1++){
            if (nums[i1]==nums[i1-1]) continue;
            if (nums[i1]==nums[i1-1]+1) len++;
            else len = 1;
            res = Math.max(res, len);
        }
        return res;
    }

    public static void main(String[] a){
        int[] inputs = new int[]{1,2,0,1};
        longestConsecutive(inputs);
    }
}
