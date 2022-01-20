package leet;

import java.util.Arrays;

public class l611 {
    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int cnt = 0;
        for (int i1=0; i1<nums.length-2; i1++){
            for (int i2=i1+1; i2<nums.length-1; i2++){
                for (int i3=i2+1; i3<nums.length; i3++){
                    if (nums[i1]+nums[i2]>nums[i3]) cnt++;
                    else break;
                }
            }

        }
        return cnt;
    }

    public static int triangleNumber2(int[] nums) {
        // 双指针法优化速度
        Arrays.sort(nums);
        int cnt = 0;
        for (int i1=0; i1<nums.length-2; i1++){
            for (int i2=i1+1, i3=i1+2; i2<nums.length-1; ){
                if (i3>=nums.length) {
                    i2++;
                    i3 = i2 + 1;
                }
                if (nums[i1]+nums[i2]>nums[i3]) {
                    cnt++;
                    i3++;
                }else {
                    i2++;
                    i3 = i2 + 1;
                }
            }

        }
        return cnt;
    }

    public static void main(String[] a){
        System.out.println(triangleNumber2(new int[]{2,2,3,4}));
    }
}
