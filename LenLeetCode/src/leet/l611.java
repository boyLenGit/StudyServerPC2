package leet;

import java.util.Arrays;

public class l611 {
    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int cnt = 0;
        for (int i1=0; i1<nums.length-2; i1++){
            for (int i2=i1+1; i2<nums.length-1; i2++){
                for (int i3=i2+1; i3<nums.length; i3++){
                    if (nums[i1]+nums[i1+1]>nums[i1+2]) cnt++;
                    else break;
                }
            }

        }
        return cnt;
    }

    public static void main(String[] a){
        System.out.println(triangleNumber(new int[]{2,2,3,4}));
    }
}
