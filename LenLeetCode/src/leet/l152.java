package leet;

public class l152 {
    public static int maxProduct(int[] nums) {
        if (nums.length==0) return 0;
        int res = nums[0];
        int res_temp = nums[0];
        int res_temp_negative = 1;
        int cnt_negative = 0;
        for (int i1=1; i1<nums.length; i1++){
            if (nums[i1]==0){
                res = Math.max(res, nums[i1]);
                if (i1+1<nums.length) {
                    res_temp = nums[i1+1];
                    i1++;
                }
                else return res;
                continue;
            }else if (nums[i1-1]<0){
                res_temp_negative = 1;
            }
            res_temp *= nums[i1];
            res_temp_negative *= nums[i1];
            res = Math.max(Math.max(res, res_temp), res_temp_negative);
        }
        return res;
    }

    public static void main(String[] sa){
        int[] inputs = new int[]{-3,-1,-1};
        System.out.println(maxProduct(inputs));
    }
}
// [-3,-1,-1]