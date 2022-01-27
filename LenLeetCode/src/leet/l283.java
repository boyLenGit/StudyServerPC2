package leet;

public class l283 {
    public static void moveZeroes(int[] nums) {
        int count = 0;
        for (int i1=0; i1<nums.length; i1++){
            if (nums[i1]==0){
                count++;
            }
            nums[i1] = nums[count+i1];
        }
    }
}
