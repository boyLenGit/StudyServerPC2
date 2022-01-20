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
        // 结果：耗时比方法1更长，反向优化。
        Arrays.sort(nums);
        int cnt = 0;
        for (int i1=0; i1<nums.length-2; i1++){
            for (int i2=i1+1, i3=i1+2; i2<nums.length-1; ){
                if (i3>=nums.length) {
                    i2++;
                    i3 = i2 + 1;
                    continue;
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

    public static int triangleNumber3(int[] nums) {
        // 双指针法+反向遍历遇到符合条件即停止遍历 [2,2,3,4]
        // 结果：耗时比方法1更长，反向优化。
        Arrays.sort(nums);
        int cnt = 0;
        for (int i1=0; i1<nums.length-2; i1++){
            for (int i2=i1+1, i3=nums.length-1; i2<nums.length-1; ){
                if (i3==i2){
                    i2++;
                    i3 = nums.length-1;
                    continue;
                }
                if (nums[i1]+nums[i2]>nums[i3]){
                    cnt = cnt + (i3-i2);
                    i2++;
                    i3=nums.length-1;
                    continue;
                }
                i3--;
            }
        }
        return cnt;
    }

    public static int triangleNumber4(int[] nums) {
        // 双指针法+反向遍历遇到符合条件即停止遍历+i2<i3双指针
        // 结果：61 ms, 在所有 Java 提交中击败了50.20%的用户。
        Arrays.sort(nums);
        int cnt = 0;
        for (int i1=0; i1<nums.length-2; i1++){
            for (int i2=i1+1, i3=i2+1; i3<nums.length & i2<nums.length-1 & i2<i3; ){
                if (nums[i1]+nums[i2]<=nums[i3]){
                    cnt = cnt + (i3-i2-1);
                    i2++;
                    i3 = i2==i3 ? i3+1 : i3;
                }else if ((i2==nums.length-2 | i3==nums.length-1) & nums[i1]+nums[i2]>nums[i3]){
                    cnt = cnt + (i3-i2);
                    i2++;
                    i3 = i2==i3 ? i3+1 : i3;
                } else i3++;
            }
        }
        return cnt;
    }

    public static void main(String[] a){
        System.out.println(triangleNumber4(new int[]{7,0,0,0}));
    }
}
// [2,2,3,4,5,6]
//  ^ ^   ^

// [2,2,3,4]
//[4,2,3,4]
// [24,3,82,22,35,84,19]