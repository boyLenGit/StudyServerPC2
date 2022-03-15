package leet;

public class l055 {
    public static boolean canJump(int[] nums) {
        if (nums.length==1 & nums[0]==0) return true;
        int max_index = nums[0];
        for (int i1=0; i1<=max_index; i1++){
            max_index = Math.max(max_index, nums[i1]+i1);
            if (max_index>=nums.length-1) return true;
        }
        return false;
    }

    public static void main(String[] art){
        System.out.println(canJump(new int[]{1,1,2,2,0,1,1}));
    }

}
//[1,1,2,2,0,1,1] true