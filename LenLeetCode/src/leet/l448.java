package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//[1,1,2,2]
public class l448 {
    public static void main(String[] args) {
        int[] in1 = new int[]{1,1,2,2};
        System.out.println(Arrays.toString(findDisappearedNumbers2(in1).toArray()));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int length = nums.length;
        quicksort(nums, 0, nums.length-1);
        for (int i1=nums.length-1; i1>=0; i1--){
            if (nums[i1]>length){
                while (i1>0 && nums[i1-1]>=length) i1--;
                if (nums[i1]==length) length--;
            }else if (nums[i1]==length){
                while (i1>0 && nums[i1-1]==length) i1--;
                length--;
            }else {
                while (nums[i1]<length) {
                    res.add(length--);
                }
                if (nums[i1]==length) length--;
            }
        }
        while (length!=0) res.add(length--);
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

    // 力扣评论区方法
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i1=0; i1<nums.length; i1++){
            if (nums[i1]<nums.length && nums[nums[i1]]>0) nums[nums[i1]] = -nums[nums[i1]];
        }
        for (int i1=0; i1<nums.length; i1++){
            if (nums[i1]>=0) res.add(i1+1);
        }
        return res;
    }
}
