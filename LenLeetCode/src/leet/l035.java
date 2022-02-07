package leet;

public class l035 {
    public static int searchInsert(int[] nums, int target) {
        if (target>nums[nums.length-1]) return nums.length;
        else if (target<nums[0]) return 0;
        int low=0, high=nums.length-1, mid;
        while (low<=high){
            mid = (high-low)/2 +low;
            if (nums[mid]==target) return mid;
            else{
                if (mid-1>=0 && (nums[mid-1]<target & target<nums[mid])) return mid;
                if (nums[mid]>target) high = mid-1;
                else if (nums[mid]<target) low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] arg){
        System.out.println(searchInsert(new int[]{1}, 0));
    }
}
