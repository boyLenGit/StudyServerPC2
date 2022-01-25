package leet;

public class l152 {
    public static int maxProduct(int[] nums) {
        // 全是错误,无法通过
        if (nums.length==0) return 0;
        int res = nums[0];
        int res_temp = nums[0];
        int res_temp_negative = nums[0];
        for (int i1=1; i1<nums.length; i1++){
            if (nums[i1-1]<0 & nums[i1]>0){
                res_temp_negative = nums[i1];
            }
            res_temp = nums[i1-1]==0 ? nums[i1] : nums[i1]*res_temp;
            res_temp_negative = nums[i1-1]<0 & nums[i1]>0 ? res_temp_negative : res_temp_negative*nums[i1];
            res = Math.max(Math.max(res, nums[i1]), Math.max(res_temp_negative, res_temp));
        }
        for (int i1=2; i1<nums.length; i1++){
            if (nums[i1-1]<0 & nums[i1-2]<0 & nums[i1]!=0){
                res_temp = nums[i1-1]*nums[i1-2];
                for (int i2=i1; i2<nums.length; i2++){
                    res_temp *= nums[i2];
                    res = Math.max(res_temp, res);
                }
            }else if (nums[i1-1]<0 & nums[i1-2]<0 & nums[i1]==0) res = Math.max(res, nums[i1-1]*nums[i1-2]);
        }
        return res;
    }

    public static int maxProduct2(int[] nums) {
        int res = nums[0];
        int res_temp = 1;
        for (int i1=0; i1<nums.length; i1++){
            if (nums[i1]==0){
                res_temp = 1;
            }else res_temp *= nums[i1];
            res = Math.max(res, res_temp);
        }
        res_temp = 1;
        for (int i1=nums.length-1; i1>=0; i1--){
            if (nums[i1]==0){
                res_temp = 1;
            }else res_temp *= res_temp;
            res = Math.max(res, res_temp);
        }
        return res;
    }

    public static int maxProduct_leetcode2(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1; //一个保存最大的，一个保存最小的。
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){ //如果数组的数是负数，那么会导致最大的变最小的，最小的变最大的。因此交换两个的值。
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }

    public static void main(String[] sa){
        int[] inputs = new int[]{2,-5,-2,-4,3};
        System.out.println(maxProduct2(inputs));
    }
}
// [-3,-1,-1]
// [-5,0,2]
// [2,3,-2,4]
//[-2,0,-1]
// [2,-5,-2,-4,3]
// [1,0,-1,2,3,-5,-2]
// [1,2,-1,-2,2,1,-2,1]
// [-1,-2,-2,-2,3,2,-2,0]
