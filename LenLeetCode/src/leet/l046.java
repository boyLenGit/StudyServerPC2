package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class l046 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int num: nums){
            result.add(new ArrayList<>(Collections.singleton(num)));
        }
        dg(nums, result);
        return result;
    }

    public static void dg(int[] ilist, List<List<Integer>> result){
        List<List<Integer>> temp = new ArrayList<>();
        List<Integer> single_temp = new ArrayList<>();
        for (List<Integer> lists : result){
             for (Integer integer : ilist){
                 if (!lists.contains(integer)) {  // 如果不包含该字符，则add上
                     single_temp.addAll(lists);
                     single_temp.add(integer);
                     temp.add(single_temp);
                 }
                 single_temp = new ArrayList<>();
             }
        }
        result = temp;
        if (result.get(0).size()!=ilist.length) dg(ilist, result);
    }

    public static void main(String[] a){
        List<List<Integer>> result = permute(new int[]{1,2,3});
        System.out.println(Arrays.toString(result.toArray()));
    }
}
