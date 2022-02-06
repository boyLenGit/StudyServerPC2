package leet;

import java.util.Arrays;
import java.util.HashMap;

public class l169 {
    public int majorityElement(int[] nums) {
        lenSort(nums);
        int times=0, time_max=0,res=nums[0];
        for (int i1=1; i1<nums.length; i1++){
            if (nums[i1-1]==nums[i1]) {
                times++;
                if (time_max<times) {
                    time_max = times;
                    res = nums[i1];
                }
            }
            else times = 0;
        }
        return res;
    }

    public static void lenSort(int[] inputs){
        dg(inputs, 0, inputs.length-1);
    }

    public static void dg(int[] inputs, int start, int end){
        int i1, i2, exchange, compare;
        if (start>end) return;
        i1 = start;
        i2 = end;
        compare = inputs[start];
        while (i1<i2){
            while (compare>=inputs[i2] && i1<i2) i2--;
            while (compare<=inputs[i1] && i1<i2) i1++;
            if (i1<i2){
                exchange = inputs[i1];
                inputs[i1] = inputs[i2];
                inputs[i2] = exchange;
            }
        }
        inputs[start] = inputs[i1];
        inputs[i1] = compare;
        dg(inputs, start, i1-1);
        dg(inputs, i1+1, end);
    }

    public static int majorityElement2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int times_max = 0, item_max=nums[0];
        for (int i1=0; i1<nums.length; i1++){
            if (map.containsKey(nums[i1])){
                map.put(nums[i1], map.get(nums[i1])+1);
                if (map.get(nums[i1])>times_max){
                    item_max = nums[i1];
                    times_max = map.get(nums[i1]);
                }
            }else map.put(nums[i1], 1);
        }
        return item_max;
    }

    public static int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] ar){
        System.out.println(majorityElement3(new int[]{1,2,3,4,5,6,7,8,9,9}));
    }
}
