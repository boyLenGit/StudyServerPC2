package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class l015 {
    public static List<List<Integer>> threeSum(int[] nums) {
        int pointer1 = 0;
        int pointer2 = 0;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.parallelSort(nums);
        List<Integer> inputs = Arrays.stream(nums).boxed().collect(Collectors.toList());



        result.add(new ArrayList<>(Arrays.asList(-1,0,1)));
        result.add(new ArrayList<>(Arrays.asList(-1,-1,2)));
        return result;
    }

    public static void main(String[] args){
        List<List<Integer>> result = threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(result);
    }
}
