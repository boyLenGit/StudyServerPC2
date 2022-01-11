package leet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class l016 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.parallelSort(nums);
        List<Integer> inputs = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i1=0; i1<inputs.size(); i1++){

        }
    }

    public static void main(String[] args){

    }
}
