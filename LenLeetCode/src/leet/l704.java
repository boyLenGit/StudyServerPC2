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

    public static int search2_2fenSearch(int[] nums, int target) {
        for (int i1=nums.length/2;;){
            if (nums[i1]==target) return i1;
            else if (nums[i1]>target) {
                if (i1!=0) if (nums[i1-1]<target) break;
                i1 = i1/2;
            }
            else if (nums[i1]<target) {
                if (i1!=nums.length-1) if (nums[i1+1]>target) break;
                i1 = i1 + ((nums.length-i1)/2);
            }
            // 放在最底部，用于防止index溢出
            if (i1<0 | i1>=nums.length) break;
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(search2_2fenSearch(new int[]{5}, -3));
        System.out.println(9/2);
    }

}
// 123456789    len=9
// 012345678
// 12345678     len=8
// 01234567
// 9/2=4