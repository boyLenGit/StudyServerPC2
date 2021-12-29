package leet;

import util.LenLog;

import java.util.Arrays;

public class l001 {
    public int[] twoSum(int[] nums, int target){
        int in_size = nums.length;
        for(int i1=0; i1<in_size; i1++){
            for(int i2=i1+1; i2<in_size; i2++){
                if (nums[i1]+nums[i2]==target){
                    return new int[]{i1, i2};
                }
            }
        }
        return new int[]{0, 0};
    }

    public int[] twoSum_v2(int[] nums, int target){
        for(int i1=0; i1<nums.length; i1++){
            for(int i2=i1+1; i2<nums.length; i2++){
                if (nums[i1]+nums[i2]==target){
                    return new int[]{i1, i2};
                }
            }
        }
        return new int[]{0, 0};
    }
    // 效果：更差了，内存占用多了0.2MB，耗时加了7ms
}
