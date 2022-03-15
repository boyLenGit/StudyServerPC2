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
        // 二分法求解
        int border_start=0;
        int border_end=nums.length;
        for (int i1=nums.length/2;;){
            if (nums[i1]==target) return i1;
            else if (nums[i1]>target) {
                border_end = i1;
                if (i1!=0){
                    if (nums[i1-1]<target) break;
                    i1 = border_end/2;
                }else break;
            }
            else if (nums[i1]<target) {
                if (i1!=nums.length-1){
                    if (nums[i1+1]>target) break;
                    i1 = i1 + ((border_end-i1)/2);
                }else break;
            }
            // 放在最底部，用于防止index溢出
            if (i1<0 | i1>=nums.length) break;
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(search2_2fenSearch(new int[]{1,76,78}, 3));
    }

}
// 123456789    len=9
// 012345678
// 12345678     len=8
// 01234567
// 9/2=4

//[-1,0,3,5,9,12]
//3