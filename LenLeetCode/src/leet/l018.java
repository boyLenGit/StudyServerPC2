package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l018 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length<=3) return null;
        Arrays.parallelSort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int sum;
        List<Integer> to_add;
        List<Integer> to_add_temp = new ArrayList<>(Arrays.asList(target, target, target, target));
        for (int i1=0; i1<nums.length; i1++){target
            if (nums[i1]>target) break;
            for (int i2=i1+1; i2<nums.length; i2++){
                for (int i3=i2+1, i4=nums.length-1; i3<i4; ){
                    sum = nums[i1] + nums[i2] + nums[i3] + nums[i4];
                    if (sum==0) {
                        to_add = new ArrayList<>(Arrays.asList(nums[i1], nums[i2], nums[i3], nums[i4]));
                        if (!to_add_temp.equals(to_add)){
                            result.add(to_add);
                            to_add_temp = to_add;
                        }
                        i3++;
                    }
                    else if (sum>0) i4--;
                    else i3++;
                }
            }
        }
        for (int i1=0; i1<result.size(); i1++){
            if (i1!=0){
                for (int i2=i1+1; i2<result.size(); i2++){
                    if (result.get(i1).equals(result.get(i2))){
                        result.remove(i2);
                        i2--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] inputs = new int[]{2,2,2,2,2};
        List<List<Integer>> result = fourSum(inputs, 8);
        System.out.println(result);
        // [2,2,2,2,2]
        //8
    }
}
