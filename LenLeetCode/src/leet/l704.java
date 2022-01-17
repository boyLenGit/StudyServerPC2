package leet;

import java.util.Arrays;

public class l704 {
    public static int search(int[] nums, int target) {
        for (int i1=nums.length/2; i1>=0 & i1<nums.length;){
            if (nums[i1]==target) return i1;
            else if (nums[i1]>target) {
                if (i1!=0) if (nums[i1-1]<target) break;
                i1--;
            }
            else if (nums[i1]<target) {
                if (i1!=nums.length-1) if (nums[i1+1]>target) break;
                i1++;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(search(new int[]{}, -3));
    }

}
