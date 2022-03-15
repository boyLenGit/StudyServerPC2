package leet;

import java.util.Arrays;

public class l283 {
    public static void moveZeroes(int[] nums) {
        int count = 0;
        for (int i1=0; i1+count<nums.length; i1++){
            if (nums[i1+count]==0) {
                count++;
                i1--;
                continue;
            }
            if (i1+count>=nums.length) break;
            nums[i1] = nums[count+i1];
        }
        for (int i1=0; i1<count; i1++){
            nums[nums.length-1-i1] = 0;
        }
    }

    public static void main(String[] a){
        int[] input1 = new int[]{0,0,1};
        moveZeroes(input1);
        System.out.println(Arrays.toString(input1));
    }
}
