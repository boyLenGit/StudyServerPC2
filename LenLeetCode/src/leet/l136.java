package leet;

import java.util.Arrays;

public class l136 {
    public static int singleNumber(int[] nums) {
        int min;
        for (int i1=0; i1<nums.length; i1++){
            min = i1;
            for (int i2=i1+1; i2<nums.length; i2++){
                if (nums[min]>nums[i2]) min = i2;
            }
            int temp = nums[min];
            nums[min] = nums[i1];
            nums[i1] = temp;
        }

        int res = nums[0];
        for (int i1=1; i1<nums.length; i1++){
            if (i1+1<nums.length) {
                if (nums[i1]!=nums[i1-1] & nums[i1]!=nums[i1+1]) res = nums[i1];
            }else {
                if (nums[i1]!=nums[i1-1]) res = nums[i1];
            }
        }
        return res;
    }

    public static int singleNumber2(int[] nums) {
        // 使用自带排序算法,提高速度
        Arrays.sort(nums);

        int res = nums[0];
        for (int i1=1; i1<nums.length; i1++){
            if (i1+1<nums.length) {
                if (nums[i1]!=nums[i1-1] & nums[i1]!=nums[i1+1]) res = nums[i1];
            }else {
                if (nums[i1]!=nums[i1-1]) res = nums[i1];
            }
        }
        return res;
    }

    public static int singleNumber3(int[] nums) {
        // 优化返回逻辑,判断出结果立即返回,减少遍历时间
        Arrays.sort(nums);
        for (int i1=1; i1<nums.length; i1++){
            if (i1+1<nums.length) {
                if (nums[i1]!=nums[i1-1] & nums[i1]!=nums[i1+1]) return nums[i1];
            }else {
                if (nums[i1]!=nums[i1-1]) return nums[i1];
            }
        }
        return nums[0];
    }

    public int singleNumber_leetcode1(int[] nums) {
        return Arrays.stream(nums).reduce((a,b)->a^b).getAsInt();
    }

    public static void main(String[] a){
        int[] inputs = new int[]{17,12,5,-6,12,4,17,-5,2,-3,2,4,5,16,-3,-4,15,15,-4,-5,-6};
        singleNumber(inputs);
    }
}


//[17,12,5,-6,12,4,17,-5,2,-3,2,4,5,16,-3,-4,15,15,-4,-5,-6]