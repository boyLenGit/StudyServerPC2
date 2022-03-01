package leet;

public class l162 {
    public int findPeakElement(int[] nums) {
        if (nums.length==1) return 0;
        for (int i1=0; i1<nums.length; i1++){
            if (i1!=0 && i1+1<nums.length && nums[i1]>nums[i1-1] && nums[i1]>nums[i1+1]) return i1;
        }
        if (nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;
        return 0;
    }

    public int findPeakElement2(int[] nums) {
        int low=0, high=nums.length-1, mid;
        while (low<high){
            mid = (high-low)/2 + low;
            if (nums[mid]<nums[mid+1]) low=mid+1;
            else high=mid;
        }
        return low;
    }

    public static int search(int[] nums, int target){
        int low=0, high=nums.length-1, mid;
        while (low<=high){
            mid = (high-low)/2+low;
            if (mid-1>=0 && mid+1<nums.length && nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) return mid;
            else if (nums[mid]<nums[mid+1]) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
}
