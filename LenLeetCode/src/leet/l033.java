package leet;

import java.util.Arrays;

public class l033 {
    public static int search(int[] nums, int target) {
        int mid = 0, left_max=-99999, left_min=nums[0], right_max=nums[nums.length-1], right_min=99999;
        for (int i1=1; i1<nums.length; i1++){
            if (nums[i1-1]>nums[i1]){
                mid = i1;
                right_min = nums[i1];
                left_max = nums[i1-1];
                break;
            }
        }
        int res=-1;
        if (left_min<=target & target<=left_max){
            res = binSearch(Arrays.copyOfRange(nums, 0, mid), target);
        }else if (right_min<=target & target<=right_max){
            res = binSearch(Arrays.copyOfRange(nums, mid, nums.length), target);
            res = res!=-1 ? res+mid : res;
        }
        return res;
    }

    public static int binSearch(int[] inputs, int target){
        int low=0, high=inputs.length-1, middle=0;
        while (low<=high){
            middle = (low+high)/2;
            if (inputs[middle]>target){
                high = middle-1;
            }else if (inputs[middle]<target){
                high = middle+1;
            }else return middle;
        }
        return -1;
    }

    public static void main(String[] arg){
        int[] input1 = new int[]{4,5,6,7,0,1,2};
        System.out.println(search(input1, 0));
    }
}
