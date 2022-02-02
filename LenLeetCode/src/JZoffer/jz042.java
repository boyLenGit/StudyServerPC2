package JZoffer;

import java.util.ArrayList;

public class jz042 {
    public static int maxSubArray(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        for(int i1=0; i1<nums.length; i1++){
            sum += nums[i1];
            list.add(sum);
        }
        return 1;
    }

    public static void main(String[] arg){
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
