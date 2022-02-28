package leet;

public class l198 {
    public static int rob(int[] nums) {
        int ret = 0;
        for (int i1=0; i1<nums.length; i1++){
            if (i1+1<nums.length && nums[i1]<nums[i1+1]){
                ret += nums[i1+1];
                i1=i1+2;
            }else {
                ret += nums[i1];
                i1++;
            }
        }
        return ret;
    }

    public static void main(String[] arg){
        int[] input1 = new int[]{1,2,3,1};
        System.out.println(rob(input1));
    }
}
