package leet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class l016 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.parallelSort(nums);
        List<Integer> inputs = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int sum_min = 0;
        for (int i1=0; i1<inputs.size(); i1++){
            for (int i2=0, i3=inputs.size()-1; i2<i3; ){
                int sum = inputs.get(i1) + inputs.get(i2) + inputs.get(i3);
                if (Math.abs(target-sum)==0) return 999;
                sum_min = Math.abs(target-sum) < Math.abs(target-sum_min) ? sum : sum_min;
            }
        }
    }

    public static void main(String[] args){

    }
}
