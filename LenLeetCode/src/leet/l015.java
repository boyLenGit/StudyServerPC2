package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class l015 {
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length==0 | nums.length==1) return new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.parallelSort(nums);
        List<Integer> inputs = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int sum;
        for (int i1=0; i1<inputs.size(); i1++){
            if (inputs.get(i1)>0) break;
            for (int i2=i1+1, i3=inputs.size()-1; i2<i3; ){
                sum = inputs.get(i1) + inputs.get(i2) + inputs.get(i3);
                if (sum==0){
                    result.add(new ArrayList<>(Arrays.asList(inputs.get(i1), inputs.get(i2), inputs.get(i3))));
                    i2++;
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
        for (int i1=0; i1<result.size(); i1++){
            if (i1!=0){
                if (result.get(i1).equals(result.get(i1-1))) result.remove(i1);
                i1--;
            }
        }
        return result;
    }

    public static void main(String[] args){

        List<List<Integer>> result = threeSum(new int[]{0,0,0,0});
        System.out.println(result);
        // [0,0,0,0]
        // -1,0,1,2,-1,-4
    }
}

// -4 -1 -1 0 1 2

