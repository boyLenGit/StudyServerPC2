package leet;

import java.util.Arrays;

public class l034 {
    public static int binarySearch(int[] inputs, int target){
        int low=0, high=inputs.length-1, mid;
        while (low<=high){
            mid = (high-low)/2 + low;
            if (inputs[mid]==target) return mid;
            else if (inputs[mid]>target) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }

    public static int[] searchRange(int[] nums, int target) {
        int max, min;
        max = min = binarySearch(nums, target);
        if (max==-1) return new int[]{min, max};
        for (int i1=max; i1<nums.length; i1++){
            if (nums[i1]==target) max = i1;
            else break;
        }
        for (int i1=min; i1>=0; i1--){
            if (nums[i1]==target) min = i1;
            else break;
        }
        return new int[]{min, max};
    }

    public static void main(String[] a){
        int[] inputs = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(inputs, 6)));
    }
}
