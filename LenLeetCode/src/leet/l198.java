package leet;

public class l198 {
    public static int rob(int[] nums) {
        int ret = 0;
        for (int i1=0; i1<nums.length; i1++){
            if (i1+3<nums.length && nums[i1]+nums[i1+2]<nums[i1+1]+nums[i1+3]){
                ret += nums[i1+1];
                i1=i1+2;
            }else if (i1+3==nums.length && nums[i1+1]>=nums[i1+2]+nums[i1]){
                ret += nums[i1+1];
                i1=i1+2;
            }else if (i1+2==nums.length && nums[i1]<nums[i1+1]){
                ret += nums[i1+1];
                i1++;
            }else {
                ret += nums[i1];
                i1++;
            }
        }
        return ret;
    }

    public static int rob2(int[] nums) {
        int ret = 0;
        for (int i1=0; i1<nums.length; i1++){
            if (i1+3<nums.length){
                int s_0_2 = nums[i1]+nums[i1+2];
                int s_0_3 = nums[i1]+nums[i1+3];
                int s_1_3 = nums[i1+1]+nums[i1+3];
                int max = Math.max(Math.max(s_0_2, s_0_3), s_1_3);
                if (max==s_0_3) {
                    ret += nums[i1] + nums[i1+3];
                    i1=i1+5-1;
                }else if (max==s_1_3){
                    ret += nums[i1+1];
                    i1=i1+2;
                }else {
                    ret += nums[i1] + nums[i1+2];
                    i1=i1+4-1;
                }
            }else if (i1+3==nums.length && nums[i1+1]>=nums[i1+2]+nums[i1]){
                ret += nums[i1+1];
                i1=i1+2;
            }else if (i1+2==nums.length && nums[i1]<nums[i1+1]){
                ret += nums[i1+1];
                i1++;
            }else {
                ret += nums[i1];
                i1++;
            }
        }
        return ret;
    }

    public static int rob3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }

    public static void main(String[] arg){
        int[] input1 = new int[]{1,2,3,1};
        lenSortDFX(input1, 0, input1.length-1);
        System.out.println();
        System.out.println(rob3(input1));
    }

    public static void lenSortDFX(int[] inputs, int start, int end){
        int i1=start, i2=end, exchange, compare;
        if (start>end)return;
        compare = inputs[start];
        while (i1<i2){
            while (inputs[i2]>compare && i1<i2) i2--;
            while (inputs[i1]<compare && i1<i2) i1++;
            if (i1<i2){
                exchange = inputs[i1];
                inputs[i1] = inputs[i2];
                inputs[i2] = exchange;
            }
        }
        inputs[start] = inputs[i1];
        inputs[i1] = compare;
        lenSortDFX(inputs, 0, i1-1);
        lenSortDFX(inputs, i1+1, inputs.length-1);
    }
}
//[1,2,3,1]
//[2,7,9,3,1]
// [1,2,1,1]
// [1,7,9,4] 1,7,9,1
// [4,1,2,7,5,3,1]
// [2,4,8,9,9,3]
//  1   1   1