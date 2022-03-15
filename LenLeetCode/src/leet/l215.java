package leet;

import java.util.Arrays;

public class l215 {
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public static int findKthLargest2(int[] nums, int k) {
        // 自己写选择排序,不调用函数
        int min_id;
        for (int i1=0; i1<nums.length; i1++){
            min_id=i1;
            for (int i2=i1+1; i2<nums.length; i2++){
                if (nums[i2]<nums[min_id]) min_id=i2;
            }
            int temp = nums[i1];
            nums[i1] = nums[min_id];
            nums[min_id] = temp;
        }
        return nums[nums.length-k];
    }
}
// [5,2,4,1,3,6,0]
//4