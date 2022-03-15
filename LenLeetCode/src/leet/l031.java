package leet;

import java.util.ArrayList;
import java.util.Arrays;


public class l031 {
    public static void nextPermutation(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> itemp = new ArrayList<>();
        int isOver = 0;
        int index_sort_start = 0;
        for (int i1=nums.length-1; i1>=0; i1--){
            if (i1==nums.length-1) {
                temp.add(nums[i1]);
                itemp.add(i1);
                continue;
            }
            if (nums[i1]>nums[i1+1]){
                temp.add(nums[i1]);
                itemp.add(i1);
                continue;
            }else if (nums[i1]<nums[i1+1]){
                for (int i2=0; i2<temp.size(); i2++){
                    if (temp.get(i2)>nums[i1]){
                        nums[itemp.get(i2)] = nums[i1];
                        nums[i1] = temp.get(i2);
                        index_sort_start = i1+1;
                        isOver = 1;
                        break;
                    }
                }
            }
            if (isOver==1) {
                int[] sorted = Arrays.copyOfRange(nums, index_sort_start, nums.length);
                Arrays.sort(sorted);
                int cnt = 0;
                // 针对15432的情况（答案应为：21345）
                for (int i3=index_sort_start; i3<nums.length; i3++){
                    nums[i3] = sorted[cnt];
                    cnt++;
                }
                break;
            }
        }
        if (isOver==0) Arrays.sort(nums);
    }

    public static void main(String[] args){
        nextPermutation(new int[]{2,3,1});
    }
}
// 453751643