package leet;

import java.util.Arrays;

public class l189 {
    public static void rotate(int[] nums, int k) {
        while (k>=nums.length) k = k - nums.length;
        if (nums.length==1) return;
        int[] copy_nums = nums.clone();
        for (int i1=0; i1<nums.length; i1++){
            if (i1+k<nums.length)nums[i1+k] = copy_nums[i1];
            else nums[i1+k-nums.length] = copy_nums[i1];
        }
    }

    public static void rotate2(int[] nums, int k) {
        // 优化空间占用,改为使用k大小的临时数组
        // 效果:没效果,从57.1M变为57.2M
        while (k>=nums.length) k = k - nums.length;
        if (nums.length==1) return;
        int[] move_nums = Arrays.copyOfRange(nums, nums.length-k, nums.length);
        for (int i1=nums.length-1-k; i1>=0; i1--){
            nums[nums.length-1-(nums.length-i1-k-1)] = nums[i1];
        }
        for (int i1=0; i1<k; i1++){
            nums[i1] = move_nums[i1];
        }
    }

    public static void rotate3(int[] nums, int k) {
        // 继续优化空间占用, 优化最后一个循环
        // 效果:没效果,从57.1M变为57M
        while (k>=nums.length) k = k - nums.length;
        if (nums.length==1) return;
        int[] move_nums = Arrays.copyOfRange(nums, nums.length-k, nums.length);
        for (int i1=nums.length-1-k; i1>=0; i1--){
            nums[nums.length-1-(nums.length-i1-k-1)] = nums[i1];
        }
        if (k >= 0) System.arraycopy(move_nums, 0, nums, 0, k);
    }

    public static void main(String[] a){
        int[] inputs = new int[]{-1};
        rotate2(inputs, 2);
        System.out.println(inputs);
    }
}
// 1,2,3,4,5,6,7
// 5,6,7,1,2,3,4