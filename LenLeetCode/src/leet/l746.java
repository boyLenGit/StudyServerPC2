package leet;

import java.util.ArrayList;
import java.util.Arrays;

public class l746 {
    public static void main(String[] args) {
        Solution746 solution746 = new Solution746();
//        System.out.println(solution746.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
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

}