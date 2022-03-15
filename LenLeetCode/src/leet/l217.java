package leet;

import java.util.Arrays;

public class l217 {
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i1=0; i1<nums.length; i1++){
            if (i1==0) continue;
            if (nums[i1]==nums[i1-1]) return true;
        }
        return false;
    }

    public static void main(String[] args){

    }
}
