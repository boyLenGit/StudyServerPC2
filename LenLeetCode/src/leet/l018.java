package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l018 {
    // 链表法
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length<=3) return new ArrayList<>();
        Arrays.parallelSort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int sum;
        List<Integer> to_add;
        List<Integer> to_add_temp = new ArrayList<>();
        for (int i1=0; i1<nums.length; i1++){
            if (nums[i1]>target & target>0) break;
            for (int i2=i1+1; i2<nums.length; i2++){
                for (int i3=i2+1, i4=nums.length-1; i3<i4; ){
                    sum = nums[i1] + nums[i2] + nums[i3] + nums[i4];
                    if (sum==target) {
                        to_add = new ArrayList<>(Arrays.asList(nums[i1], nums[i2], nums[i3], nums[i4]));
                        if (!to_add_temp.equals(to_add)){
                            result.add(to_add);
                            to_add_temp = to_add;
                        }
                        i3++;
                    }
                    else if (sum>target) i4--;
                    else i3++;
                }
            }
        }
        // 遍历整个数组，排除重复值
        for (int i1=0; i1<result.size(); i1++){
            for (int i2=i1+1; i2<result.size(); i2++){
                if (result.get(i1).equals(result.get(i2))){
                    result.remove(i2);
                    i2--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] inputs = new int[]{-5,-2,-4,-2,-5,-4,0,0};
        List<List<Integer>> result = fourSum(inputs, -13);
        System.out.println(result);
        // [2,2,2,2,2]
        //8
        // [0,0,0,0]
        //0
        // [-1,0,1,2,-1,-4]
        //-1
        // [1,-2,-5,-4,-3,3,3,5]
        //-11
        // [-5,-2,-4,-2,-5,-4,0,0]
        //-13
    }
}
