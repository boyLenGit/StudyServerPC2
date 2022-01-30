package leet;

import java.util.Arrays;

public class l560 {
    public static int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum;
        for (int i1=0; i1<nums.length; i1++){
            if (nums[i1]<k){
                sum = 0;
                for (int i2=i1+1; i2<nums.length; i2++){
                    sum += nums[i2];
                    if (sum>k) break;
                    else if (sum==k) {
                        res++;
                        break;
                    }
                }
            }

        }
        return res;
    }

    public static void main(String[] arg){
        int[] in1 = new int[]{1,1,1};
        System.out.println(subarraySum(in1, 2));
    }
}
