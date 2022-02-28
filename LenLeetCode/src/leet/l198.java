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
                    i1=i1+2+2;
                }else if (max==s_1_3){
                    ret += nums[i1+1];
                    i1=i1+2;
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

    public static void main(String[] arg){
        int[] input1 = new int[]{1,7,9,4};
        System.out.println(rob2(input1));
    }
}
//[1,2,1,1]
// [1,7,9,4] 1,7,9,1
// [4,1,2,7,5,3,1]