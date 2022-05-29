package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l448 {
    public static void main(String[] args) {
        int[] in1 = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(Arrays.toString(findDisappearedNumbers(in1).toArray()));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int length = nums.length;
        quicksort(nums, 0, nums.length-1);
        for (int i1=nums.length-1; i1>=0; i1--){
            if (nums[i1]>length){
                while (nums[i1]>=length) i1--;
            }else if (nums[i1]==length){
                while (nums[i1]==length) i1--;
                length--;
            }else {
                res.add(nums[i1]);
            }
        }
        return res;
    }

    public static void quicksort(int[] list, int start, int end){
        int s=start, e=end, exchange, compare;
        if (s>e)return;
        compare = list[s];
        while (s<e){
            while (s<e && compare<=list[e]) e--;
            while (s<e && compare>=list[s]) s++;
            if (s<e){
                exchange = list[s];
                list[s] = list[e];
                list[e] = exchange;
            }
        }
        list[start] = list[s];
        list[s] = compare;
        quicksort(list, start, e-1);
        quicksort(list, e+1, end);
    }
}
