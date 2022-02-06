package leet;

import java.util.Arrays;

public class l034 {
    public static int[] binarySearch(int[] inputs, int target){
        int low=0, high=inputs.length-1, mid=-1;
        while (low<=high){
            mid = (high-low)/2 + low;
            if (inputs[mid]==target) return new int[]{mid, -1};
            else if (inputs[mid]>target) high = mid-1;
            else low = mid+1;
        }
        return new int[]{mid, -1};
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int cnt = 0;
        int low=0, high=nums.length-1, mid;
        while (low<=high){
            mid = (high-low)/2 + low;
            if (nums[mid]==target) {
                res[cnt] = mid;
                cnt = 1;
            }
            else if (nums[mid]>target) high = mid-1;
            else low = mid+1;
        }
        if (res[1]==-1 & res[0]!=-1) res[1]=res[0];
        return res;
    }

    public static void main(String[] a){
        int[] inputs = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(binarySearch(inputs, 8)));
    }
}
