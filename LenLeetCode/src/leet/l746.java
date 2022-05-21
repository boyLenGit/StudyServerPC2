package leet;

import java.util.ArrayList;
import java.util.Arrays;

public class l746 {
    public static void main(String[] args) {
        Solution746 solution746 = new Solution746();
//        System.out.println(solution746.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
        System.out.println(Solution746.momo());
    }
}


class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        int res0 = cost[0];
        for (int i1=0; i1<cost.length; i1++){
            if (i1+2<cost.length){
                if (cost[i1+1]<cost[i1+2]){
                    res0 += cost[i1+1];
                }else {
                    res0 += cost[i1+2];
                    i1++;
                }
            }
        }

        int temp = res0;
        res0 = cost[1];
        for (int i1=1; i1<cost.length; i1++){
            if (i1+2<cost.length){
                if (cost[i1+1]<cost[i1+2]){
                    res0 += cost[i1+1];
                }else {
                    res0 += cost[i1+2];
                    i1++;
                }
            }
        }
        return Math.min(res0, temp);
    }

    public static int momo(){
        String string = "123456";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i1=0; i1<string.length(); i1=i1+2){
            list.add(Integer.valueOf(string.substring(i1, i1+2)));
        }
        System.out.println(Arrays.toString(list.toArray()));
        return 0;
    }
}