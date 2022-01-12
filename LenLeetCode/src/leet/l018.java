package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l018 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.parallelSort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int sum;
        for (int i1=0; i1<nums.length; ){
            if (nums[i1]>0) break;
            for (int i2=i1+1; i2<nums.length; i2++){
                for (int i3=i2+1, i4=nums.length-1; i3<i4; ){
                    sum = nums[i1] + nums[i2] + nums[i3] + nums[i4];
                    if (sum==0) result.add(new ArrayList<>(Arrays.asList(nums[i1], nums[i2], nums[i3], nums[i4])));
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
        int[] inputs = new int[]{1,0,-1,0,-2,2};
        List<List<Integer>> result = fourSum(inputs, 0);
        System.out.println(result);
    }
}
