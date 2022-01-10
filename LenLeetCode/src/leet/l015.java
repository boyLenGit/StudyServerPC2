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
        int zero_position = Arrays.binarySearch(nums, 0);
        List<Integer> inputs = Arrays.stream(nums).boxed().collect(Collectors.toList());
//        for(int i1=0, i2=inputs.size()-1; i1<i2; i1++, i2--){
//
//        }
        int sum;
        for (int i1=0; i1<inputs.size(); i1++){
            if (inputs.get(i1)>0) break;
            for (int i2=i1+1, i3=inputs.size()-1; i2<inputs.size(); ){
                sum = inputs.get(i1) + inputs.get(i2) + inputs.get(i3);
                if (sum==0){
                    result.add(new ArrayList<>(Arrays.asList(inputs.get(i1), inputs.get(i2), inputs.get(i3))));
                }else {
                    if (sum>0){
                        i3--;
                        continue;
                    }else {
                        i2++;
                        continue;
                    }
                }
            }
        }


        result.add(new ArrayList<>(Arrays.asList(-1,0,1)));
        result.add(new ArrayList<>(Arrays.asList(-1,-1,2)));
        return result;
    }

    public static void main(String[] args){
        List<List<Integer>> result = threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(result);
    }
}

// -4 -1 -1 0 1 2

