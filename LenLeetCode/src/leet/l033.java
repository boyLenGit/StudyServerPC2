package leet;

import java.util.Arrays;

public class l033 {
    public static int search(int[] nums, int target) {
        if (nums.length==1) return nums[0]==target ? 0 : -1;
        int mid = 0, left_max=-nums[nums.length-1], left_min=nums[0], right_max=nums[nums.length-1], right_min=nums[0];
        for (int i1=1; i1<nums.length; i1++){
            if (nums[i1-1]>nums[i1]){
                mid = i1;
                right_min = nums[i1];
                left_max = nums[i1-1];
                break;
            }
        }
        int res=-1;
        if (left_min<=target & target<=left_max){
            res = binSearch(Arrays.copyOfRange(nums, 0, mid), target);
        }else if (right_min<=target & target<=right_max){
            res = binSearch(Arrays.copyOfRange(nums, mid, nums.length), target);
            res = res!=-1 ? res+mid : res;
        }
        return res;
    }

    public static int binSearch(int[] nums, int target) {
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

    public static void main(String[] arg){
        int[] input1 = new int[]{8,1,2,3,4,5,6,7};
        System.out.println(search(input1, 6));
    }
}
//[1,3]
//1
//[8,1,2,3,4,5,6,7]
//6