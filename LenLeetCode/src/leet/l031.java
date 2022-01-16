package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class l031 {
    public static void nextPermutation(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        ArrayList<Integer> itemp = new ArrayList<Integer>();
        List<Integer> list_result = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int isOver = 0;
        for (int i1=nums.length-1; i1>=0; i1--){
            if (i1==nums.length-1) continue;
            if (nums[i1]>nums[i1+1]){
                temp.add(nums[i1]);
                itemp.add(i1);
                continue;
            }else if (nums[i1]<nums[i1+1]){
                for (int i2=0; i2<temp.size(); i2++){
                    if (temp.get(i2)>nums[i1]){
                        list_result.set(itemp.get(i2), nums[i1]);
                        list_result.set(i1, temp.get(i2));
                        isOver = 1;
                        break;
                    }
                }
            }
            if (isOver==1) break;
        }

        // 转换nums
        nums = list_result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
// 453751643