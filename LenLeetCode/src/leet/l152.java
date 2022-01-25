package leet;

public class l152 {
    public static int maxProduct(int[] nums) {
        if (nums.length==0) return 0;
        int res = nums[0];
        int res_temp = nums[0];
        int res_temp_negative = nums[0];
        for (int i1=1; i1<nums.length; i1++){
            if (nums[i1-1]<0){
                res_temp_negative = nums[i1];
            }
            res_temp = nums[i1-1]==0 ? nums[i1] : nums[i1]*res_temp;
            res_temp_negative = nums[i1-1]<0 ? res_temp_negative : res_temp_negative*nums[i1];
            res = Math.max(Math.max(res, nums[i1]), Math.max(res_temp_negative, res_temp));
        }
        res_temp = nums[0];
        for (int i1=2; i1<nums.length; i1++){
            if (nums[i1-1]<0 & nums[i1-2]<0 & nums[i1]!=0){
                res_temp = nums[i1]*nums[i1-1]*nums[i1-2];
                continue;
            }
            res_temp *= nums[i1];
            res = Math.max(res_temp, res);
        }
        return res;
    }

    public static void main(String[] sa){
        int[] inputs = new int[]{2,-5,-2,-4,3};
        System.out.println(maxProduct(inputs));
    }
}
// [-3,-1,-1]
// [-5,0,2]
// [2,3,-2,4]
//[-2,0,-1]
// [2,-5,-2,-4,3]
