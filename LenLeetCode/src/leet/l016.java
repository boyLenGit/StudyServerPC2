package leet;

import util.LenLog;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class l016 {
    // 双指针法
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.parallelSort(nums);
        List<Integer> inputs = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int sum_min = inputs.get(0) + inputs.get(1) + inputs.get(2);
        for (int i1=0; i1<inputs.size(); i1++){
            for (int i2=i1+1, i3=inputs.size()-1; i2<i3; ){
                int sum = inputs.get(i1) + inputs.get(i2) + inputs.get(i3);
                if (target-sum==0) return sum;
                sum_min = Math.abs(target-sum) < Math.abs(target-sum_min) ? sum : sum_min;
                if (target>sum) i2++;
                else i3--;
            }
        }
        return sum_min;
    }

    public static void main(String[] args){
        int[] input1 = new int[] {-1,2,1,-4};
        int result = threeSumClosest(input1, 1);
        LenLog.printString(String.valueOf(result));
    }
}
