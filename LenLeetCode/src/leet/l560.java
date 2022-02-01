package leet;

import java.util.Arrays;
import java.util.HashMap;

public class l560 {
    public static int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum;
        for (int i1=0; i1<nums.length; i1++){
            sum = nums[i1];
            for (int i2=i1+1; i2<nums.length; i2++){
                sum += nums[i2];
                if (sum==k) res++;
            }
            if (nums[i1]==k) res++;
        }
        return res;
    }

    public static int subarraySum2(int[] nums, int k) {
        // 用动态规划与哈希表
        int cnt=0;
        int sum=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i1=0; i1<nums.length; i1++){
            if (map.containsKey(sum-k)) cnt += map.get(sum-k);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return cnt;
    }

    public static void main(String[] arg){
        int[] in1 = new int[]{28,54,7,-70,22,65,-6};
        System.out.println(subarraySum(in1, 100));
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,10);
        map.put(2, 20);
        System.out.println(map.remove(1));
    }


}
//[1,-1,0]
//0
// [28,54,7,-70,22,65,-6]
//100